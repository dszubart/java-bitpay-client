/*
 * Copyright (c) 2019 BitPay
 */

package com.bitpay.sdk.model.Payout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PayoutRecipientTest {

    @Test
    public void it_should_change_email() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setEmail(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getEmail());
    }

    @Test
    public void it_should_change_guid() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setGuid(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getGuid());
    }

    @Test
    public void it_should_change_label() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setLabel(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getLabel());
    }

    @Test
    public void it_should_change_reference() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setReference(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getReference());
    }

    @Test
    public void it_should_change_notificationURL() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setNotificationURL(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getNotificationURL());
    }

    @Test
    public void it_should_change_account() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setAccount(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getAccount());
    }

    @Test
    public void it_should_change_status() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setStatus(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getStatus());
    }

    @Test
    public void it_should_change_id() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setId(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getId());
    }

    @Test
    public void it_should_change_shopperId() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setShopperId(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getShopperId());
    }

    @Test
    public void it_should_change_token() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setToken(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getToken());
    }

    @Test
    public void it_should_change_supportPhone() {
        // given
        String expected = "expectedString";
        PayoutRecipient testedClass = this.getTestedClass();

        // when
        testedClass.setSupportPhone(expected);

        // then
        Assertions.assertEquals(expected, testedClass.getSupportPhone());
    }

    private PayoutRecipient getTestedClass() {
        return new PayoutRecipient();
    }
}
