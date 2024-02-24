package com.example.petadmin.controller;

import com.example.petadmin.dto.notice.NoticeSaveDto;
import com.example.petadmin.dto.notice.NoticeUpdateDto;
import com.example.petadmin.entity.notice.NoticeEntity;
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
    public Header<List<NoticeEntity>> getNoticeList(@RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "size", defaultValue = "10") int size, Search search) {
        return noticeService.getNoticeList(page, size, search);
    }

    @GetMapping("/{idx}")
    public Header<NoticeEntity> getNoticeDetail(@PathVariable Long idx) {
        return noticeService.getNoticeDetail(idx);
    }

    @PostMapping("/insert")
    public Header<NoticeEntity> insertNotice(@RequestBody @Valid NoticeSaveDto noticeSaveDto) {
        return noticeService.insertNotice(noticeSaveDto);
    }

    @PatchMapping("/update/{idx}")
    public Header<NoticeEntity> updateNotice(@PathVariable Long idx,@RequestBody @Valid NoticeUpdateDto noticeUpdateDto){
        return noticeService.updateNotice(idx,noticeUpdateDto);
    }

    @DeleteMapping("/{idx}")
    public Header<String> deleteNotice(@PathVariable Long idx) {
        return noticeService.deleteNotice(idx);
    }
}
