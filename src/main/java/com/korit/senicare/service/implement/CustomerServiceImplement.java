package com.korit.senicare.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.senicare.dto.request.customer.PostCustomerRequestDto;
import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.customer.GetCustomerListResponseDto;
import com.korit.senicare.entity.CustomerEntity;
import com.korit.senicare.repository.CustomerRepository;
import com.korit.senicare.repository.NurseRepository;
import com.korit.senicare.repository.resultset.GetCustomerResultSet;
import com.korit.senicare.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplement implements CustomerService {

    private final NurseRepository  nurseRepository;
    private final CustomerRepository customerRepository;

    @Override
    public ResponseEntity<ResponseDto> postCustomer(PostCustomerRequestDto dto) {

        try {

            String charger = dto.getCharger();
            boolean isExistedNurse = nurseRepository.existsByUserId(charger);
            if (!isExistedNurse) return ResponseDto.noExistUserId();

            CustomerEntity customerEntity = new CustomerEntity(dto);
            customerRepository.save(customerEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetCustomerListResponseDto> getCustomreList() {
        
        List<GetCustomerResultSet> resultSets = new ArrayList<>();

        try {

            resultSets = customerRepository.getCustomers();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return GetCustomerListResponseDto.success(resultSets);
    }

}
