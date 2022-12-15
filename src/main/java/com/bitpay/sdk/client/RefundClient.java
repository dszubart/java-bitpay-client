/*
 * Copyright (c) 2019 BitPay
 */

package com.bitpay.sdk.client;

import com.bitpay.sdk.exceptions.BitPayException;
import com.bitpay.sdk.exceptions.RefundCancellationException;
import com.bitpay.sdk.exceptions.RefundCreationException;
import com.bitpay.sdk.exceptions.RefundQueryException;
import com.bitpay.sdk.exceptions.RefundUpdateException;
import com.bitpay.sdk.model.Facade;
import com.bitpay.sdk.model.Invoice.Refund;
import com.bitpay.sdk.util.AccessTokens;
import com.bitpay.sdk.util.GuidGenerator;
import com.bitpay.sdk.util.JsonMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;

/**
 * The type Refund client.
 */
public class RefundClient {

    private final BitPayClient bitPayClient;
    private final AccessTokens accessTokens;
    private final GuidGenerator guidGenerator;

    /**
     * Instantiates a new Refund client.
     *
     * @param bitPayClient the bit pay client
     * @param accessTokens the access tokens
     * @param guidGenerator GUID generator
     */
    public RefundClient(BitPayClient bitPayClient, AccessTokens accessTokens, GuidGenerator guidGenerator) {
        this.bitPayClient = bitPayClient;
        this.accessTokens = accessTokens;
        this.guidGenerator = guidGenerator;
    }

    /**
     * Create a refund for a BitPay invoice.
     *
     * @param refund Refund request data
     * @return Refund
     * @throws BitPayException BitPayException
     */
    public Refund createRefund(Refund refund) throws BitPayException {
        final Map<String, Object> params = createBasicParamsForCreate(refund);

        Refund result;
        JsonMapper mapper = JsonMapperFactory.create();

        String json;

        try {
            json = mapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            throw new RefundCreationException(null, "failed to serialize Refund object : " + e.getMessage());
        }

        try {
            HttpResponse response = this.bitPayClient.post("refunds/", json, true);
            result = new ObjectMapper().readValue(this.bitPayClient.responseToJsonString(response), Refund.class);
        } catch (BitPayException ex) {
            throw new RefundCreationException(ex.getStatusCode(), ex.getReasonPhrase());
        } catch (Exception e) {
            throw new RefundCreationException(null,
                "failed to deserialize BitPay server response (Refund) : " + e.getMessage());
        }

        return result;
    }

    private Map<String, Object> createBasicParamsForCreate(Refund refund) throws BitPayException {
        String guid = Objects.isNull(refund.getGuid()) ? this.guidGenerator.execute() : refund.getGuid();
        String invoiceId = refund.getInvoice();
        Double amount = refund.getAmount();
        Boolean preview = refund.getPreview();
        Boolean immediate = refund.getImmediate();
        Boolean buyerPaysRefundFee = refund.getBuyerPaysRefundFee();
        String reference = refund.getReference();

        if (invoiceId == null && amount == null) {
            throw new RefundCreationException(null, "Invoice ID, amount and currency are required to issue a refund.");
        }

        final Map<String, Object> params = new HashMap<>();
        params.put("token", this.accessTokens.getAccessToken(Facade.MERCHANT));
        if (invoiceId != null) {
            params.put("invoiceId", invoiceId);
        }
        if (amount != null) {
            params.put("amount", amount);
        }
        if (preview != null) {
            params.put("preview", preview);
        }
        if (immediate != null) {
            params.put("immediate", immediate);
        }
        if (buyerPaysRefundFee != null) {
            params.put("buyerPaysRefundFee", buyerPaysRefundFee);
        }
        if (reference != null) {
            params.put("reference", reference);
        }
        params.put("guid", guid);

        return params;
    }

    /**
     * Retrieve a previously made refund request on a BitPay invoice.
     *
     * @param refundId The BitPay refund ID.
     * @return A BitPay Refund object with the associated Refund object.
     * @throws RefundQueryException RefundQueryException class
     * @throws BitPayException      BitPayException class
     */
    public Refund getById(String refundId) throws RefundQueryException, BitPayException {
        Refund refund;

        final List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("token", this.accessTokens.getAccessToken(Facade.MERCHANT)));

        try {
            HttpResponse response = this.bitPayClient.get("refunds/" + refundId, params, true);
            refund = new ObjectMapper().readValue(this.bitPayClient.responseToJsonString(response), Refund.class);
        } catch (JsonProcessingException e) {
            throw new RefundQueryException(null,
                "failed to deserialize BitPay server response (Refund) : " + e.getMessage());
        } catch (BitPayException ex) {
            throw new RefundQueryException(ex.getStatusCode(), ex.getReasonPhrase());
        } catch (Exception e) {
            throw new RefundQueryException(null,
                "failed to deserialize BitPay server response (Refund) : " + e.getMessage());
        }

