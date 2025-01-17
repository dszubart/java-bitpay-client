/*
 * Copyright (c) 2019 BitPay
 */
package com.bitpay.sdk.model.Settlement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Hashtable;

/**
 * The type Refund info.
 * @see <a href="https://bitpay.com/api/#rest-api-resources-refunds-resource">Refunds</a>
 * @see <a href="https://bitpay.com/api/#rest-api-resources-settlements">Settlements</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundInfo {
    private String _supportRequest;
    private String _currency;
    private Hashtable<String, Double> _amounts;
    private String _reference;
    private String refundRequestEid;

    /**
     * Instantiates a new Refund info.
     */
    public RefundInfo() {
    }

    /**
     * Gets the refund requestId.
     *
     * @return the support request
     */
    @JsonIgnore
    public String getSupportRequest() {
        return _supportRequest;
    }

    /**
     * Sets the refund requestId.
     *
     * @param supportRequest the support request
     */
    @JsonProperty("supportRequest")
    public void setSupportRequest(String supportRequest) {
        this._supportRequest = supportRequest;
    }

    /**
     * Gets reference currency used for the refund, usually the same as the currency used to create the invoice.
     *
     * @return the currency
     */
    @JsonIgnore
    public String getCurrency() {
        return _currency;
    }

    /**
     * Sets reference currency used for the refund, usually the same as the currency used to create the invoice.
     *
     * @param currency the currency
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this._currency = currency;
    }

    /**
     * Gets amount. For a refunded invoice, this object will contain the crypto currency amount refunded by BitPay
     * to the consumer (in the selected transactionCurrency) and the equivalent refunded amount from the invoice
     * in the given currency (thus linked to the amount debited from the merchant account to cover the refund).
     *
     * @return the amount
     */
    @JsonIgnore
    public Hashtable<String, Double> getAmount() {
        return _amounts;
    }

    /**
     * Sets amount. For a refunded invoice, this object will contain the crypto currency amount refunded by BitPay
     * to the consumer (in the selected transactionCurrency) and the equivalent refunded amount from the invoice
     * in the given currency (thus linked to the amount debited from the merchant account to cover the refund).
     *
     * @param amounts the amounts
     */
    @JsonProperty("amounts")
    public void setAmount(Hashtable<String, Double> amounts) {
        this._amounts = amounts;
    }

    /**
     * Gets reference. Present only if specified in the request to create the refund.
     * This is your reference label for this refund.
     * It will be passed-through on each response for you to identify the refund in your system.
     * Maximum string length is 100 characters.
     *
     * @return the reference
     */
    @JsonIgnore
    public String getReference() {
        return _reference;
    }

    /**
     * Sets reference. Present only if specified in the request to create the refund.
     * This is your reference label for this refund.
     * It will be passed-through on each response for you to identify the refund in your system.
     * Maximum string length is 100 characters.
     *
     * @param reference the reference
     */
    @JsonProperty("reference")
    public void setReference(String reference) {
        this._reference = reference;
    }

    /**
     * Gets Refund Request Eid.
     *
     * @return Refund Request Eid
     */
    public String getRefundRequestEid() {
        return this.refundRequestEid;
    }

    /**
     * Sets Refund Request Eid.
     *
     * @param refundRequestEid Refund Request Eid
     */
    public void setRefundRequestEid(String refundRequestEid) {
        this.refundRequestEid = refundRequestEid;
    }
}
