package com.example.petadmin.db;

import com.example.petadmin.entity.notice.NoticeEntity;
import com.example.petadmin.entity.petHospital.PetHospitalEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PetHospitalMapper {
    List<PetHospitalEntity> getPetHosList(HashMap<String, Object> paramMap);

    int getPetHosListCount(HashMap<String, Object> paramMap);

    int insertPetHosList(List<PetHospitalEntity> petHospitalEntities);

    PetHospitalEntity getPetHos(Long idx);

    int insertPetHos(PetHospitalEntity petHospitalEntity);

    int updatePetHos(PetHospitalEntity petHospitalEntity);

    int deletePetHos(Long idx);

    void deleteAllPetHos();
}
