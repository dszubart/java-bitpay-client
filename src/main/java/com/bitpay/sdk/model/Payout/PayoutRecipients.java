package com.bitpay.sdk.model.Payout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

/**
 * The type Payout recipients.
 */
public class PayoutRecipients {
    private String _guid;
    private List<PayoutRecipient> _recipients = Collections.emptyList();
    private String _token = "";

    /**
     * Constructor, create an recipient-full request PayoutBatch object.
     *
     * @param recipients array array of JSON objects, with containing the following parameters.
     */
    public PayoutRecipients(List<PayoutRecipient> recipients) {
        this._recipients = recipients;
    }

    // API fields
    //

    /**
     * Gets guid.
     *
     * @return the guid
     */
    @JsonProperty("guid")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getGuid() {
        return _guid;
    }

    /**
     * Sets guid.
     *
     * @param guid the guid
     */
    @JsonProperty("guid")
    public void setGuid(String guid) {
        this._guid = guid;
    }

    /**
     * Gets Payout recipients token.
     *
     * @return the token
     */
    @JsonProperty("token")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getToken() {
        return _token;
    }

    /**
     * Sets Payout recipients token.
     *
     * @param token the token
     */
    @JsonProperty("token")
    public void setToken(String token) {
        this._token = token;
    }

    // Required fields
    //

    /**
     * Gets instructions.
     *
     * @return the instructions
     */
    @JsonProperty("recipients")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public List<PayoutRecipient> getInstructions() {
        return _recipients;
    }

    /**
     * Sets instructions.
     *
     * @param recipients the recipients
     */
    @JsonProperty("recipients")
    public void setInstructions(List<PayoutRecipient> recipients) {
        this._recipients = recipients;
    }
}
