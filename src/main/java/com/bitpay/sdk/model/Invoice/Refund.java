/*
 * Copyright (c) 2019 BitPay
 */

package com.bitpay.sdk.model.Invoice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Fully paid invoices can be refunded via the merchant's authorization to issue a refund,
 * while underpaid and overpaid invoices are automatically executed by BitPay to issue the underpayment
 * or overpayment amount to the customer.
 *
 * @see <a href="https://bitpay.com/api/#rest-api-resources-refunds">REST API Refunds</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Refund {

    private String _guid;
    private Double _amount;
    private String _currency;
    private String _invoice;
    private Boolean _preview;
    private Boolean _immediate;
    private Boolean _buyerPaysRefundFee;
    private String _reference;
    private Double _refundFee;
    private Date _lastRefundNotification;

    /**
     * Amount to be refunded in terms of the transaction currency.
     */
    private BigDecimal _transactionAmount;

    /**
     * The refund fee expressed in terms of transaction currency.
     */
    private BigDecimal _transactionRefundFee;

    /**
     * The currency used for the invoice transaction.
     */
    private String _transactionCurrency;


    private String _id;
    private Date _requestDate;
    private String _status;

    /**
     * Instantiates a new Refund.
     */
    public Refund() {
    }

    // Request fields
    //

    /**
     * Gets a variable provided by the merchant and designed to be used by the merchant to correlate the refund with a refund ID in their system.
     *
     * @return the guid
     */
    @JsonProperty("guid")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getGuid() {
        return _guid;
    }

    /**
     * Sets a variable provided by the merchant and designed to be used by the merchant to correlate the refund with a refund ID in their system.
     *
     * @param guid the guid
     */
    @JsonProperty("guid")
    public void setGuid(String guid) { this._guid = guid; }

    /**
     * Gets the amount to be refunded, denominated in the invoice original currency - partial refunds are supported.
     *
     * @return the amount
     */
    @JsonProperty("amount")
    public Double getAmount() {
        return _amount;
    }

    /**
     * Sets the amount to be refunded, denominated in the invoice original currency - partial refunds are supported.
     *
     * @param amount the amount
     */
    @JsonProperty("amount")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setAmount(Double amount) {
        this._amount = amount;
    }

    /**
     * Gets used for the refund, the same as the currency used to create the invoice..
     *
     * @return the currency
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return _currency;
    }

    /**
     * Sets used for the refund, the same as the currency used to create the invoice..
     *
     * @param currency the currency
     */
    @JsonProperty("currency")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setCurrency(String currency) {
        this._currency = currency;
    }

    /**
     * Gets the ID of the invoice being refunded..
     *
     * @return the invoice
     */
    @JsonProperty("invoice")
    public String getInvoice() {
        return _invoice;
    }

    /**
     * Sets the ID of the invoice being refunded..
     *
     * @param invoice the invoice
     */
    @JsonProperty("invoice")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setInvoice(String invoice) {
        this._invoice = invoice;
    }

    /**
     * Gets preview. Whether to create the refund request as a preview
     * (which will not be acted on until status is updated) - parameter defaults to false if not passed.
     *
     * @return the preview
     */
    @JsonProperty("preview")
    public Boolean getPreview() {
        return _preview;
    }

    /**
     * Sets preview.
     *
     * @param preview the preview
     */
    @JsonProperty("preview")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setPreview(Boolean preview) {
        this._preview = preview;
    }

    /**
     * Gets immediate. Whether funds should be removed from merchant ledger immediately on submission or at
     * time of processing - parameter defaults to false if not passed.
     *
     * @return the immediate
     */
    @JsonProperty("immediate")
    public Boolean getImmediate() {
        return _immediate;
    }

    /**
     * Sets immediate.
     *
     * @param immediate the immediate
     */
    @JsonProperty("immediate")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setImmediate(Boolean immediate) {
        this._immediate = immediate;
    }

    /**
     * Gets buyer pays refund fee. Whether the buyer should pay the refund fee rather than the merchant -
     * parameter defaults to false if not passed.
     *
     * @return the buyer pays refund fee
     */
    @JsonProperty("buyerPaysRefundFee")
    public Boolean getBuyerPaysRefundFee() {
        return _buyerPaysRefundFee;
    }

    /**
     * Sets buyer pays refund fee.
     *
     * @param buyerPaysRefundFee the buyer pays refund fee
     */
    @JsonProperty("buyerPaysRefundFee")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setBuyerPaysRefundFee(Boolean buyerPaysRefundFee) {
        this._buyerPaysRefundFee = buyerPaysRefundFee;
    }

    /**
     * Gets reference. Present only if specified in the request to create the refund.
     * This is your reference label for this refund.
     * It will be passed-through on each response for you to identify the refund in your system.
     * Maximum string length is 100 characters.
     *
     * @return the reference
     */
    @JsonProperty("reference")
    public String getReference() {
        return _reference;
    }

    /**
     * Sets reference. This is your reference label for this refund.
     * It will be passed-through on each response for you to identify the refund in your system.
     * Maximum string length is 100 characters.
     *
     * @param reference the reference
     */
    @JsonProperty("reference")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setReference(String reference) {
        this._reference = reference;
    }

    // Response fields
    //

    /**
     * Gets the ID of the refund.
     *
     * @return the id
     */
    @JsonIgnore
    public String getId() {
        return _id;
    }

    /**
     * Sets the ID of the refund.
     *
     * @param id the id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this._id = id;
    }

    /**
     * Gets the date the refund was requested.
     *
     * @return the request date
     */
    @JsonIgnore
    public Date getRequestDate() {
        return _requestDate;
    }

    /**
     * Sets the date the refund was requested.
     *
     * @param requestDate the request date
     */
    @JsonProperty("requestDate")
    public void setRequestDate(Date requestDate) {
        this._requestDate = requestDate;
    }

    /**
     * Gets the refund lifecycle status of the request.
     * {@link com.bitpay.sdk.model.Invoice.InvoiceStatus}
     *
     * @return the status
     */
    @JsonIgnore
    public String getStatus() {
        return _status;
    }

    /**
     * Sets the refund lifecycle status of the request.
     * {@link com.bitpay.sdk.model.Invoice.InvoiceStatus}
     *
     * @param status the status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this._status = status;
    }

    /**
     * Gets amount to be refunded in terms of the transaction currency.
     *
     * @return the transaction amount of the Refund
     * @see Refund
     */
    @JsonProperty("transactionAmount")
    public BigDecimal getTransactionAmount() {
        return _transactionAmount;
    }

    /**
     * Sets amount to be refunded in terms of the transaction currency.
     *
     * @param transactionAmount Amount to be refunded in terms of the transaction currency
     * @see Refund
     */
    @JsonProperty("transactionAmount")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this._transactionAmount = transactionAmount;
    }

    /**
     * Gets the refund fee expressed in terms of transaction currency.
     *
     * @return the transaction refund fee of the Refund
     * @see Refund
     */
    @JsonProperty("transactionRefundFee")
    public BigDecimal getTransactionRefundFee() {
        return _transactionRefundFee;
    }

    /**
     * Sets the refund fee expressed in terms of transaction currency.
     *
     * @param transactionRefundFee The refund fee expressed in terms of transaction currency
     * @see Refund
     */
    @JsonProperty("transactionRefundFee")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setTransactionRefundFee(BigDecimal transactionRefundFee) {
        this._transactionRefundFee = transactionRefundFee;
    }

    /**
     * Gets the currency used for the invoice transaction.
     *
     * @return the transaction currency of the Refund
     * @see Refund
     */
    @JsonProperty("transactionCurrency")
    public String getTransactionCurrency() {
        return _transactionCurrency;
    }

    /**
     * Sets the currency used for the invoice transaction.
     *
     * @param transactionCurrency The currency used for the invoice transaction
     * @see Refund
     */
    @JsonProperty("transactionCurrency")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setTransactionCurrency(String transactionCurrency) {
        this._transactionCurrency = transactionCurrency;
    }

    /**
     * Gets the last time notification of buyer was attempted.
     *
     * @return the last refund notification
     */
    @JsonIgnore
    public Date getLastRefundNotification() {
        return _lastRefundNotification;
    }

    /**
     * Sets the last time notification of buyer was attempted.
     *
     * @param lastRefundNotification the last refund notification
     */
    @JsonProperty("lastRefundNotification")
    public void setLastRefundNotification(Date lastRefundNotification) {
        this._lastRefundNotification = lastRefundNotification;
    }

    /**
     * Gets the amount of refund fee expressed in terms of pricing currency.
     *
     * @return the refund fee
     */
    @JsonIgnore
    public Double getRefundFee() {
        return _refundFee;
    }

    /**
     * Sets the amount of refund fee expressed in terms of pricing currency.
     *
     * @param refundFee the refund fee
     */
    @JsonProperty("refundFee")
    public void setRefundFee(Double refundFee) {
        this._refundFee = refundFee;
    }
}
