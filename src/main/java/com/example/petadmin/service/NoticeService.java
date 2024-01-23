package com.example.petadmin.service;

import com.example.petadmin.db.NoticeBoardMapper;
import com.example.petadmin.dto.NoticeSaveDto;
import com.example.petadmin.entity.NoticeEntity;
import com.example.petadmin.util.Header;
import com.example.petadmin.util.Pagination;
import com.example.petadmin.util.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeBoardMapper noticeBoardMapper;

    public Header<List<NoticeEntity>> getNoticeList(int page, int size, Search search) {
        HashMap<String, Object> paramMap = new HashMap<>();

        if (page <= 1) {    //페이지가 1 이하로 입력되면 0으로 고정,
            paramMap.put("page", 0);
        } else {            //페이지가 2 이상
            paramMap.put("page", (page - 1) * size);
        }
        paramMap.put("size", size);
        paramMap.put("sk", search.getSk());
        paramMap.put("sv", search.getSv());

        List<NoticeEntity> noticeList = noticeBoardMapper.getNoticeList(paramMap);
        Pagination pagination = new Pagination(
                noticeBoardMapper.getNoticeListCount(paramMap),
                page,
                size,
                10
        );

        return Header.OK(noticeList, pagination);
    }

    public Header<NoticeEntity> getNoticeDetail(Long idx) {
        return Header.OK(noticeBoardMapper.getNoticeDetail(idx));
    }

    public Header<NoticeEntity> insertNotice(NoticeSaveDto noticeSaveDto) {
        NoticeEntity entity = noticeSaveDto.toEntity();
        if (noticeBoardMapper.insertNotice(entity) > 0) {
            return Header.OK(entity);
        } else {
            return Header.ERROR("ERROR");
        }
    }

    public Header<NoticeEntity> updateNotice(NoticeSaveDto noticeSaveDto) {
        NoticeEntity entity = noticeSaveDto.toEntity();
        if (noticeBoardMapper.updateNotice(entity) > 0) {
            return Header.OK(entity);
        } else {
            return Header.ERROR("ERROR");
        }
    }

    public Header<String> deleteNotice(Long idx) {
        if (noticeBoardMapper.deleteNotice(idx) > 0) {
            return Header.OK();
        } else {
            return Header.ERROR("ERROR");
        }
    }
}
