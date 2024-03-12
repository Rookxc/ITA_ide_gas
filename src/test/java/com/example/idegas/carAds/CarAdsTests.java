package com.example.idegas.carAds;

import com.example.idegas.dto.CarAd;
import com.example.idegas.rest.CarAdController;
import com.example.idegas.service.CarAdService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarAdController.class)
class CarAdsTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarAdService carAdService;

    @Test
    void testGetCarAdById() throws Exception {
        CarAd carAd = new CarAd("1", "Volvo", "V50", 2008);
        when(carAdService.getCarAdById("1")).thenReturn(Optional.of(carAd));

        mvc.perform(get("/car-ads/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("Volvo"))
                .andExpect(jsonPath("$.model").value("V50"))
                .andExpect(jsonPath("$.year").value(2008));
    }

}
