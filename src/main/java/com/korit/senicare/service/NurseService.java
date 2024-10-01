package com.korit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.korit.senicare.dto.request.nurse.PatchNurseRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.nurse.GetChargedCustomerResponseDto;
import com.korit.senicare.dto.response.nurse.GetNurseListResponseDto;
import com.korit.senicare.dto.response.nurse.GetNurseResponseDto;
import com.korit.senicare.dto.response.nurse.GetSignInResponseDto;

public interface NurseService { // getNurse와 getSignIn 메서드는 내용은 똑같지만 의미가 다르기 때문에 구분해서 작성함
    
    ResponseEntity<? super GetNurseListResponseDto> getNurseList();
    ResponseEntity<? super GetNurseResponseDto> getNurse(String userId); 
    ResponseEntity<? super GetSignInResponseDto> getSignIn(String userId);
    ResponseEntity<ResponseDto> patchNurse(PatchNurseRequestDto dto, String userId);
    ResponseEntity<? super GetChargedCustomerResponseDto> getChargedCustomer(String nurseId);

}
