/*
 * Copyright (c) 2019 BitPay
 */

package com.bitpay.sdk.exceptions;

/**
 * Exception which is extended by other exceptions related with Bill.
 *
 * @see com.bitpay.sdk.exceptions.BillCreationException
 * @see com.bitpay.sdk.exceptions.BillQueryException
 * @see com.bitpay.sdk.exceptions.BillDeliveryException
 * @see com.bitpay.sdk.exceptions.BillUpdateException
 *
 * @see <a href="https://bitpay.com/api/#rest-api-error-codes">Rest API Error Codes</a>
 */
public class BillException extends BitPayException {
    /**
     * Construct the BillException.
     *
     * @param status String [optional] The Exception code to throw.
     * @param message String [optional] The Exception message to throw.
     */
    public BillException(String status, String message) {
        super(status, BuildMessage(message));
    }

    private static String BuildMessage(String message) {
        String BitPayMessage = "An unexpected error occurred while trying to manage the bill";
        String BitPayCode = "BITPAY-BILL-GENERIC";

        if (message.isEmpty() || !message.contains("BITPAY-")) {
            message = BitPayCode + ": " + BitPayMessage + " -> " + message;
        }

        return message;
    }
}