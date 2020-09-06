package com.java.date.web;

import com.java.date.service.MemoriesService;
import com.java.date.web.dto.MemoriesResponseDto;
import com.java.date.web.dto.MemoriesSaveRequestDto;
import com.java.date.web.dto.MemoriesUpdateRequestDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@RestController
public class MemoriesApiController {
    
    private final MemoriesService memoriesService;

    @PostMapping("/api/v1/memories")
    public Long save(@RequestBody MemoriesSaveRequestDto requestDto) {
        return memoriesService.save(requestDto);
    }

    @PutMapping(value="/api/v1/memories/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemoriesUpdateRequestDto requestDto) {
        return memoriesService.update(id, requestDto);
    }

    @GetMapping(value="/api/v1/memories/{id}")
    public MemoriesResponseDto findById(@PathVariable Long id) {
        return memoriesService.findById(id);
    }
    
}
