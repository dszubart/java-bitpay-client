/*
 * Copyright (c) 2019 BitPay
 */

package com.bitpay.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Token.
 *
 * @see <a href="https://bitpay.com/api/#rest-api-resources">Rest API Resources</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

    private String _guid;
    private String _id = "";
    private String _pairingCode = "";
    private long _pairingExpiration;
    private String _facade = "";
    private String _label = "";
    private int _count = 0;
    private List<Policy> _policies;
    private String _resource;
    private String _value;
    private long _dateCreated;

    /**
     * Instantiates a new Token.
     */
    public Token() {
    }

    // API fields
    //

    /**
     * Gets guid. A passthru variable provided by the merchant and designed to be used by the merchant to correlate
     * the invoice with an order ID in their system.
     *
     * @return the guid
     */
    @JsonProperty("guid")
    public String getGuid() {
        return _guid;
    }

    /**
     * Sets guid. A passthru variable provided by the merchant and designed to be used by the merchant to correlate
     * the invoice with an order ID in their system.
     *
     * @param guid the guid
     */
    @JsonProperty("guid")
    public void setGuid(String guid) {
        this._guid = guid;
    }

    // Required fields
    //

    /**
     * Gets id.
     *
     * @return the id
     */
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getId() {
        return _id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this._id = id;
    }

    // Optional fields
    //

    /**
     * Gets pairing code. Access approval code. To be validated via the BitPay dashboard in order to activate
     * the token returned in the same payload.
     *
     * @return the pairing code
     */
    @JsonProperty("pairingCode")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getPairingCode() {
        return _pairingCode;
    }

    /**
     * Sets pairing code. Access approval code. To be validated via the BitPay dashboard in order to activate
     * the token returned in the same payload.
     *
     * @param pairingCode the pairing code
     */
    @JsonProperty("pairingCode")
    public void setPairingCode(String pairingCode) {
        this._pairingCode = pairingCode;
    }

    /**
     * Gets facade. Can be "merchant", "pos" or "payout".
     *
     * @return the facade
     */
    @JsonProperty("facade")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getFacade() {
        return _facade;
    }

    /**
     * Sets facade. Can be "merchant", "pos" or "payout".
     *
     * @param facade the facade
     */
    @JsonProperty("facade")
    public void setFacade(String facade) {
        this._facade = facade;
    }

    /**
     * Gets token label, may include spaces, underscores, and dashes. BitPay invites the merchants to pass their
     * Business Name or website in this field.
     *
     * @return the label
     */
    @JsonProperty("label")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getLabel() {
        return _label;
    }

    /**
     * Sets token label, may include spaces, underscores, and dashes. BitPay invites the merchants to pass their
     * Business Name or website in this field.
     *
     * @param label the label
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this._label = label;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    @JsonProperty("count")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int getCount() {
        return _count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    @JsonProperty("count")
    public void setCount(int count) {
        this._count = count;
    }

    // Response fields
    //

    /**
     * Gets UNIX time of expiration, in milliseconds.
     *
     * @return the pairing expiration
     */
    @JsonIgnore
    public long getPairingExpiration() {
        return _pairingExpiration;
    }

    /**
     * Sets UNIX time of expiration, in milliseconds.
     *
     * @param pairingExpiration the pairing expiration
     */
    @JsonProperty("pairingExpiration")
    public void setPairingExpiration(long pairingExpiration) {
        this._pairingExpiration = pairingExpiration;
    }

    /**
     * Gets policies.
     *
     * @return the policies
     */
    @JsonIgnore
    public List<Policy> getPolicies() {
        return _policies;
    }

    /**
     * Sets policies.
     *
     * @param policies the policies
     */
    @JsonProperty("policies")
    public void setPolicies(List<Policy> policies) {
        this._policies = policies;
    }

    /**
     * Gets Token identifier. This field can be ignored in merchant implementations.
     *
     * @return the resource
     */
    @JsonIgnore
    public String getResource() {
        return _resource;
    }

    /**
     * Sets Token identifier. This field can be ignored in merchant implementations.
     *
     * @param resource the resource
     */
    @JsonProperty("resource")
    public void setResource(String resource) {
        this._resource = resource;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonIgnore
    public String getValue() {
        return _value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    @JsonProperty("token")
    public void setValue(String value) {
        this._value = value;
    }

    /**
     * Gets UNIX time of creation, in milliseconds.
     *
     * @return the date created
     */
    @JsonIgnore
    public long getDateCreated() {
        return _dateCreated;
    }

    /**
     * Sets UNIX time of creation, in milliseconds.
     *
     * @param dateCreated the date created
     */
    @JsonProperty("dateCreated")
    public void setDateCreated(long dateCreated) {
        this._dateCreated = dateCreated;
    }

}
