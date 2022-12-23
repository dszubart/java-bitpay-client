/*
 * Copyright (c) 2019 BitPay
 */

package com.bitpay.sdk.client;

import com.bitpay.sdk.exceptions.BitPayException;
import com.bitpay.sdk.model.Payout.PayoutRecipient;
import com.bitpay.sdk.model.Payout.PayoutRecipients;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PayoutRecipientsClientTest extends AbstractClientTest {

    @Test
    public void it_should_submit_payout_recipients() throws BitPayException {
        // given
        this.addServerJsonResponse(
            "/recipients",
            "POST",
            getPreparedJsonDataFromFile("submitPayoutRecipientsRequest.json"),
            getPreparedJsonDataFromFile("getPayoutsResponse.json")
        );

        // when
        List<PayoutRecipient> result = this.getTestedClass().submitPayoutRecipients(this.getExamplePayoutRecipients());

        // then
        Assertions.assertEquals(2, result.size());

        Assertions.assertNull(result.get(0).getGuid());
        Assertions.assertEquals("john@doe.com", result.get(0).getEmail());
        Assertions.assertEquals("John Doe", result.get(0).getLabel());
        Assertions.assertEquals("payout_20210527", result.get(0).getReference());
        Assertions.assertEquals("https://yournotiticationURL.com/wed3sa0wx1rz5bg0bv97851eqx", result.get(0).getNotificationURL());
        Assertions.assertNull(result.get(0).getAccount());
        Assertions.assertEquals("complete", result.get(0).getStatus());
        Assertions.assertEquals("JMwv8wQCXANoU2ZZQ9a9GH", result.get(0).getId());
        Assertions.assertEquals("7qohDf2zZnQK5Qanj8oyC2", result.get(0).getShopperId());
        Assertions.assertEquals("9pVLfvdjt59q1JiY2JEsf2uzeeEpSqDwwfRAzuFr9CcrxZX25rTnP6HdRhsMBGLArz", result.get(0).getToken());
        Assertions.assertNull(result.get(0).getSupportPhone());

        Assertions.assertNull(result.get(0).getGuid());
        Assertions.assertEquals("jane@doe.com", result.get(1).getEmail());
        Assertions.assertEquals("Jane Doe", result.get(1).getLabel());
        Assertions.assertEquals("payout_20210528", result.get(1).getReference());
        Assertions.assertEquals("https://yournotiticationURL.com/wed3sa0wx1rz5bg0bv97851eqx", result.get(1).getNotificationURL());
        Assertions.assertNull(result.get(1).getAccount());
        Assertions.assertEquals("cancelled", result.get(1).getStatus());
        Assertions.assertEquals("KMXZeQigXG6T5abzCJmTcH", result.get(1).getId());
        Assertions.assertEquals("7qohDf2zZnQK5Qanj8oyC2", result.get(1).getShopperId());
        Assertions.assertEquals("9pVLfvdjt59q1JiY2JEsf2hr5FsjimfY4qRLFi85tMiXSCkJ9mQ2oSQqYKVangKaro", result.get(1).getToken());
        Assertions.assertNull(result.get(1).getSupportPhone());
    }

    @Test
    public void it_should_get_payout_recipients_by_status() throws BitPayException {
        // given
        this.addServerJsonResponse(
            "/recipients?token=somePayoutToken&status=invited",
            "GET",
            null,
            getPreparedJsonDataFromFile("getPayoutRecipientsResponse.json")
        );

        // when
        List<PayoutRecipient> result = this.getTestedClass().getPayoutRecipients("invited", null, null);

        // then
        Assertions.assertEquals(2, result.size());

        Assertions.assertNull(result.get(0).getGuid());
        Assertions.assertEquals("alice@email.com", result.get(0).getEmail());
        Assertions.assertEquals("Alice", result.get(0).getLabel());
        Assertions.assertEquals("invited", result.get(0).getStatus());
        Assertions.assertEquals("JA4cEtmBxCp5cybtnh1rds", result.get(0).getId());
        Assertions.assertNull(result.get(0).getShopperId());
        Assertions.assertEquals("2LVBntm7z92rnuVjVX5ZVaDoUEaoY4LxhZMMzPAMGyXcejgPXVmZ4Ae3oGaCGBFKQf", result.get(0).getToken());

        Assertions.assertNull(result.get(0).getGuid());
        Assertions.assertEquals("bob@email.com", result.get(1).getEmail());
        Assertions.assertEquals("Bob", result.get(1).getLabel());
        Assertions.assertEquals("invited", result.get(1).getStatus());
        Assertions.assertEquals("X3icwc4tE8KJ5hEPNPpDXW", result.get(1).getId());
        Assertions.assertNull(result.get(1).getShopperId());
        Assertions.assertEquals("2LVBntm7z92rnuVjVX5ZVaDoUEaoY4LxhZMMzPAMGyXrrBAB9vRY3BVxGLbAa6uEx7", result.get(1).getToken());
    }

    @Test
    public void it_should_get_payout_recipient() throws BitPayException {
        // given
        this.addServerJsonResponse(
            "/recipients/JA4cEtmBxCp5cybtnh1rds?token=somePayoutToken",
            "GET",
            null,
            getPreparedJsonDataFromFile("getPayoutRecipientResponse.json")
        );

        // when
        PayoutRecipient result = this.getTestedClass().getPayoutRecipient("JA4cEtmBxCp5cybtnh1rds");

        // then
        Assertions.assertNull(result.getGuid());
        Assertions.assertEquals("john.smith@email.com", result.getEmail());
        Assertions.assertEquals("John Smith", result.getLabel());
        Assertions.assertEquals("invited", result.getStatus());
        Assertions.assertEquals("JA4cEtmBxCp5cybtnh1rds", result.getId());
        Assertions.assertNull(result.getShopperId());
        Assertions.assertEquals("2LVBntm7z92rnuVjVX5ZVaDoUEaoY4LxhZMMzPAMGyXcejgPXVmZ4Ae3oGaCGBFKQf", result.getToken());
    }

    @Test
    public void it_should_update_payout_recipient() throws BitPayException {
        // given
        this.addServerJsonResponse(
            "/recipients/X3icwc4tE8KJ5hEPNPpDXW",
            "PUT",
            null,
            getPreparedJsonDataFromFile("updatePayoutRecipientResponse.json")
        );
        PayoutRecipient payoutRecipient = new PayoutRecipient();
        payoutRecipient.setLabel("Bob123");

        // when
        PayoutRecipient result = this.getTestedClass().updatePayoutRecipient("X3icwc4tE8KJ5hEPNPpDXW", payoutRecipient);

        // then
        Assertions.assertEquals("Bob123", result.getLabel());
    }

    @Test
    public void it_should_delete_payout_recipient() throws BitPayException {
        // given
        this.addServerJsonResponse(
            "/recipients/X3icwc4tE8KJ5hEPNPpDXW?token=somePayoutToken",
            "DELETE",
            null,
            getPreparedJsonDataFromFile("deletePayoutRecipientResponse.json")
        );

        // when
        Boolean result = this.getTestedClass().deletePayoutRecipient("X3icwc4tE8KJ5hEPNPpDXW");

        // then
        Assertions.assertTrue(result);
    }

    private PayoutRecipients getExamplePayoutRecipients() {
        PayoutRecipient payoutRecipient1 = new PayoutRecipient();
        payoutRecipient1.setEmail("alice@email.com");
        payoutRecipient1.setLabel("Alice");
        PayoutRecipient payoutRecipient2 = new PayoutRecipient();
        payoutRecipient2.setEmail("bob@email.com");
        payoutRecipient2.setLabel("Bob");

       return new PayoutRecipients(Arrays.asList(payoutRecipient1, payoutRecipient2));
    }

    private PayoutRecipientsClient getTestedClass() {
        return new PayoutRecipientsClient(this.getBitPayClient(), this.getAccessTokens(), this.uuidGenerator);
    }
}