package com.example.petadmin.db;

import com.example.petadmin.dto.petHospital.PetHospitalSaveDto;
import com.example.petadmin.entity.PetHospitalEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PetHospitalMapper {
    List<PetHospitalEntity> getPetHosList(HashMap<String, Object> paramMap);

    int getPetHosListCount(HashMap<String, Object> paramMap);

    PetHospitalEntity getPetHos(Long idx);

    int insertPetHos(PetHospitalEntity petHospitalEntity);

    int updatePetHos(PetHospitalEntity petHospitalEntity);

    int deletePetHos(Long idx);
}
