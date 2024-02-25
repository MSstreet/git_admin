package com.example.petadmin.dto.petHospital;

import com.example.petadmin.entity.petHospital.PetHospitalEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PetHospitalSaveDto {

    private BigDecimal hosLatitude;
    private BigDecimal hosLongitude;
    @NotBlank(message = "주소를 입력하세요")
    private String hospitalAddr;
    @NotBlank(message = "병원 이름을 입력하세요")
    private String hospitalName;
    @NotBlank(message = "전화번호를 입력하세요")
    private String hospitalNum;
    @NotBlank(message = "시군명을 입력하세요")
    private String sigunName;
    private String operState;


    public PetHospitalEntity toEntity(){
        return PetHospitalEntity.builder()
                .hosLatitude(hosLatitude)
                .hosLongitude(hosLongitude)
                .hospitalAddr(hospitalAddr)
                .hospitalName(hospitalName)
                .hospitalNum(hospitalNum)
                .operState(operState)
                .sigunName(sigunName)
                .build();
    }
}