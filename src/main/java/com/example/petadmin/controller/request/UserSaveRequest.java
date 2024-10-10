package com.example.petadmin.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSaveRequest {

    //@NotBlank(message = "유저 ID를 입력하세요")
    private String userId;
    //@NotBlank(message = "비밀번호를 입력하세요")
    private String userPw;
    //@NotBlank(message = "유저명을 입력하세요")
    private String userName;
    //@NotBlank(message = "유저번호를 입력하세요")
    private String phoneNum;
    //@NotBlank(message = "이메일을 입력하세요")
    private String email;
    //@NotBlank(message = "주소를 입력하세요")
    private String addr;
    private String detailAddr;
    private String zipCode;
    private String createAt;
    private String updatedAt;
    private int deleteYn;
}
