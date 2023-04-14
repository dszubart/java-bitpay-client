/*
 * Copyright (c) 2019 BitPay
 */

package com.bitpay.sdk.model.Invoice;

import static com.bitpay.sdk.model.ModelConfiguration.DEFAULT_NON_SENT_VALUE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Invoice itemized details.
 *
 * @see <a href="https://bitpay.readme.io/reference/invoices">REST API Invoices</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceItemizedDetails {
    private double amount;
    private String description = DEFAULT_NON_SENT_VALUE;
    private Boolean isFee;

    /**
     * Instantiates a new Invoice itemized details.
     */
    public InvoiceItemizedDetails() {
    }

    /**
     * Gets the amount of currency.
     *
     * @return the amount
     */
    @JsonIgnore
    public double getAmount() {
        return this.amount;
    }

    /**
     * Sets the amount of currency.
     *
     * @param amount the amount
     */
    @JsonProperty("amount")
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets description. Display string for the item.
     *
     * @return the description
     */
    @JsonIgnore
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets description. Display string for the item.
     *
     * @param description the description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets is fee. Indicates whether or not the item is considered a fee/tax or part of the main purchase.
     *
     * @return the is fee
     */
    @JsonIgnore
    public Boolean getIsFee() { return this.isFee; }

    /**
     * Sets is fee. Indicates whether or not the item is considered a fee/tax or part of the main purchase.
     *
     * @param isFee the is fee
     */
    @JsonProperty("IsFee")
    public void setIsFee(Boolean isFee) {
        this.isFee = isFee;
    }
}
