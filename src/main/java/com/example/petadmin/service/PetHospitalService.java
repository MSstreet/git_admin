package com.example.petadmin.service;

import com.example.petadmin.db.PetHospitalMapper;
import com.example.petadmin.dto.petHospital.PetHospitalSaveDto;
import com.example.petadmin.entity.petHospital.PetHospitalEntity;
import com.example.petadmin.util.Header;
import com.example.petadmin.util.Pagination;
import com.example.petadmin.util.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PetHospitalService {

    private final PetHospitalMapper petHospitalMapper;
    public Header<List<PetHospitalEntity>> getPetHosList(int page, int size, Search search) {
        HashMap<String, Object> paramMap = new HashMap<>();

        if(page <= 1) {
            paramMap.put("page", 0);
        }else{
            paramMap.put("page", (page - 1) * size);
        }

        paramMap.put("size", size);
        paramMap.put("sk", search.getSk());
        paramMap.put("sv", search.getSv());

        List<PetHospitalEntity> petHosList = petHospitalMapper.getPetHosList(paramMap);

        Pagination pagination = new Pagination(
                petHospitalMapper.getPetHosListCount(paramMap),
                page,
                size,
                10
        );
        return Header.OK(petHosList, pagination);
    }
    public Header<PetHospitalEntity> getPetHos(Long idx) {
        // To do : Null일 경우 예외처리
        return Header.OK(petHospitalMapper.getPetHos(idx));
    }

    public Header<PetHospitalEntity> insertPetHos(PetHospitalSaveDto petHospitalSaveDto) {
        PetHospitalEntity entity = petHospitalSaveDto.toEntity();
        if(petHospitalMapper.insertPetHos(entity)> 0){
            return Header.OK(entity);
        }else{
            return Header.ERROR("ERROR");
        }
    }

    public Header<PetHospitalEntity> updatePetHos(Long id,PetHospitalSaveDto petHospitalSaveDto){
        PetHospitalEntity petHospitalEntity = petHospitalMapper.getPetHos(id);



        PetHospitalEntity entity = petHospitalSaveDto.toEntity();
        if(petHospitalMapper.updatePetHos(entity) > 0) {
            return Header.OK(entity);
        }else{
            return Header.ERROR("ERROR");
        }
    }

    public Header<String> deletePetHos(Long idx){
        // To do : Null일 경우 예외처리
        if (petHospitalMapper.deletePetHos(idx) > 0){
            return Header.OK();
        }else{
            return Header.ERROR("ERROR");
        }
    }
}



