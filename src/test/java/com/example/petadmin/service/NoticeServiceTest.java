package com.example.petadmin.service;

import com.example.petadmin.db.NoticeBoardMapper;
import com.example.petadmin.dto.notice.NoticeUpdateDto;
import com.example.petadmin.entity.notice.NoticeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeServiceTest {


    @Autowired
    private NoticeService noticeService;

    @Autowired
    private NoticeBoardMapper noticeBoardMapper;

    @BeforeEach
    void clean() {
        noticeBoardMapper.deleteAllNotice();
    }


    @Test
    @DisplayName("글 내용 수정")
    void test() {
        // given
        NoticeEntity noticeEntity = NoticeEntity.builder()
                .title("명수")
                .contents("부천")
                .build();
        noticeBoardMapper.insertNotice(noticeEntity);

        NoticeUpdateDto noticeUpdateDto = NoticeUpdateDto.builder()
                .title(null)
                .contents("bucheon111")
                .build();

        // when
        noticeService.updateNotice(noticeEntity.getNoticeIdx(), noticeUpdateDto);

        // then
        NoticeEntity changedNotice = noticeBoardMapper.getNoticeDetail(noticeEntity.getNoticeIdx());
        assertEquals("bucheon111", changedNotice.getContents());
    }
}