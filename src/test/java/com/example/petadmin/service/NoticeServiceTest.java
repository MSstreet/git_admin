package com.example.petadmin.service;

import com.example.petadmin.db.NoticeBoardMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


//    @Test
//    @DisplayName("글 내용 수정")
//    void test() {
//        // given
//        NoticeEntity noticeEntity = NoticeEntity.builder()
//                .title("명수")
//                .contents("부천")
//                .build();
//        noticeBoardMapper.insertNotice(noticeEntity);
//
//        NoticeUpdateDto noticeUpdateDto = NoticeUpdateDto.builder()
//                .title(null)
//                .contents("bucheon111")
//                .build();
//
//        // when
//        noticeService.updateNotice(noticeEntity.getNoticeIdx(), noticeUpdateDto);
//
//        // then
//        NoticeEntity changedNotice = noticeBoardMapper.getNoticeDetail(noticeEntity.getNoticeIdx());
//        assertEquals("bucheon111", changedNotice.getContents());
//    }
}