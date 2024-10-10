package com.example.petadmin.controller;

import com.example.petadmin.db.PetHospitalMapper;
import com.example.petadmin.model.dto.petHospital.PetHospitalSaveDto;
import com.example.petadmin.model.entity.petHospital.PetHospitalEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PetHospitalControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PetHospitalMapper petHospitalMapper;

    @BeforeEach
    void clean() {
        petHospitalMapper.deleteAllPetHos();
    }


    @Test
    @DisplayName("insert 시 DB에 저장")
    void test2() throws Exception {

        // given
        PetHospitalSaveDto request = PetHospitalSaveDto.builder()
                .hospitalAddr("부천")
                .hospitalName("동물병원")
                .hospitalNum("111")
                .operState("Y")
                .sigunName("부천")
                .build();

        String json = objectMapper.writeValueAsString(request);

        // expected
        mockMvc.perform(post("/pet/insert")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print());

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("page",0);
        paramMap.put("size",10);

        assertEquals(1L,petHospitalMapper.getPetHosListCount(paramMap));

        List<PetHospitalEntity> petHospitalEntities = petHospitalMapper.getPetHosList(paramMap);

        assertEquals("부천",petHospitalEntities.get(0).getHospitalAddr());
        assertEquals("동물병원",petHospitalEntities.get(0).getHospitalName());
    }

    @Test
    @DisplayName("병원 1개 조회")
    void test3() throws Exception{

        //given
        PetHospitalSaveDto petHospitalSaveDto = PetHospitalSaveDto.builder()
                .hospitalAddr("111")
                .hospitalName("222")
                .hospitalNum("333")
                .operState("333")
                .sigunName("555")
                .build();

        PetHospitalEntity petHospitalEntity = petHospitalSaveDto.toEntity();
        petHospitalMapper.insertPetHos(petHospitalEntity);

        //expected
        mockMvc.perform(get("/pet/{idx}",petHospitalEntity.getHospitalId())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.hospitalNum").value("333"))
                .andDo(print());
    }

    @Test
    @DisplayName("글 리스트 조회")
    void readNoticeTest() throws Exception{
        //given
        List<PetHospitalEntity> petHospitalEntities = IntStream.range(0,30)
                .mapToObj(i -> PetHospitalEntity.builder()
                        .hospitalAddr("addr" + i)
                        .hospitalName("name" + i)
                        .hospitalNum("num" + i)
                        .operState("oper" + i)
                        .sigunName("sigun" + i)
                        .build())
                .collect(Collectors.toList());

        //expected
        petHospitalMapper.insertPetHosList(petHospitalEntities);

        // expected
        mockMvc.perform(get("/pet/list?page=0&size=10")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].hospitalAddr").value("addr29"))
                .andDo(print());
    }
}