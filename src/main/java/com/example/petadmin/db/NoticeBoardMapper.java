package com.example.petadmin.db;


import com.example.petadmin.model.entity.notice.NoticeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface NoticeBoardMapper {

    List<NoticeEntity> getNoticeList(HashMap<String, Object> paramMap);

    int getNoticeListCount(HashMap<String, Object> paramMap);

    NoticeEntity getNoticeDetail(Long idx);

    int insertNotice(NoticeEntity entity);

    int updateNotice(NoticeEntity entity);

    int deleteNotice(Long idx);

    void deleteAllNotice();

    int insertNoticeList(List<NoticeEntity> noticeEntities);
}
