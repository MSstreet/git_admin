package com.example.petadmin.controller;

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
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

//    @GetMapping("/list")
//    Header<List<UserEntity>> getUserList (@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size, Search search){
//        return userService.getUserList(page,size,search);
//    }
//
//    @GetMapping("{/idx}")
//    Header<UserEntity> getUserDetail(@PathVariable Long idx){
//        return userService.getUserDetail(idx);
//    }
//
////    @PatchMapping("/update")
////    Header<UserEntity> updateUser(@RequestBody UserUpdateDto userUpdateDto){
////
////    }
//
//
//    @DeleteMapping("/{idx}")
//    Header<String> deleteBoard(@PathVariable Long idx) {
//        return userService.deleteUser(idx);
//        }
}

