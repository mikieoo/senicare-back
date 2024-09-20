package com.korit.senicare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.senicare.dto.request.tool.PostToolRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.service.ToolService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tool")
@RequiredArgsConstructor
public class ToolController {
    
    private final ToolService ToolService;

    @PostMapping(value = {"", "/"}) // 기본값도 받을 수 있고 /로도 url을 받을 수 있음
    public ResponseEntity<ResponseDto> postTool(@RequestBody @Valid PostToolRequestDto RequestBody) {
        ResponseEntity<ResponseDto> response = ToolService.postTool(RequestBody);
        return response;
    }
}
