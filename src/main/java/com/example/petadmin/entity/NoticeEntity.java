package com.example.petadmin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "notice_board")
@DynamicInsert
@DynamicUpdate
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeIdx;         // 공지사항 고유번호
    private String title;            // 제목
    private String contents;         // 내용
    private int displayYn;          // 게시여부
    private int deleteYn;           // 삭제여부
    private String createdAt;       // 작성일
    private String updatedAt;       // 수정일

}
