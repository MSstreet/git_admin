package com.example.petadmin.entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pet_hospital_entity")
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