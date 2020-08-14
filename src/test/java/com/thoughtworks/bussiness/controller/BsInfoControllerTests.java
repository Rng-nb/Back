package com.thoughtworks.bussiness.controller;

import com.thoughtworks.bussiness.domain.BsInfo;
import com.thoughtworks.bussiness.dto.BsInfoDto;
import com.thoughtworks.bussiness.repository.BsInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BsInfoControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    BsInfoRepository bsInfoRepository;


    @BeforeEach
    void setUp() {
        bsInfoRepository.deleteAll();
        BsInfoDto bsInfoDto = bsInfoRepository.save(BsInfoDto.builder().productName("可乐").productPrice("3.5").productUnit("瓶")
                .productUrl("E:\\TW培训\\Font\\src\\images\\kele.JPG").build());
        bsInfoDto = bsInfoRepository.save(BsInfoDto.builder().productName("雪碧").productPrice("2").productUnit("瓶")
                .productUrl("E:\\TW培训\\Font\\src\\images\\kele2.JPG").build());
        bsInfoDto = bsInfoRepository.save(BsInfoDto.builder().productName("方便面").productPrice("5").productUnit("盒")
                .productUrl("E:\\TW培训\\Font\\src\\images\\kele6.JPG").build());
    }
    @Test
    public void should_return_bussiness_info_when_get_give_request() throws Exception {
        mockMvc.perform(get("/bsInfo"))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].productName", is("可乐")))
                .andExpect(jsonPath("$[0].productPrice", is("3.5")))
                .andExpect(jsonPath("$[0].productUnit", is("瓶")))
                .andExpect(jsonPath("$[0].productUrl", is("E:\\TW培训\\Font\\src\\images\\kele.JPG")))
                .andExpect(jsonPath("$[1].productName", is("雪碧")))
                .andExpect(jsonPath("$[1].productPrice", is("2")))
                .andExpect(jsonPath("$[1].productUnit", is("瓶")))
                .andExpect(jsonPath("$[1].productUrl", is("E:\\TW培训\\Font\\src\\images\\kele2.JPG")))
                .andExpect(jsonPath("$[2].productName", is("方便面")))
                .andExpect(jsonPath("$[2].productPrice", is("5")))
                .andExpect(jsonPath("$[2].productUnit", is("盒")))
                .andExpect(jsonPath("$[2].productUrl", is("E:\\TW培训\\Font\\src\\images\\kele6.JPG")))
                .andExpect(status().isOk());

    }
}