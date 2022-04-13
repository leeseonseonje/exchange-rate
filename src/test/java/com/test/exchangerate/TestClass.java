package com.test.exchangerate;

import com.test.exchangerate.domain.RecipientCountry;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TestClass {

    @Test
    void test() {
        RecipientCountry usdkrw = RecipientCountry.valueOf("krw");
        System.out.println(usdkrw);
    }

    @Test
    void btest() {
        BigDecimal n = BigDecimal.valueOf(1234);
        BigDecimal bigDecimal = n.setScale(2);
        System.out.println(bigDecimal);

        DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
        String format = decimalFormat.format(BigDecimal.valueOf(123456.42424));
        System.out.println(format);
    }


}
