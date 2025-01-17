/*
 * Copyright (c) 2019 BitPay
 */

package com.bitpay.sdk.model.Invoice;

import java.util.List;
import java.util.Objects;

/**
 * The type Invoice event token.
 *
 * @see <a href="https://bitpay.com/api/#rest-api-resources-invoices-resource">REST API Invoices</a>
 */
public class InvoiceEventToken {

    private String token;
    private List<String> events;
    private List<String> actions;

    /**
     * Instantiates a new Invoice event token.
     */
    protected InvoiceEventToken() {
    }

    /**
     * Instantiates a new Invoice event token.
     *
     * @param token   the token
     * @param events  the events
     * @param actions the actions
     */
    public InvoiceEventToken(
        String token,
        List<String> events,
        List<String> actions
    ) {
        Objects.requireNonNull(token, "missing token");
        this.token = token;
        this.events = events;
        this.actions = actions;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * The possible values are:
     * <ul>
     *     <li>payment - This allows you to be informed when the BitPay invoice reaches the status "paid",
     *     meaning the transaction has been applied to the invoice, but has not been confirmed yet.
     *     When listening to the websocket, this will be logged under the event: statechange.
     *     The invoice payload will contain the additional fields related to the merchant facade.
     *     </li>
     *     <li>confirmation - This allows you to track the number of block confirmations for the transaction made to an invoice.
     *     When listening to the websocket, this will be logged under the event: statechange.
     *     The invoice payload will contain the additional fields related to the merchant facade.
     *     </li>
     * </ul>
     *
     * @return the events
     */
    public List<String> getEvents() {
        return this.events;
    }

    /**
     * Gets actions. Can be subscribe, unsubscribe or both.
     *
     * @return the actions
     */
    public List<String> getActions() {
        return this.actions;
    }
}
