/*
 * Copyright (c) 2019 BitPay
 */
package com.bitpay.sdk.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FacadeTest {

    @Test
    public void it_should_returns_merchant_string() {
        Assertions.assertEquals("merchant", Facade.Merchant);
    }

    @Test
    public void it_should_returns_payout_string() {
        Assertions.assertEquals("payout", Facade.Payout);
    }
}