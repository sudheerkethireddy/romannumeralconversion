package org.adobe.aem.romannumeralconversion;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumericControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testController_getCall_Happypath() throws Exception {

        mvc.perform(get("/romannumeral?query=398"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json("{\"integerInput\":\"398\",\"romanOutput\":\"CCCXCVIII\"}"));
    }

    @Test
    public void testController_postcall_notsupported() throws Exception {

        mvc.perform(post("/romannumeral?query=398"))
                .andExpect(status().is(501));
    }

    @Test
    public void testController_putcall_notsupported() throws Exception {

        mvc.perform(put("/romannumeral?query=398"))
                .andExpect(status().is(501));
    }

    @Test
    public void testController_deletecall_notsupported() throws Exception {

        mvc.perform(delete("/romannumeral?query=398"))
                .andExpect(status().is(501));
    }

    @Test
    public void testController_optionscall_notsupported() throws Exception {

        mvc.perform(options("/romannumeral?query=398"))
                .andExpect(status().is(200));
    }

    @Test
    public void testController_getcall_notsupported() throws Exception {

        mvc.perform(get("/romannumeral?query=sdfg"))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json("{\"status\":\"BAD_REQUEST\",\"message\":\"input to the service should be of type Integer\"}"));
    }

    @Test
    public void testController_getcall_outOfRangeInput() throws Exception {

        mvc.perform(get("/romannumeral?query=4000"))
                .andDo(print())
                .andExpect(status().is(403))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json("{\"status\":\"BAD_REQUEST\",\"message\":\"Invalid input integer, input value should be in the range 1 to 3999\"}"));
    }
}
