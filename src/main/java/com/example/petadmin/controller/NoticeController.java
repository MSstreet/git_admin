package com.example.petadmin.controller;

import com.example.petadmin.db.NoticeBoardMapper;
import com.example.petadmin.dto.NoticeSaveDto;
import com.example.petadmin.entity.NoticeEntity;
import com.example.petadmin.service.NoticeService;
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
@RequestMapping("/notice")
@RestController
public class NoticeController {

    private final NoticeService noticeService;


    @GetMapping("/list")
    Header<List<NoticeEntity>> getNoticeList(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size, Search search) {
        return noticeService.getNoticeList(page, size, search);
    }

    @GetMapping("/{idx}")
    Header<NoticeEntity> getNoticeDetail(@PathVariable Long idx) {
        return noticeService.getNoticeDetail(idx);
    }

    @PostMapping("/insert")
    Header<NoticeEntity> insertNotice(@RequestBody @Valid NoticeSaveDto noticeSaveDto) {
        return noticeService.insertNotice(noticeSaveDto);
    }

    @PatchMapping("/update")
    Header<NoticeEntity> updateNotice(@RequestBody NoticeSaveDto noticeSaveDto) {
        return noticeService.updateNotice(noticeSaveDto);
    }

    @DeleteMapping("/{idx}")
    Header<String> deleteBoard(@PathVariable Long idx) {
        return noticeService.deleteNotice(idx);
    }
}
