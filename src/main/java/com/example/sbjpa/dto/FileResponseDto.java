package com.example.sbjpa.dto;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileResponseDto {
    Resource resource;

    HttpHeaders headers;

    int status;
}
