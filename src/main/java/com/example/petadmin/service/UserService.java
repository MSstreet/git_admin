package com.example.petadmin.service;

import com.example.petadmin.controller.exception.ErrorCode;
import com.example.petadmin.controller.exception.PetAdminApplicationException;
import com.example.petadmin.controller.request.UserSaveRequest;
import com.example.petadmin.db.UserMapper;
import com.example.petadmin.model.dto.user.User;
import com.example.petadmin.model.entity.user.UserEntity;
import com.example.petadmin.utils.Header;
import com.example.petadmin.utils.JwtTokenUtils;
import com.example.petadmin.utils.Pagination;
import com.example.petadmin.utils.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;

    @Override
    public User loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity userEntity = userMapper.checkUserByName(userId);
        if(userEntity == null) {
            throw new PetAdminApplicationException(ErrorCode.USER_NOT_FOUND, String.format("userName is %s", userId));
        }
        return User.fromEntity(userEntity);
    }

    @Transactional
    public User join(UserSaveRequest request) {
        // check the userId not exist
        if(userMapper.checkJoinUser(request) != null) {
            throw new PetAdminApplicationException(ErrorCode.DUPLICATED_USER, String.format("userName is %s", request.getEmail()));
        }

        request.setUserPw(encoder.encode(request.getUserPw()));
        UserEntity savedUser = UserEntity.of(request);

        if (userMapper.insertUser(savedUser) > 0) {
            return User.fromEntity(savedUser);
        } else {
            throw new PetAdminApplicationException(ErrorCode.USER_JOIN_ERROR);
        }
        //UserEntity savedUser = userMapper.insertUser(UserEntity.of(request));
    }

    public String login(String userName, String password) {
        User savedUser = loadUserByUsername(userName);
        if (!encoder.matches(password, savedUser.getPassword())) {
            throw new PetAdminApplicationException(ErrorCode.INVALID_PASSWORD);
        }
        return JwtTokenUtils.generateAccessToken(userName, secretKey, expiredTimeMs);
    }

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

    public Header<String> deleteUser(Long idx) {
        // To do : Null일 경우 예외처리
        if (userMapper.deleteUser(idx) > 0) {
            return Header.OK();
        } else {
            return Header.ERROR("ERROR");
        }
    }

//    public Header<UserEntity> insertUser(UserSaveRequest userSaveRequest) {
//        UserEntity entity = userSaveRequest.toEntity();
//        if (userMapper.insertUser(entity) > 0) {
//            return Header.OK(entity);
//        } else {
//            return Header.ERROR("ERROR");
//        }
//    }

//    public Header<UserEntity> updateUser(UserSaveRequest userSaveRequest) {
//        // To do : Null일 경우 예외처리
//        UserEntity entity = userSaveRequest.toEntity();
//        if (userMapper.updateUser(entity) > 0) {
//            return Header.OK(entity);
//        } else {
//            return Header.ERROR("ERROR");
//        }
//    }
}
