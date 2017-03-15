package test;

import controller.BitPay;
import controller.BitPayException;
import model.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BitPayTest3 {

    private BitPay bitpay;

    private static String clientName = "BitPay Java Library Tester3";
    private static String pairingCode;
    private static URI myKeyFile;

    @Before
    public void setUp() throws BitPayException, IOException, URISyntaxException {
        //ensure the second argument (api url) is the same as the one used in setUpOneTime()
        bitpay = new BitPay(myKeyFile, clientName, BitPay.BITPAY_TEST_URL);
    }
    	
	@BeforeClass
	public static void setUpOneTime() throws InterruptedException, IOException, BitPayException, URISyntaxException {
        boolean dumpOut = false;

        //create a key, if a file does exist at the uri, myKeyfile, a new key will be created in the construction of the client
        //ECKey myKey = KeyUtils.createEcKey();

        myKeyFile = new URI("file:///tmp/bitpay_private.key"); //if file exists, it will not overwrite

        //save the somewhere that you can reuse it:
        //this saves a EC key to compressed ASN.1 DER encoded format
        //if you use your own key (not generated by our key utils), then ensure your key is in the above format
        //KeyUtils.saveEcKey(myKey, myKeyFile);

        // This scenario qualifies that this (test) client does not have merchant facade access.
		clientName += " on " + java.net.InetAddress.getLocalHost();
		BitPay bitpay = new BitPay(myKeyFile, clientName, BitPay.BITPAY_TEST_URL);

		// Authorize this client for use with a BitPay merchant account.  This client requires a
		// PAYROLL facades.
        if (!bitpay.clientIsAuthorized(BitPay.FACADE_PAYROLL))
        {
            // Get PAYROLL facade authorization.
            // Obtain a pairingCode from your BitPay account administrator.  When the pairingCode
            // is created by your administrator it is assigned a facade.  To generate payout batches a
            // PAYROLL facade is required.

        	// As an alternative to this client outputting a pairing code, the BitPay account owner
        	// may interactively generate a pairing code via the BitPay merchant dashboard at
        	// https://[test].bitpay.com/dashboard/merchant/api-tokens.  This client can subsequently
        	// accept the pairing code using the following call.

            // bitpay.authorizeClient(pairingCode);

            pairingCode = bitpay.requestClientAuthorization(BitPay.FACADE_PAYROLL);

            // Signal the device operator that this client needs to be paired with a merchant account.
            System.out.println("Info: Client is requesting PAYROLL facade access. Pair this client with your merchant account using the pairing code: " + pairingCode);
            dumpOut = true;
            //we already failed to authorize for a PAYROLL token, therefore we must sleep a bit to try to authorize for any other facade (rate limiter on the api side)
            Thread.sleep(10000);
        }

        if (dumpOut) {
            throw new BitPayException("Error: client is not authorized.");
        }
	}

	@Test
	public void testShouldSubmitPayoutBatch()
	{
        Date date = new Date();
        Date threeDaysFromNow = new Date(date.getTime() + 3 * 24 * 3600 * 1000);
		
		long effectiveDate = threeDaysFromNow.getTime();
		String reference = "My test batch";
		String bankTransferId = "My bank transfer id";
		String currency = "USD";
		List<PayoutInstruction> instructions = Arrays.asList(
			new PayoutInstruction(100.0, "mtHDtQtkEkRRB5mgeWpLhALsSbga3iZV6u", "Alice"),
			new PayoutInstruction(200.0, "mvR4Xj7MYT7GJcL93xAQbSZ2p4eHJV5F7A", "Bob")
		);
		
		PayoutBatch batch = new PayoutBatch(currency, effectiveDate, bankTransferId, reference, instructions);
		try {
			batch = this.bitpay.submitPayoutBatch(batch);
		} catch (BitPayException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
        assertNotNull(batch.getId());
		assertTrue(batch.getInstructions().size() == 2);
	}

}
