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

    @Builder
    public NoticeUpdateDto(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
