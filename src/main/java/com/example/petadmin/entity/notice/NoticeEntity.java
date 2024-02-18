package com.example.petadmin.entity.notice;

import jakarta.persistence.*;
import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "notice_board")
public class NoticeEntity {

    private Long noticeIdx;         // 공지사항 고유번호
    private String title;           // 제목
    private String contents;        // 내용
    private int displayYn;          // 게시여부
    private String createdBy;       // 생성자
    private String updatedBy;       // 수정자

    public NoticeEditor.NoticeEditorBuilder toEditor(){
        return NoticeEditor.builder()
                .title(title)
                .contents(contents)
                .displayYn(displayYn)
                .updatedBy(updatedBy);
    }

    public void edit(NoticeEditor noticeEditor) {
        title = noticeEditor.getTitle();
        contents = noticeEditor.getContents();
        displayYn = noticeEditor.getDisplayYn();
        updatedBy = noticeEditor.getUpdatedBy();
    }
}
