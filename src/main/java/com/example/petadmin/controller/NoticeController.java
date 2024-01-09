package com.example.petadmin.controller;

import com.example.petadmin.db.NoticeBoardMapper;
import com.example.petadmin.dto.NoticeSaveDto;
import com.example.petadmin.entity.NoticeEntity;
import com.example.petadmin.service.NoticeService;
import com.example.petadmin.util.Header;
import com.example.petadmin.util.Search;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notice")
@RestController
public class NoticeController {

    private final NoticeService noticeService;


    @GetMapping("/noticeList")
    Header<List<NoticeEntity>> getNoticeList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Search search) {
        return noticeService.getNoticeList(page, size, search);
    }


    @GetMapping("/notice/{idx}")
    Header<NoticeEntity> getNoticeDetail(@PathVariable Long idx) {
        return noticeService.getNoticeDetail(idx);
    }

    @PostMapping("/insert")
    Header<NoticeEntity> insertNotice(@RequestBody NoticeSaveDto noticeSaveDto) {
        return noticeService.insertNotice(noticeSaveDto);
    }

    @PatchMapping("/update")
    Header<NoticeEntity> updateNotice(@RequestBody NoticeSaveDto noticeSaveDto) {
        return noticeService.updateNotice(noticeSaveDto);
    }

    @DeleteMapping("/notice/{idx}")
    Header<String> deleteBoard(@PathVariable Long idx) {
        return noticeService.deleteNotice(idx);
    }
}
