package com.example.petadmin.dto.notice;

import com.example.petadmin.entity.notice.NoticeEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeSaveDto {

    @NotBlank(message = "타이틀을 입력하세요.")
    private String title;     // 제목
    @NotBlank(message = "콘텐츠를 입력하세요.")
    private String contents;  // 내용
    private int displayYn;    // 게시여부

    public NoticeEntity toEntity(){
        return NoticeEntity.builder()
                .title(title)
                .contents(contents)
                .displayYn(displayYn)
                .build();
    }
}
