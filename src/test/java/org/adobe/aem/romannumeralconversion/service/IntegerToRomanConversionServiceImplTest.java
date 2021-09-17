package org.adobe.aem.romannumeralconversion.service;

import org.adobe.aem.romannumeralconversion.exception.RangeCheckException;
import org.adobe.aem.romannumeralconversion.response.SuccessResponse;
import org.junit.Assert;
import org.junit.Test;

public class IntegerToRomanConversionServiceImplTest {

    private IntegerToRomanConversionService service = new IntegerToRomanConversionServiceImpl();

    /* this unit test tests that we get range check exception if input is greater by 1 than range 1-3999*/
    @Test(expected = RangeCheckException.class)
    public void inputInteger_greaterThan3999_Invalid_test() {
        service.convertIntegerToRoman(4000);
    }

    /* this unit test tests that we get range check exception if input is less by 1 than range 1-3999*/
    @Test(expected = RangeCheckException.class)
    public void inputInteger_lessThan1_Invalid_test() {
        service.convertIntegerToRoman(0);
    }


    /* this unit test tests for valid input*/
    @Test
    public void inputInteger_Valid_test() {

        SuccessResponse expectedResponse = new SuccessResponse("100","C");
        SuccessResponse actualResponse = service.convertIntegerToRoman(100);
        Assert.assertEquals(expectedResponse.getIntegerInput(), actualResponse.getIntegerInput());
        Assert.assertEquals(expectedResponse.getRomanOutput(), actualResponse.getRomanOutput());
    }

    /* this unit test tests for valid input*/
    @Test
    public void inputInteger_Valid_test_two() {

        SuccessResponse expectedResponse = new SuccessResponse("3981","MMMCMLXXXI");
        SuccessResponse actualResponse = service.convertIntegerToRoman(3981);
        Assert.assertEquals(expectedResponse.getIntegerInput(), actualResponse.getIntegerInput());
        Assert.assertEquals(expectedResponse.getRomanOutput(), actualResponse.getRomanOutput());
    }
}
