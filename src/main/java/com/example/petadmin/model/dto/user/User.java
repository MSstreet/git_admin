package com.example.petadmin.model.dto.user;

import com.example.petadmin.model.dto.UserRole;
import com.example.petadmin.model.entity.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class User implements UserDetails {

    private Long userIdx;
    private UserRole role;
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

    public static User fromEntity(UserEntity entity) {
        return new User(
                entity.getUserIdx(),
                entity.getRole(),
                entity.getUserId(),
                entity.getUserPw(),
                entity.getUserName(),
                entity.getPhoneNum(),
                entity.getEmail(),
                entity.getAddr(),
                entity.getDetailAddr(),
                entity.getZipCode(),
                entity.getCreateAt(),
                entity.getUpdatedAt(),
                entity.getDeleteYn()
        );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public String getPassword() {
        return userPw;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

