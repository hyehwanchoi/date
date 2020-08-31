package com.java.date.domain.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemoriesRepositoryTest {
    
    @Autowired
    MemoriesRepository memoriesRepository;

    @AfterEach
    public void clean() {
        memoriesRepository.deleteAll();
    }

    @Test
    public void memoryList() {
        String place = "문화식당";
        String address = "성수동";

        memoriesRepository.save(Memories.builder()
                                .place(place)
                                .address(address)
                                .build());

        List<Memories> memoryList = memoriesRepository.findAll();

        Memories memory = memoryList.get(0);
        assertEquals(memory.getPlace(), place);
        assertEquals(memory.getAddress(), address);
    }
}
    