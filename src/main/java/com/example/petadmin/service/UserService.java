package com.example.petadmin.service;

import com.example.petadmin.db.UserMapper;
import com.example.petadmin.dto.user.UserSaveDto;
import com.example.petadmin.entity.user.UserEntity;
import com.example.petadmin.util.Header;
import com.example.petadmin.util.Pagination;
import com.example.petadmin.util.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    public Header<List<UserEntity>> getUserList(int page, int size, Search search) {
        HashMap<String, Object> paramMap = new HashMap<>();

        if (page <= 1) {    //페이지가 1 이하로 입력되면 0으로 고정,
            paramMap.put("page", 0);
        } else {            //페이지가 2 이상
            paramMap.put("page", (page - 1) * size);
        }

        paramMap.put("size", size);
        paramMap.put("sk", search.getSk());
        paramMap.put("sv", search.getSv());

        List<UserEntity> userList = userMapper.getUserList(paramMap);

        Pagination pagination = new Pagination(
                userMapper.getUserListCount(paramMap),
                page,
                size,
                10
        );

        return Header.OK(userList, pagination);
    }

    public Header<UserEntity> getUserDetail(Long idx) {
        // To do : Null일 경우 예외처리
        return Header.OK(userMapper.getUserDetail(idx));
    }

    public Header<UserEntity> insertUser(UserSaveDto userSaveDto) {
        UserEntity entity = userSaveDto.toEntity();
        if (userMapper.insertUser(entity) > 0) {
            return Header.OK(entity);
        } else {
            return Header.ERROR("ERROR");
        }
    }

    public Header<UserEntity> updateUser(UserSaveDto userSaveDto) {
        // To do : Null일 경우 예외처리
        UserEntity entity = userSaveDto.toEntity();
        if (userMapper.updateUser(entity) > 0) {
            return Header.OK(entity);
        } else {
            return Header.ERROR("ERROR");
        }
    }

    public Header<String> deleteUser(Long idx) {
        // To do : Null일 경우 예외처리
        if (userMapper.deleteUser(idx) > 0) {
            return Header.OK();
        } else {
            return Header.ERROR("ERROR");
        }
    }
}
