package com.example.petadmin.entity.notice;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NoticeEditor {

    private String title;           // 제목
    private String contents;        // 내용
    private int displayYn;          // 게시여부
    private String updatedBy;       // 수정자

    @Builder
    public NoticeEditor(String title, String contents, int displayYn, String updatedBy){
        this.title = title;
        this.contents = contents;
        this.displayYn = displayYn;
        this.updatedBy = updatedBy;
    }

    public static class NoticeEditorBuilder {
        private String title;
        private String contents;
        private int displayYn;
        private String updatedBy;

        NoticeEditorBuilder() {
        }

        public NoticeEditorBuilder title(final String title) {
            if(title != null) {
                this.title = title;
            }
            return this;
        }

        public NoticeEditorBuilder contents(final String contents) {
            if(contents != null) {
                this.contents = contents;
            }
            return this;
        }

        public NoticeEditorBuilder displayYn(final int displayYn) {
            this.displayYn = displayYn;
            return this;
        }

        public NoticeEditorBuilder updatedBy(final String updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public NoticeEditor build() {
            return new NoticeEditor(this.title, this.contents, this.displayYn, this.updatedBy);
        }

        public String toString() {
            return "NoticeEditor.NoticeEditorBuilder(title=" + this.title + ", contents=" + this.contents + ", displayYn=" + this.displayYn + ", updatedBy=" + this.updatedBy + ")";
        }
    }
}
