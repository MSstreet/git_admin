package com.example.petadmin.controller;

import com.example.petadmin.controller.request.UserSaveRequest;
import com.example.petadmin.controller.response.Response;
import com.example.petadmin.controller.response.UserJoinResponse;
import com.example.petadmin.model.entity.user.UserEntity;
import com.example.petadmin.service.UserService;
import com.example.petadmin.util.Header;
import com.example.petadmin.util.Search;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public Header<List<UserEntity>> getUserList(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size, Search search) {
        return userService.getUserList(page, size, search);
    }

    @GetMapping("/{idx}")
    public Header<UserEntity> getUserDetail(@PathVariable Long idx) {
        return userService.getUserDetail(idx);
    }

//    @PostMapping("/signup")
//    public Header<UserEntity> insertUser(@RequestBody @Valid UserSaveRequest userSaveRequest) {
//        return userService.insertUser(userSaveRequest);
//    }

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserSaveRequest request) {
        return Response.success(UserJoinResponse.fromUser(userService.join(request)));
    }

//    @PatchMapping("/update")
//    public Header<UserEntity> updateUser(@RequestBody UserSaveRequest userSaveRequest) {
//        return userService.updateUser(userSaveRequest);
//    }

    @DeleteMapping("/{idx}")
    public Header<String> deleteUser(@PathVariable Long idx) {
        return userService.deleteUser(idx);
    }
}
