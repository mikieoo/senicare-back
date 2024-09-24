package com.korit.senicare.service;

import org.springframework.core.io.Resource; // 파일을 반환할때 사용하는 타입
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    
    String upload(MultipartFile file);

    Resource getFile(String fileName);

}
