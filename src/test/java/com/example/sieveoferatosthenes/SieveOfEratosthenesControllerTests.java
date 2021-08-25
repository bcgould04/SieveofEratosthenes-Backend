package com.example.sieveoferatosthenes;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SieveOfEratosthenesController.class)
public class SieveOfEratosthenesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sieveOfEratosthenesControllerGetPrimesShouldReturnStringFromService() throws Exception {
        this.mockMvc.perform(post("/api/sieve/2")).andExpect(status().isOk())
                .andExpect(content().string(containsString("2")));
    }

    @Test
    public void givenStaticMethodWithArgsReturnsSuccessfully() {

        try (MockedStatic<SieveOfEratosthenesService> service = Mockito.mockStatic(SieveOfEratosthenesService.class)) {
            service.when(() -> SieveOfEratosthenesService.getAllPrimes(3)).thenReturn("2, 3");

            assertThat(SieveOfEratosthenesService.getAllPrimes(3).equals("2, 3"));

        }
    }
}
