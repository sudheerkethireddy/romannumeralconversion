package org.adobe.aem.romannumeralconversion.controller;


import org.adobe.aem.romannumeralconversion.response.ErrorResponse;
import org.adobe.aem.romannumeralconversion.exception.RangeCheckException;
import org.adobe.aem.romannumeralconversion.response.SuccessResponse;
import org.adobe.aem.romannumeralconversion.service.IntegerToRomanConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path = "/romannumeral")
public class RomanNumericController {

    Logger logger = LoggerFactory.getLogger(RomanNumericController.class);

    @Autowired
    private IntegerToRomanConversionService integerToRomanConversionService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> convertIntToRoman(@RequestParam(value = "query", defaultValue = "1") String input)  {

        Integer inputInteger ;


        long startTime = System.currentTimeMillis();
        try {
            inputInteger = Integer.valueOf(input);
            SuccessResponse output = integerToRomanConversionService.convertIntegerToRoman(inputInteger);
            logger.info("convertIntegerToRoman_Total_TimeTaken_ms={}",System.currentTimeMillis() - startTime);
            return ResponseEntity.ok().body(output);
        }
        catch(NumberFormatException numberFormatException) {

            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setStatus(HttpStatus.BAD_REQUEST);
            errorResponse.setMessage("input to the service should be of type Integer");
            logger.info("convertIntegerToRoman_Total_TimeTaken_ms={}",System.currentTimeMillis() - startTime);
            return ResponseEntity.badRequest().body(errorResponse);

        }
        catch(RangeCheckException rangeCheckException) {

            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setStatus(HttpStatus.BAD_REQUEST);
            errorResponse.setMessage("Invalid input integer, input value should be in the range 1 to 3999");
            logger.info("convertIntegerToRoman_Total_TimeTaken_ms={}",System.currentTimeMillis() - startTime);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
        }
    }


    /**
     * This OPTIONS method call will give you the list of methods that are supported by the API
     * and sample request
     * @return - Response entity that renders list of allowed methods and sample request body
     */
    @RequestMapping(method = RequestMethod.OPTIONS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity optionsRequest() {

        ErrorResponse response = new ErrorResponse();
        response.setMessage("{\"sample request end point\": {{endpoint}/romannumeral?query={integer}}"+
                "make sure integer is in the range 1-3999");
        response.setStatus(HttpStatus.OK);
        response.setMessage("endpoint={endpoint}/romannumeral?query={integer}"+" .Currently supported method is GET");
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET)
                .body(response);
    }

    /**
     * This POST method call is not supported
     * @param input
     * @return - Response entity that renders that this method is not supported
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postRequest(@RequestParam(value = "query") String input) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("POST is not supported currently for this end point");
        errorResponse.setStatus(HttpStatus.NOT_IMPLEMENTED);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(errorResponse);
    }

    /**
     * This DELETE method call is not supported
     * @param input
     * @return - Response entity that renders that this method is not supported
     */
    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteRequest(@RequestParam(value = "query") String input) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("DELETE is not supported currently for this end point");
        errorResponse.setStatus(HttpStatus.NOT_IMPLEMENTED);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(errorResponse);
    }

    /**
     * This PUT method call is not supported
     * @param input
     * @return - Response entity that renders that this method is not supported
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity putRequest(@RequestParam(value = "query") String input) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("PUT is not supported currently for this end point");
        errorResponse.setStatus(HttpStatus.NOT_IMPLEMENTED);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(errorResponse);
    }
}
