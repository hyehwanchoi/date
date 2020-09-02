package com.java.date.service;

import javax.transaction.Transactional;

import com.java.date.domain.memory.MemoriesRepository;
import com.java.date.web.dto.MemoriesSaveRequestDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemoriesService {
    
    private final MemoriesRepository memoriesRepository;

    @Transactional
    public Long save(MemoriesSaveRequestDto requestDto) {
        return memoriesRepository.save(requestDto.toEntity()).getId();
    }
}
