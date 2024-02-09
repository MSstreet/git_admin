package com.example.petadmin.controller;

import com.example.petadmin.dto.user.UserSaveDto;
import com.example.petadmin.entity.UserEntity;
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

    @PostMapping("/insert")
    public Header<UserEntity> insertUser(@RequestBody @Valid UserSaveDto userSaveDto) {
        return userService.insertUser(userSaveDto);
    }

    @PatchMapping("/update")
    public Header<UserEntity> updateUser(@RequestBody UserSaveDto userSaveDto) {
        return userService.updateUser(userSaveDto);
    }

    @DeleteMapping("/{idx}")
    public Header<String> deleteUser(@PathVariable Long idx) {
        return userService.deleteUser(idx);
    }
}
