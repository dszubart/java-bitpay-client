/*
 * Copyright (c) 2019 BitPay
 */

package com.bitpay.sdk.model.Invoice;

import static com.bitpay.sdk.model.ModelConfiguration.DEFAULT_NON_SENT_VALUE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Shopper.
 *
 * @see <a href="https://bitpay.readme.io/reference/invoices">REST API Invoices</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shopper {

    private String user = DEFAULT_NON_SENT_VALUE;

    /**
     * Instantiates a new Shopper.
     */
    public Shopper() {
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    @JsonIgnore
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getName() {
        return this.user;
    }

    /**
     * Sets name.
     *
     * @param user the user
     */
    @JsonProperty("user")
    public void setName(String user) {
        this.user = user;
    }
}
