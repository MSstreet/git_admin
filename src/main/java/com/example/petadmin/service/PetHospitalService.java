package com.example.petadmin.service;

import com.example.petadmin.controller.exception.BaseException;
import com.example.petadmin.controller.exception.ErrorCode;
import com.example.petadmin.db.PetHospitalMapper;
import com.example.petadmin.model.dto.petHospital.PetHospitalSaveDto;
import com.example.petadmin.model.entity.petHospital.PetHosEditor;
import com.example.petadmin.model.entity.petHospital.PetHospitalEntity;
import com.example.petadmin.utils.Header;
import com.example.petadmin.utils.Pagination;
import com.example.petadmin.utils.Search;
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
        PetHospitalEntity petHospitalEntity = petHospitalMapper.getPetHos(idx);
        if(petHospitalEntity == null){
            throw new BaseException(ErrorCode.PET_HOSPITAL_NOT_FOUND, String.format("pet hospital id %s is not found", idx));
        }

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

    public Header<PetHospitalEntity> updatePetHos(Long idx,PetHospitalSaveDto petHospitalSaveDto){
        PetHospitalEntity petHospitalEntity = petHospitalMapper.getPetHos(idx);
        if(petHospitalEntity == null){
            throw new BaseException(ErrorCode.PET_HOSPITAL_NOT_FOUND, String.format("pet hospital id %s is not found", idx));
        }

        PetHosEditor.PetHosEditorBuilder editorBuilder = petHospitalEntity.toEditor();

        PetHosEditor petHosEditor = editorBuilder.hosLatitude(petHospitalSaveDto.getHosLatitude())
                .hosLongitude(petHospitalSaveDto.getHosLongitude())
                .sigunName(petHospitalSaveDto.getSigunName())
                .hospitalNum(petHospitalSaveDto.getHospitalNum())
                .hospitalName(petHospitalSaveDto.getHospitalName())
                .operState(petHospitalSaveDto.getOperState())
                .sigunName(petHospitalSaveDto.getSigunName())
                .build();

        petHospitalEntity.edit(petHosEditor);

        if(petHospitalMapper.updatePetHos(petHospitalEntity) > 0) {
            return Header.OK(petHospitalEntity);
        }else{
            return Header.ERROR("ERROR");
        }
    }

    public Header<String> deletePetHos(Long idx){
        PetHospitalEntity petHospitalEntity = petHospitalMapper.getPetHos(idx);
        if(petHospitalEntity == null){
            throw new BaseException(ErrorCode.PET_HOSPITAL_NOT_FOUND, String.format("pet hospital id %s is not found", idx));
        }

        if (petHospitalMapper.deletePetHos(idx) > 0){
            return Header.OK();
        }else{
            return Header.ERROR("ERROR");
        }
    }
}



