package com.korit.senicare.dto.response.nurse;

import com.korit.senicare.common.object.Nurse;
import com.korit.senicare.dto.response.ResponseCode;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.ResponseMessage;
import com.korit.senicare.entity.NurseEntity;

import lombok.Getter;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetNurseListResponseDto extends ResponseDto {
    List<Nurse> nurses;

    private GetNurseListResponseDto(List<NurseEntity> nurseEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.nurses = Nurse.getList(nurseEntities);
    }

    public static ResponseEntity<GetNurseListResponseDto> success(List<NurseEntity> nurseEntities) {
        GetNurseListResponseDto responseBody = new GetNurseListResponseDto(nurseEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
