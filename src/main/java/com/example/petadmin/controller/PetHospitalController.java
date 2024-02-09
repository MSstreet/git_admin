package com.example.petadmin.controller;

import com.example.petadmin.dto.petHospital.PetHospitalSaveDto;
import com.example.petadmin.entity.PetHospitalEntity;
import com.example.petadmin.service.PetHospitalService;
import com.example.petadmin.util.Header;
import com.example.petadmin.util.Search;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/pet")
@RestController
public class PetHospitalController {


    private final PetHospitalService petHospitalService;

    @GetMapping("/list")
    public Header<List<PetHospitalEntity>> getPetHosList(@RequestParam(name ="page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size, Search search){
        return petHospitalService.getPetHosList(page,size,search);
    }

    @GetMapping("/{idx}")
    public Header<PetHospitalEntity> getPetHos(@PathVariable Long idx){
        return petHospitalService.getPetHos(idx);
    }

    @PostMapping("/insert")
    public Header<PetHospitalEntity> insertPetHos(@RequestBody @Valid PetHospitalSaveDto petHospitalSaveDto){
        return petHospitalService.insertPetHos(petHospitalSaveDto);
    }

    @PatchMapping("/update")
    public Header<PetHospitalEntity> updatePetHos(@RequestBody PetHospitalSaveDto petHospitalSaveDto){
        return petHospitalService.updatePetHos(petHospitalSaveDto);
    }

    @DeleteMapping("/{idx}")
    public Header<String> deletePetHos(@PathVariable Long idx){
        return petHospitalService.deletePetHos(idx);
    }
}



