/*
 * Copyright (c) 2019 BitPay
 */
package com.bitpay.sdk.util;

import com.bitpay.sdk.model.Payout.PayoutInstructionBtcSummary;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * The type Payout instruction btc summary deserializer.
 */
public class PayoutInstructionBtcSummaryDeserializer extends JsonDeserializer<PayoutInstructionBtcSummary> {

    /**
     * Deserialize to PayoutInstructionBtcSummary.
     *
     * @param jp JsonParser
     * @param dc DeserializationContext
     * @return PayoutInstructionBtcSummary
     * @throws IOException
     */
    @Override
    public PayoutInstructionBtcSummary deserialize(JsonParser jp, DeserializationContext dc) throws IOException {
        Double paid = 0.0;
        Double unpaid = 0.0;
        JsonNode node = jp.getCodec().readTree(jp);

        try {
            String strPaid = (node.get("paid")).asText();
            paid = Double.parseDouble(strPaid);
        } catch (NumberFormatException e) {
        }

        try {
            String strUnpaid = (node.get("unpaid")).asText();
            unpaid = Double.parseDouble(strUnpaid);
        } catch (NumberFormatException e) {
        }

        return new PayoutInstructionBtcSummary(paid, unpaid);
    }
}	
