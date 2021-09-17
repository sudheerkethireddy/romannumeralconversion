package org.adobe.aem.romannumeralconversion.response;

/**
 * This POJO class represents the happy path response that will be rendered by the REST Service
 */
public class SuccessResponse {

    private String integerInput; // given input integer
    private String romanOutput; // roman representation of the input integer

    public SuccessResponse(String integerInput, String romanOutput) {
        this.integerInput = integerInput;
        this.romanOutput = romanOutput;
    }

    public SuccessResponse() {
        this.integerInput = integerInput;
        this.romanOutput = romanOutput;
    }

    public String getIntegerInput() {
        return integerInput;
    }

    public String getRomanOutput() {
        return romanOutput;
    }

    public void setIntegerInput(String integerInput) {
        this.integerInput = integerInput;
    }

    public void setRomanOutput(String romanOutput) {
        this.romanOutput = romanOutput;
    }
}
