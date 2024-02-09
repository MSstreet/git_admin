package com.example.petadmin.entity;

import jakarta.persistence.Table;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "review_entity")
public class UserEntity {

    private Long userIdx;
    private String userId;
    private String userPw;
    private String userName;
    private String userNum;
    private String email;
    private String addr;
    private String detailAddr;
    private String zipCode;
    private String createAt;
    private String updatedAt;
    private int deleteYn;

}