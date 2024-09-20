package com.korit.senicare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.senicare.dto.request.tool.PatchToolRequestDto;
import com.korit.senicare.dto.request.tool.PostToolRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.tool.GetToolListResponseDto;
import com.korit.senicare.dto.response.tool.GetToolResponseDto;
import com.korit.senicare.service.ToolService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tool")
@RequiredArgsConstructor
public class ToolController {
    
    private final ToolService toolService;

    @PostMapping(value = {"", "/"}) // 기본값도 받을 수 있고 /로도 url을 받을 수 있음
    public ResponseEntity<ResponseDto> postTool(@RequestBody @Valid PostToolRequestDto requestBody) {
        ResponseEntity<ResponseDto> response = toolService.postTool(requestBody);
        return response;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<? super GetToolListResponseDto> getToolList() {
        ResponseEntity<? super GetToolListResponseDto> response = toolService.getToolList();
        return response;
    }

    @GetMapping("/{toolNumber}")
    public ResponseEntity<? super GetToolResponseDto> getTool(@PathVariable Integer toolNumber) {
        ResponseEntity<? super GetToolResponseDto> response = toolService.getTool(toolNumber);
        return response;
    }

    @PatchMapping("/{toolNumber}")
    public ResponseEntity<ResponseDto> patchTool(@PathVariable Integer toolNumber, @RequestBody @Valid PatchToolRequestDto requestBody) {
        ResponseEntity<ResponseDto> response = toolService.patchTool(toolNumber, requestBody);
        return response;
    }

    @DeleteMapping("/{toolNumber}")
    public ResponseEntity<ResponseDto> deleteTool(@PathVariable Integer toolNumber) {
        ResponseEntity<ResponseDto> response = toolService.deleteTool(toolNumber);
        return response;
    }

}
