package com.memory.date.domain.memory;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Memory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String kinds; //데이터 종류

    @Column(columnDefinition = "TEXT", nullable = false)
    private String place; //장소

    @Column(columnDefinition = "TEXT", nullable = false)
    private String address; //장소 주소

    @Column(columnDefinition = "TEXT", nullable = false)
    private String explanation; //설명
}