package com.memory.date.web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

public class HelloControllerTest extends AbstractControllerTest {

    @Test
    public void goodDate() throws Exception {
        String date = "Good Date";

        mvc.perform(get("/date"))
            .andExpect(status().isOk())
            .andExpect(content().string(date))
            .andDo(print());
    }

    @Test
    public void junit5Test() throws Exception {
        assertEquals(2, calculator(1,1), "Yes");
        assertAll("Heading", 
                    () -> assertEquals("John", "John"),
                    () -> {
                        assertAll("Heading",
                            () -> assertEquals("Test", "Test"));
                    });
    }

    public int calculator(int a, int b) {
        return a+b;
    }
}
    