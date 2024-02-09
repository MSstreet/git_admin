package com.example.petadmin.dto.user;

import com.example.petadmin.entity.NoticeEntity;
import com.example.petadmin.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSaveDto {

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


    public UserEntity toEntity(){
        return UserEntity.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userNum(userNum)
                .email(email)
                .addr(addr)
                .detailAddr(detailAddr)
                .zipCode(zipCode)
                .createAt(createAt)
                .updatedAt(updatedAt)
                .deleteYn(deleteYn)
                .build();
    }
}
