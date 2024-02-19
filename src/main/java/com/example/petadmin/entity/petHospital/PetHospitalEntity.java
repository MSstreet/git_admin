package com.example.petadmin.entity.petHospital;

import jakarta.persistence.Table;
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

}