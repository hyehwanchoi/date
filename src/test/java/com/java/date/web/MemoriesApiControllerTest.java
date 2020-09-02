package com.java.date.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.java.date.domain.memory.Memories;
import com.java.date.domain.memory.MemoriesRepository;
import com.java.date.web.dto.MemoriesSaveRequestDto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemoriesApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemoriesRepository memoriesRepository;

    @AfterEach
    public void tearDown() throws Exception {
        memoriesRepository.deleteAll();
    }

    @Test
    public void Memories_save() throws Exception {
        String place = "콩지Pot지";
        String address = "서울시 종로구";

        MemoriesSaveRequestDto requestDto = MemoriesSaveRequestDto.builder()
                                                .kinds("맛집")
                                                .place(place)
                                                .address(address)
                                                .explanation("레스토랑")
                                                .build();

        String url = "http://localhost:"+ port + "/api/v1/memories";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

        List<Memories> all = memoriesRepository.findAll();
        assertEquals(all.get(0).getPlace(), "콩지Pot지");
        assertEquals(all.get(0).getAddress(), "서울시 종로구");
    }
}
    