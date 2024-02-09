package com.example.petadmin.dto.petHospital;

import com.example.petadmin.entity.NoticeEntity;
import com.example.petadmin.entity.PetHospitalEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetHospitalSaveDto {

    private BigDecimal hosLatitude;
    private BigDecimal hosLongitude;
    private String hospitalAddr;
    private String hospitalName;
    private String hospitalNum;
    private String operState;
    private String sigunName;

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