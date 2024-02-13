package com.example.petadmin.dto.user;

import com.example.petadmin.entity.NoticeEntity;
import com.example.petadmin.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSaveDto {

    @NotBlank(message = "유저 ID를 입력하세요")
    private String userId;
    @NotBlank(message = "비밀번호를 입력하세요")
    private String userPw;
    @NotBlank(message = "유저명을 입력하세요")
    private String userName;
    @NotBlank(message = "유저번호를 입력하세요")
    private String userNum;
    @NotBlank(message = "이메일을 입력하세요")
    private String email;
    @NotBlank(message = "주소를 입력하세요")
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
