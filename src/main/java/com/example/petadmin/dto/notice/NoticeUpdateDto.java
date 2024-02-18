package com.example.petadmin.dto.notice;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class NoticeUpdateDto {

    @NotBlank(message = "타이틀을 입력하세요")
    private String title;     // 제목
    @NotBlank(message = "콘텐츠를 입력하세요")
    private String contents;  // 내용
    private int displayYn;          // 게시여부
    private String updatedBy;       // 수정자

    @Builder
    public NoticeUpdateDto(String title, String contents, int displayYn, String updatedBy){
        this.title = title;
        this.contents = contents;
        this.displayYn = displayYn;
        this.updatedBy = updatedBy;
    }
}
