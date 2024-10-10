package com.example.petadmin.model.entity.notice;

import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeEntity {

    private Long noticeIdx;         // 공지사항 고유번호
    private String title;           // 제목
    private String contents;        // 내용
    private int displayYn;          // 게시여부
    private String createdBy;       // 생성자
    private String updatedBy;       // 수정자
    private String createdAt;
    private String updatedAt;
    private int deleteYn;

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
