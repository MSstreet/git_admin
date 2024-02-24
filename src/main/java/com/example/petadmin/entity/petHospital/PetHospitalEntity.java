package com.example.petadmin.entity.petHospital;

import lombok.*;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetHospitalEntity {

    private Long hospitalId;
    private BigDecimal hosLatitude;
    private BigDecimal hosLongitude;
    private String hospitalAddr;
    private String hospitalName;
    private String hospitalNum;
    private String operState;
    private String sigunName;

    public PetHosEditor.PetHosEditorBuilder toEditor(){
        return PetHosEditor.builder()
                .hosLatitude(hosLatitude)
                .hosLongitude(hosLongitude)
                .hospitalAddr(hospitalAddr)
                .hospitalName(hospitalName)
                .hospitalNum(hospitalNum)
                .operState(operState)
                .sigunName(sigunName);
    }

    public void edit(PetHosEditor petHosEditor){
        hosLatitude = petHosEditor.getHosLatitude();
        hosLongitude = petHosEditor.getHosLongitude();
        hospitalAddr = petHosEditor.getHospitalAddr();
        hospitalName = petHosEditor.getHospitalName();
        hospitalNum = petHosEditor.getHospitalNum();
        operState = petHosEditor.getOperState();
        sigunName = petHosEditor.getSigunName();
    }
}