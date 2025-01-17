package com.bitpay.sdk.model.Settlement;

import com.bitpay.sdk.util.DateDeserializer;
import com.bitpay.sdk.util.DateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * The type Settlement.
 * @see <a href="https://bitpay.com/api/#rest-api-resources-settlements">Settlements</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Settlement {

    private String _id;
    private String _accountId;
    private String _currency;
    private PayoutInfo _payoutInfo;
    private String _status;
    private Long _dateCreated;
    private Long _dateExecuted;
    private Long _dateCompleted;
    private Long _openingDate;
    private Long _closingDate;
    private Float _openingBalance;
    private Float _ledgerEntriesSum;
    private List<WithHoldings> _withHoldings;
    private Float _withHoldingsSum;
    private Float _totalAmount;
    private List<SettlementLedgerEntry> _ledgerEntries;
    private String _token;

    /**
     * Instantiates a new Settlement.
     */
    public Settlement() {
    }

    /**
     * Gets id.
     * String identifying the settlement; this id will also be in the description of the corresponding bank settlement.
     *
     * @return the id
     */
    @JsonIgnore
    public String getId() {
        return _id;
    }

    /**
     * Sets id.
     * String identifying the settlement; this id will also be in the description of the corresponding bank settlement.
     *
     * @param id the id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this._id = id;
    }

    /**
     * Gets account id.
     * String identifying the BitPay merchant. For internal use, this field can be ignored in merchant implementations.
     *
     * @return the account id
     */
    @JsonIgnore
    public String getAccountId() {
        return _accountId;
    }

    /**
     * Sets account id.
     * String identifying the BitPay merchant. For internal use, this field can be ignored in merchant implementations.
     *
     * @param accountId the account id
     */
    @JsonProperty("accountId")
    public void setAccountId(String accountId) {
        this._accountId = accountId;
    }

    /**
     * Gets currency. ISO 4217 3-character currency code. This is the currency associated with the settlement.
     * @see <a href="https://bitpay.com/docs/settlement">Supported settlement currencies are listed</a>
     *
     * @return the currency
     */
    @JsonIgnore
    public String getCurrency() {
        return _currency;
    }

    /**
     * Sets currency. ISO 4217 3-character currency code. This is the currency associated with the settlement.
     * @see <a href="https://bitpay.com/docs/settlement">Supported settlement currencies are listed</a>
     *
     * @param currency the currency
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this._currency = currency;
    }

    /**
     * Gets payout info. Object containing the settlement info provided by the Merchant in his BitPay account settings.
     *
     * @return the payout info
     */
    @JsonIgnore
    public PayoutInfo getPayoutInfo() {
        return _payoutInfo;
    }

    /**
     * Sets payout info. Object containing the settlement info provided by the Merchant in his BitPay account settings.
     *
     * @param payoutInfo the payout info
     */
    @JsonProperty("payoutInfo")
    public void setPayoutInfo(PayoutInfo payoutInfo) {
        this._payoutInfo = payoutInfo;
    }

    /**
     * Gets status of the settlement. Possible statuses are "new", "processing", "rejected" and "completed".
     *
     * @return the status
     */
    @JsonIgnore
    public String getStatus() {
        return _status;
    }

    /**
     * Sets status of the settlement. Possible statuses are "new", "processing", "rejected" and "completed".
     *
     * @param status the status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this._status = status;
    }

    /**
     * Gets date created.
     *
     * @return the date created
     */
    @JsonIgnore
    @JsonSerialize(using = DateSerializer.class)
    public Long getDateCreated() {
        return _dateCreated;
    }

    /**
     * Sets date created.
     *
     * @param dateCreated the date created
     */
    @JsonProperty("dateCreated")
    @JsonDeserialize(using = DateDeserializer.class)
    public void setDateCreated(Long dateCreated) {
        this._dateCreated = dateCreated;
    }

    /**
     * Gets timestamp when the settlement was executed. UTC date, ISO-8601 format yyyy-mm-ddThh:mm:ssZ
     *
     * @return the date executed
     */
    @JsonIgnore
    @JsonSerialize(using = DateSerializer.class)
    public Long getDateExecuted() {
        return _dateExecuted;
    }

    /**
     * Sets timestamp when the settlement was executed. UTC date, ISO-8601 format yyyy-mm-ddThh:mm:ssZ
     *
     * @param dateExecuted the date executed
     */
    @JsonProperty("dateExecuted")
    @JsonDeserialize(using = DateDeserializer.class)
    public void setDateExecuted(Long dateExecuted) {
        this._dateExecuted = dateExecuted;
    }

    /**
     * Gets date completed.
     *
     * @return the date completed
     */
    @JsonIgnore
    @JsonSerialize(using = DateSerializer.class)
    public Long getDateCompleted() {
        return _dateCompleted;
    }

    /**
     * Sets date completed.
     *
     * @param dateCompleted the date completed
     */
    @JsonProperty("dateCompleted")
    @JsonDeserialize(using = DateDeserializer.class)
    public void setDateCompleted(Long dateCompleted) {
        this._dateCompleted = dateCompleted;
    }

    /**
     * Gets opening date. Corresponds to the closingDate of the previous settlement executed.
     * For the first settlement of an account the value will be the BitPay merchant account creation date.
     * UTC date, ISO-8601 format yyyy-mm-ddThh:mm:ssZ
     *
     * @return the opening date
     */
    @JsonIgnore
    @JsonSerialize(using = DateSerializer.class)
    public Long getOpeningDate() {
        return _openingDate;
    }

    /**
     * Sets opening date. Corresponds to the closingDate of the previous settlement executed.
     * For the first settlement of an account the value will be the BitPay merchant account creation date.
     * UTC date, ISO-8601 format yyyy-mm-ddThh:mm:ssZ
     *
     * @param openingDate the opening date
     */
    @JsonProperty("openingDate")
    @JsonDeserialize(using = DateDeserializer.class)
    public void setOpeningDate(Long openingDate) {
        this._openingDate = openingDate;
    }

    /**
     * Gets date and time for last ledger entry used for the settlement. UTC date, ISO-8601 format yyyy-mm-ddThh:mm:ssZ.
     *
     * @return the closing date
     */
    @JsonIgnore
    @JsonSerialize(using = DateSerializer.class)
    public Long getClosingDate() {
        return _closingDate;
    }

    /**
     * Sets date and time for last ledger entry used for the settlement. UTC date, ISO-8601 format yyyy-mm-ddThh:mm:ssZ.
     *
     * @param closingDate the closing date
     */
    @JsonProperty("closingDate")
    @JsonDeserialize(using = DateDeserializer.class)
    public void setClosingDate(Long closingDate) {
        this._closingDate = closingDate;
    }

    /**
     * Gets balance of the ledger at the openingDate.
     *
     * @return the opening balance
     */
    @JsonIgnore
    public Float getOpeningBalance() {
        return _openingBalance;
    }

    /**
     * Sets balance of the ledger at the openingDate.
     *
     * @param openingBalance the opening balance
     */
    @JsonProperty("openingBalance")
    public void setOpeningBalance(Float openingBalance) {
        this._openingBalance = openingBalance;
    }

    /**
     * Gets sum of all ledger entries in the settlement,
     * this means all the debits and credits which happened between openingDate and closingDate.
     *
     * @return the ledger entries sum
     */
    @JsonIgnore
    public Float getLedgerEntriesSum() {
        return _ledgerEntriesSum;
    }

    /**
     * Sets sum of all ledger entries in the settlement,
     * this means all the debits and credits which happened between openingDate and closingDate.
     *
     * @param ledgerEntriesSum the ledger entries sum
     */
    @JsonProperty("ledgerEntriesSum")
    public void setLedgerEntriesSum(Float ledgerEntriesSum) {
        this._ledgerEntriesSum = ledgerEntriesSum;
    }

    /**
     * Gets array of With Holdings.
     * With Holdings are kept on the ledger to be used later and thus withheld from this settlement.
     * Each withholding is a JSON object containing a code, amount and description field.
     * The possible withholding codes are:
     * <ul>
     *     <li>W001 - Refund Reserve: a merchant can set a refund reserve for his account. This code indicate the current amount in the reserve at the moment the settlement is generated.</li>
     *     <li>W002 - Settlement Fee: in case BitPay is charging the bank fees to the merchant, via a SWIFT wire for instance, will be posted to the ledger when the settlementReport goes into status ‘processing’. This code is not used for SEPA or ACH transfers</li>
     *     <li>W003 - Liquidity Withholding : Used when BitPay's balance at the specific settlement bank is insufficient to payout the full amount today</li>
     *     <li>W004 - Insufficient Balance : in the event a case the ledger balance of the merchant drops after the settlement cut-off, the settlement amount will be adjusted.</li>
     *     <li>W005 - Pending Refunds : in order to make sure enough funds are left on the account to execute pending refund requests.</li>
     * </ul>
     *
     * @return the with holdings
     */
    @JsonIgnore
    public List<WithHoldings> getWithHoldings() {
        return _withHoldings;
    }

    /**
     * Sets array of With Holdings.
     * With Holdings are kept on the ledger to be used later and thus withheld from this settlement.
     * Each withholding is a JSON object containing a code, amount and description field.
     * The possible withholding codes are:
     * <ul>
     *     <li>W001 - Refund Reserve: a merchant can set a refund reserve for his account. This code indicate the current amount in the reserve at the moment the settlement is generated.</li>
     *     <li>W002 - Settlement Fee: in case BitPay is charging the bank fees to the merchant, via a SWIFT wire for instance, will be posted to the ledger when the settlementReport goes into status ‘processing’. This code is not used for SEPA or ACH transfers</li>
     *     <li>W003 - Liquidity Withholding : Used when BitPay's balance at the specific settlement bank is insufficient to payout the full amount today</li>
     *     <li>W004 - Insufficient Balance : in the event a case the ledger balance of the merchant drops after the settlement cut-off, the settlement amount will be adjusted.</li>
     *     <li>W005 - Pending Refunds : in order to make sure enough funds are left on the account to execute pending refund requests.</li>
     * </ul>
     *
     * @param withHoldings the with holdings
     */
    @JsonProperty("withHoldings")
    public void setWithHoldings(List<WithHoldings> withHoldings) {
        this._withHoldings = withHoldings;
    }

    /**
     * Gets sum of all amounts that are withheld from settlement.
     *
     * @return the with holdings sum
     */
    @JsonIgnore
    public Float getWithHoldingsSum() {
        return _withHoldingsSum;
    }

    /**
     * Sets sum of all amounts that are withheld from settlement.
     *
     * @param withHoldingsSum the with holdings sum
     */
    @JsonProperty("withHoldingsSum")
    public void setWithHoldingsSum(Float withHoldingsSum) {
        this._withHoldingsSum = withHoldingsSum;
    }

    /**
     * Gets total amount.
     * Total amount sent to the merchant; 2 decimals.
     * TotalAmount = openingBalance + ledgerEntriesSum - withholdingsSum
     *
     * @return the total amount
     */
    @JsonIgnore
    public Float getTotalAmount() {
        return _totalAmount;
    }

    /**
     * Sets total amount.
     * Total amount sent to the merchant; 2 decimals.
     * TotalAmount = openingBalance + ledgerEntriesSum - withholdingsSum
     *
     * @param totalAmount the total amount
     */
    @JsonProperty("totalAmount")
    public void setTotalAmount(Float totalAmount) {
        this._totalAmount = totalAmount;
    }

    /**
     * Gets Ledger Entries.
     *
     * @return the ledger entries
     */
    @JsonIgnore
    public List<SettlementLedgerEntry> getLedgerEntries() {
        return _ledgerEntries;
    }

    /**
     * Sets Ledger Entries.
     *
     * @param ledgerEntries the ledger entries
     */
    @JsonProperty("ledgerEntries")
    public void setLedgerEntries(List<SettlementLedgerEntry> ledgerEntries) {
        this._ledgerEntries = ledgerEntries;
    }

    /**
     * Gets API token for the corresponding settlement resource.
     * This token is actually derived from the merchant facade token used during the query.
     * This token is required to fetch the reconciliation report.
     *
     * @return the token
     */
    @JsonIgnore
    public String getToken() {
        return _token;
    }

    /**
     * Sets API token for the corresponding settlement resource.
     * This token is actually derived from the merchant facade token used during the query.
     * This token is required to fetch the reconciliation report.
     *
     * @param token the token
     */
    @JsonProperty("token")
    public void setToken(String token) {
        this._token = token;
    }
}
