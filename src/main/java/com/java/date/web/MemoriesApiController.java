package com.java.date.web;

import com.java.date.service.MemoriesService;
import com.java.date.web.dto.MemoriesSaveRequestDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemoriesApiController {
    
    private final MemoriesService memoriesService;

    @PostMapping("/api/v1/memories")
    public Long save(@RequestBody MemoriesSaveRequestDto requestDto) {
        return memoriesService.save(requestDto);
    }
}
