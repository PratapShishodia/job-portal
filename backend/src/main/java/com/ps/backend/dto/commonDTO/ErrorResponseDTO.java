package com.ps.backend.dto.commonDTO;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDTO(String apiPath, HttpStatus status,String message , LocalDateTime errorId,String traceId) {
}