        return refund;
    }

    /**
     * Retrieve refund request on a BitPay invoice by Guid.
     * @param guid Guid
     * @return Refund
     * @throws BitPayException BitPayException
     */
    public Refund getByGuid(String guid) throws BitPayException {
        Refund refund;

        final List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("token", this.accessTokens.getAccessToken(Facade.MERCHANT)));

        try {
            HttpResponse response = this.bitPayClient.get("refunds/guid/" + guid, params, true);
            refund = new ObjectMapper().readValue(this.bitPayClient.responseToJsonString(response), Refund.class);
        } catch (JsonProcessingException e) {
            throw new RefundQueryException(null,
                "failed to deserialize BitPay server response (Refund) : " + e.getMessage());
        } catch (BitPayException ex) {
            throw new RefundQueryException(ex.getStatusCode(), ex.getReasonPhrase());
        } catch (Exception e) {
            throw new RefundQueryException(null,
                "failed to deserialize BitPay server response (Refund) : " + e.getMessage());
        }

        return refund;
    }

    /**
     * Retrieve all refund requests on a BitPay invoice.
     *
     * @param invoiceId The BitPay invoice object having the associated refunds.
     * @return A list of BitPay Refund objects with the associated Refund objects.
     * @throws RefundQueryException RefundQueryException class
     * @throws BitPayException      BitPayException class
     */
    public List<Refund> getRefunds(String invoiceId) throws RefundQueryException, BitPayException {
        List<Refund> refunds;
        final List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("token", this.accessTokens.getAccessToken(Facade.MERCHANT)));
        params.add(new BasicNameValuePair("invoiceId", invoiceId));

        try {
            HttpResponse response = this.bitPayClient.get("refunds/", params, true);
            refunds = Arrays.asList(new ObjectMapper().readValue(this.bitPayClient.responseToJsonString(response), Refund[].class));
        } catch (JsonProcessingException e) {
            throw new RefundQueryException(null,
                "failed to deserialize BitPay server response (Refund) : " + e.getMessage());
        } catch (BitPayException ex) {
            throw new RefundQueryException(ex.getStatusCode(), ex.getReasonPhrase());
        } catch (Exception e) {
            throw new RefundQueryException(null,
                "failed to deserialize BitPay server response (Refund) : " + e.getMessage());
        }

        return refunds;
    }

    /**
     * Update the status of a BitPay invoice.
     *
     * @param refundId A BitPay refund ID.
     * @param status   The new status for the refund to be updated.
     * @return A BitPay generated Refund object.
     * @throws RefundUpdateException RefundUpdateException class
     * @throws BitPayException       BitPayException class
     */
    public Refund updateRefund(String refundId, String status) throws RefundUpdateException, BitPayException {
        final Map<String, String> params = new HashMap<>();
        params.put("token", this.accessTokens.getAccessToken(Facade.MERCHANT));
        if (refundId == null || status == null) {
            throw new RefundUpdateException(null,
                "Updating the refund requires a refund ID and a new status to be set.");
        }
        if (status != null) {
            params.put("status", status);
        }

        JsonMapper mapper = JsonMapperFactory.create();
        String json;
        Refund refund;

        try {
            json = mapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            throw new RefundUpdateException(null, "failed to serialize object : " + e.getMessage());
        }

        try {
            HttpResponse response = this.bitPayClient.update("refunds/" + refundId, json);
            refund = new ObjectMapper().readValue(this.bitPayClient.responseToJsonString(response), Refund.class);
        } catch (BitPayException ex) {
            throw new RefundUpdateException(ex.getStatusCode(), ex.getReasonPhrase());
        } catch (Exception e) {
            throw new RefundUpdateException(null,
                "failed to deserialize BitPay server response (Refund) : " + e.getMessage());
        }

        return refund;
    }

    /**
     * Send a refund notification.
     *
     * @param refundId A BitPay refund ID.
     * @return An updated Refund Object
     * @throws RefundCreationException RefundCreationException class
     * @throws BitPayException         BitPayException class
     */
    public Boolean sendRefundNotification(String refundId) throws RefundCreationException, BitPayException {
        final Map<String, String> params = new HashMap<>();
        params.put("token", this.accessTokens.getAccessToken(Facade.MERCHANT));

        Refund refund;
        JsonMapper mapper = JsonMapperFactory.create();

        Boolean result;
        String json;

        try {
            json = mapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            throw new RefundCreationException(null, "failed to serialize Refund object : " + e.getMessage());
        }

        try {
            HttpResponse response = this.bitPayClient.post("refunds/" + refundId + "/notifications", json, true);
            String jsonString = this.bitPayClient.responseToJsonString(response);
            JsonNode rootNode = mapper.readTree(jsonString);
            JsonNode node = rootNode.get("status");
            result = node.toString().replace("\"", "").toLowerCase(Locale.ROOT).equals("success");
        } catch (BitPayException ex) {
            throw new RefundCreationException(ex.getStatusCode(), ex.getReasonPhrase());
        } catch (Exception e) {
            throw new RefundCreationException(null,
                "failed to deserialize BitPay server response (Refund) : " + e.getMessage());
        }

        return result;
    }

    /**
     * Cancel a previously submitted refund request on a BitPay invoice.
     *
     * @param refundId The refund Id for the refund to be canceled.
     * @return An updated Refund Object.
     * @throws RefundCancellationException RefundCancellationException class
     * @throws BitPayException             BitPayException class
     */
    public Refund cancelRefund(String refundId) throws RefundCancellationException, BitPayException {
        Refund refund;

        final List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("token", this.accessTokens.getAccessToken(Facade.MERCHANT)));

        try {
            HttpResponse response = this.bitPayClient.delete("refunds/" + refundId, params);
            refund = new ObjectMapper().readValue(this.bitPayClient.responseToJsonString(response), Refund.class);
        } catch (BitPayException ex) {
            throw new RefundCancellationException(ex.getStatusCode(), ex.getReasonPhrase());
        } catch (Exception e) {
            throw new RefundCancellationException(null,
                "failed to deserialize BitPay server response (Refund) : " + e.getMessage());
        }

        return refund;
    }
}