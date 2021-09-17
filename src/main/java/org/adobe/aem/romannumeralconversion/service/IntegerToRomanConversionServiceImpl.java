package org.adobe.aem.romannumeralconversion.service;

import org.adobe.aem.romannumeralconversion.controller.RomanNumericController;
import org.adobe.aem.romannumeralconversion.exception.RangeCheckException;
import org.adobe.aem.romannumeralconversion.response.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

/**
 * {@inheritDoc}
 */
@Component
public class IntegerToRomanConversionServiceImpl implements  IntegerToRomanConversionService {

    Logger logger = LoggerFactory.getLogger(IntegerToRomanConversionServiceImpl.class);

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    public SuccessResponse convertIntegerToRoman(int input) {

        long startTime = System.currentTimeMillis();
        SuccessResponse response = new SuccessResponse();
        response.setIntegerInput(String.valueOf(input));
        response.setRomanOutput(integerToRoman(input));
        logger.info("convertIntegerToRoman_TimeTaken_servicelayer_ms={}",System.currentTimeMillis() - startTime);
        return response;
    }


    /**
     * method that converts integer to roman
     * @param input  - the input integer that needs to be converted to roman
     * @return       - roman representation of the input
     */
    private String integerToRoman(int input) throws RangeCheckException {

        // check if the input is within the valid range
        if (input < 1 || input > 3999) {
           throw new RangeCheckException( "Invalid input integer, input value should be in the range 1 to 3999");
        }
        else {

            // recursively construct the roman taking the max number from the current input that is in map
            int l =  map.floorKey(input);
            if ( input == l ) {
                return map.get(l);
            }
            return map.get(l) + integerToRoman(input-l);
        }
    }
}
