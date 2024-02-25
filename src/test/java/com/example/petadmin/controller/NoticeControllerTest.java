package com.example.petadmin.controller;

import com.example.petadmin.db.NoticeBoardMapper;
import com.example.petadmin.dto.notice.NoticeSaveDto;
import com.example.petadmin.entity.notice.NoticeEntity;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class NoticeControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NoticeBoardMapper noticeBoardMapper;

    @BeforeEach
    void clean() {noticeBoardMapper.deleteAllNotice();}


    // To Do : implement
//    @Test
//    @DisplayName("/posts 요청시 title값은 필수")
//    void test1() throws Exception {
//        // given
//        NoticeSaveDto request = NoticeSaveDto.builder()
//                .contents("내용입니다.")
//                .build();
//
//        String json = objectMapper.writeValueAsString(request);
//
//        // expected
//        mockMvc.perform(post("/notice/insert")
//                        .contentType(APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.description").value("타이틀을 입력하세요."))
//                .andDo(print());
//    }

    // To Do : implement
//    @Test
//    @DisplayName("수정_title값은필수")
//    void 수정_title값은필수() throws Exception {
//        // given
//        NoticeSaveDto request = NoticeSaveDto.builder()
//                .contents("내용입니다.")
//                .build();
//
//        String json = objectMapper.writeValueAsString(request);
//
//        // expected
//        mockMvc.perform(post("/notice/insert")
//                        .contentType(APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.description").value("타이틀을 입력하세요."))
//                .andDo(print());
//    }

    @Test
    @DisplayName("insert 시 DB에 저장")
    void test2() throws Exception {
        // given
        NoticeSaveDto request = NoticeSaveDto.builder()
                .title("제목입니다.")
                .contents("내용입니다.")
                .build();

        String json = objectMapper.writeValueAsString(request);

        // expected
        mockMvc.perform(post("/notice/insert")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print());

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("page",0);
        paramMap.put("size",10);

        assertEquals(1L,noticeBoardMapper.getNoticeListCount(paramMap));

        List<NoticeEntity> noticeEntity = noticeBoardMapper.getNoticeList(paramMap);

        assertEquals("제목입니다.",noticeEntity.get(0).getTitle());
        assertEquals("내용입니다.",noticeEntity.get(0).getContents());
    }

    @Test
    @DisplayName("글 1개 조회")
    void test3() throws Exception{

        //given
        NoticeSaveDto noticeSaveDto= NoticeSaveDto.builder()
                .title("111")
                .contents("222")
                .build();

        NoticeEntity noticeEntity = noticeSaveDto.toEntity();
        noticeBoardMapper.insertNotice(noticeEntity);

        //expected
        mockMvc.perform(get("/notice/{idx}",noticeEntity.getNoticeIdx())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.title").value("111"))
                .andDo(print());
    }

    @Test
    @DisplayName("글 리스트 조회")
    void readNoticeTest() throws Exception{
        //given
        List<NoticeEntity> noticeEntities = IntStream.range(0,30)
                .mapToObj(i -> NoticeEntity.builder()
                        .title("title" + i)
                        .contents("contents" + i)
                        .build())
                .collect(Collectors.toList());

        //expected
        noticeBoardMapper.insertNoticeList(noticeEntities);

        // expected
        mockMvc.perform(get("/notice/list?page=0&size=10")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].title").value("title29"))
                .andDo(print());
    }

    @Test
    @DisplayName("공지사항 수정")
    void test5() throws Exception{
        // given
        NoticeEntity noticeEntity = NoticeEntity.builder()
                .title("수정전공지")
                .contents("수정전")
                .build();

        noticeBoardMapper.insertNotice(noticeEntity);

        NoticeEntity noticeEntityEdit = NoticeEntity.builder()
                .title("수정후공지")
                .contents("수정후")
                .build();

        // expected
        mockMvc.perform(patch("/notice/update/{idx}", noticeEntity.getNoticeIdx())
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(noticeEntityEdit)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("공지사항 삭제")
    void 삭제테스트() throws Exception{
        // given
        NoticeEntity noticeEntity = NoticeEntity.builder()
                .title("수정전공지")
                .contents("수정전")
                .build();

        noticeBoardMapper.insertNotice(noticeEntity);

        // expected
        mockMvc.perform(delete("/notice/{idx}", noticeEntity.getNoticeIdx())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        NoticeEntity notice = noticeBoardMapper.getNoticeDetail(noticeEntity.getNoticeIdx());
        assertEquals(1,notice.getDeleteYn());

    }

    @Test
    @DisplayName("존재하지 않는 게시글 조회")
    void test9() throws Exception {
        // expected
        mockMvc.perform(delete("/notice/{idx}", 1000L)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

}


