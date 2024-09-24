package com.korit.senicare.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.senicare.dto.request.tool.PatchToolRequestDto;
import com.korit.senicare.dto.request.tool.PostToolRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.tool.GetToolListResponseDto;
import com.korit.senicare.dto.response.tool.GetToolResponseDto;
import com.korit.senicare.entity.ToolEntity;
import com.korit.senicare.repository.ToolRepository;
import com.korit.senicare.service.ToolService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToolServiceImplement implements ToolService {

    private final ToolRepository toolRepository;

    @Override
    public ResponseEntity<ResponseDto> postTool(PostToolRequestDto dto) {
        
        try {

            ToolEntity toolEntity = new ToolEntity(dto);
            toolRepository.save(toolEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetToolListResponseDto> getToolList() {

        List<ToolEntity> toolEntities = new ArrayList<>(); // 단일 값이 아닌 리스트라면 null이 아닌 빈 컬렉션으로 초기화해줌

        try {

            toolEntities = toolRepository.findByOrderByToolNumberDesc();

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetToolListResponseDto.success(toolEntities);
    }

    @Override
    public ResponseEntity<? super GetToolResponseDto> getTool(Integer toolNumber) {
        
        ToolEntity toolEntity = null;

        try {

            toolEntity = toolRepository.findByToolNumber(toolNumber);
            if (toolEntity == null) return ResponseDto.noExistTool();


        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetToolResponseDto.success(toolEntity);
    }

    @Override
    public ResponseEntity<ResponseDto> patchTool(Integer toolNumber, PatchToolRequestDto dto) {

        try {

            ToolEntity toolEntity = toolRepository.findByToolNumber(toolNumber);
            if (toolEntity == null) return ResponseDto.noExistTool();

            toolEntity.patch(dto);
            toolRepository.save(toolEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
        
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTool(Integer toolNumber) {

        try {

            ToolEntity toolEntity = toolRepository.findByToolNumber(toolNumber);
            if (toolEntity == null) return ResponseDto.noExistTool();

            toolRepository.delete(toolEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }
    
}
