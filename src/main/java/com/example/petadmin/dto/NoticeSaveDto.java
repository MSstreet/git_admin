package com.example.petadmin.dto;

import com.example.petadmin.entity.NoticeEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeSaveDto {

    private Long noticeIdx;   // 공지사항 고유번호
    @NotBlank(message = "타이틀을 입력하세요")
    private String title;     // 제목
    @NotBlank(message = "콘텐츠를 입력하세요")
    private String contents;  // 내용
    private int displayYn;    // 게시여부

    public NoticeEntity toEntity(){
        return NoticeEntity.builder()
                .noticeIdx(noticeIdx)
                .title(title)
                .contents(contents)
                .displayYn(displayYn)
                .build();
    }
}
