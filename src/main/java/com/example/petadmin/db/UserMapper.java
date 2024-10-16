package com.example.petadmin.db;

import com.example.petadmin.controller.request.UserSaveRequest;
import com.example.petadmin.model.entity.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    List<UserEntity> getUserList(HashMap<String, Object> paramMap);

    Integer getUserListCount(HashMap<String, Object> paramMap);

    UserEntity checkJoinUser(UserSaveRequest userSaveRequest);

    UserEntity getUserDetail(Long idx);

    int insertUser(UserEntity entity);

    //int updateUser(UserEntity entity);

    int deleteUser(Long idx);

    UserEntity checkUserByName(String userId);
}
