package com.example.petadmin.controller;

import com.example.petadmin.model.dto.notice.NoticeSaveDto;
import com.example.petadmin.model.dto.notice.NoticeUpdateDto;
import com.example.petadmin.model.entity.notice.NoticeEntity;
import com.example.petadmin.service.NoticeService;
import com.example.petadmin.utils.Header;
import com.example.petadmin.utils.Search;
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

    @GetMapping("/{noticeIdx}")
    public Header<NoticeEntity> getNoticeDetail(@PathVariable("noticeIdx") Long noticeIdx) {
        return noticeService.getNoticeDetail(noticeIdx);
    }

    @PostMapping("/insert")
    public Header<NoticeEntity> insertNotice(@RequestBody @Valid NoticeSaveDto noticeSaveDto) {
        return noticeService.insertNotice(noticeSaveDto);
    }

    @PatchMapping("/update")
    public Header<NoticeEntity> updateNotice(@RequestBody @Valid NoticeUpdateDto noticeUpdateDto){
        return noticeService.updateNotice(noticeUpdateDto);
    }

    @DeleteMapping("/{idx}")
    public Header<String> deleteNotice(@PathVariable("idx") Long idx) {
        return noticeService.deleteNotice(idx);
    }
}
