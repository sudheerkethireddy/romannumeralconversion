package org.adobe.aem.romannumeralconversion.service;

import org.adobe.aem.romannumeralconversion.response.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component

/**
 * This service class holds the logic to convert input of integer to string
 */
public interface IntegerToRomanConversionService {


    /**
     * This method converts the given input integer to roman and returns the output as a POJO of
     * @param input  - input integer that needs to be converted to roman
     * @return       - converted roman string response{@link SuccessResponse}
     *               - if input is valid and if input is not valid then
     *               {@link org.adobe.aem.romannumeralconversion.response.ErrorResponse} representing error code and
     *               error message
     */
     SuccessResponse convertIntegerToRoman(int input);
}
