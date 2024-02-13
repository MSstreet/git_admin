package com.example.petadmin.controller.exception.notice;

import com.example.petadmin.controller.exception.BaseException;
import lombok.Getter;

@Getter
public class NoticeNotFound extends BaseException  {

    private static final String MESSAGE = "존재하지않는 공지사항입니다.";

    public NoticeNotFound(){
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
