package com.example.petadmin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "notice_board")
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeIdx;         // 공지사항 고유번호
    private String title;           // 제목
    private String contents;        // 내용
    private int displayYn;          // 게시여부
    private int deleteYn;           // 삭제여부
    private String createdBy;       // 생성자
    private String updatedBy;       // 수정자
    private String createdAt;       // 작성일
    private String updatedAt;        // 수정일

}
