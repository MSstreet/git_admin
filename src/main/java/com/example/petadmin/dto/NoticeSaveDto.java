package com.example.petadmin.dto;

import com.example.petadmin.entity.NoticeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeSaveDto {

    private Long noticeIdx;         // 공지사항 고유번호
    private String title;            // 제목
    private String contents;         // 내용
    private int displayYn;          // 게시여부

    public NoticeEntity toEntity(){
        return NoticeEntity.builder()
                .noticeIdx(noticeIdx)
                .title(title)
                .contents(contents)
                .displayYn(displayYn)
                .build();
    }
}
