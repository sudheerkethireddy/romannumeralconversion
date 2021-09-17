package org.adobe.aem.romannumeralconversion.controller;

import org.adobe.aem.romannumeralconversion.RomanNumericServiceApplicationTest;
import org.adobe.aem.romannumeralconversion.response.SuccessResponse;
import org.adobe.aem.romannumeralconversion.service.IntegerToRomanConversionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(RomanNumericController.class)
public class RomanNumericControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IntegerToRomanConversionService integerToRomanConversionService;

    @Test
    public void asdf() throws Exception {


        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setRomanOutput("C");
        successResponse.setIntegerInput("100");
        ResponseEntity response = ResponseEntity.ok(successResponse);

        mvc.perform(MockMvcRequestBuilders.get("/romannumeral?query=398").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("XI")));
    }

}
