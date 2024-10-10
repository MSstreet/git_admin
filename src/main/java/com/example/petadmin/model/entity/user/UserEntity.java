package com.example.petadmin.model.entity.user;
import com.example.petadmin.controller.request.UserSaveRequest;
import com.example.petadmin.model.dto.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    private Long userIdx;
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;
    private String userId;
    private String userPw;
    private String userName;
    private String phoneNum;
    private String email;
    private String addr;
    private String detailAddr;
    private String zipCode;
    private String createAt;
    private String updatedAt;
    private int deleteYn;

    public static UserEntity of(UserSaveRequest userSaveRequest) {
        UserEntity entity = new UserEntity();
        entity.setUserId(userSaveRequest.getUserId());
        entity.setUserPw(userSaveRequest.getUserPw());
        entity.setUserName(userSaveRequest.getUserName());
        entity.setPhoneNum(userSaveRequest.getPhoneNum());
        entity.setEmail(userSaveRequest.getEmail());
        entity.setAddr(userSaveRequest.getAddr());
        entity.setDetailAddr(userSaveRequest.getDetailAddr());
        entity.setDetailAddr(userSaveRequest.getDetailAddr());
        entity.setZipCode(userSaveRequest.getZipCode());
        return entity;
    }

}