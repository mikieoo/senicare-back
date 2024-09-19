package com.korit.senicare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.senicare.service.ToolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tool")
@RequiredArgsConstructor
public class ToolController {
    
    private final ToolService ToolService;
}
