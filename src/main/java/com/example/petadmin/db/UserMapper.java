package com.example.petadmin.db;

import com.example.petadmin.entity.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    List<UserEntity> getUserList(HashMap<String, Object> paramMap);

    Integer getUserListCount(HashMap<String, Object> paramMap);

    UserEntity getUserDetail(Long idx);

    int insertUser(UserEntity entity);

    int updateUser(UserEntity entity);

    int deleteUser(Long idx);
}
