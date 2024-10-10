package com.example.petadmin.controller.response;

import com.example.petadmin.model.dto.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinResponse {

    private Long id;
    private String name;

    public static UserJoinResponse fromUser(User user) {
        return new UserJoinResponse(
                user.getUserIdx(),
                user.getUserName()
        );
    }
}
