package com.example.petadmin.service;

import com.example.petadmin.db.ReviewMapper;
import com.example.petadmin.entity.ReviewEntity;
import com.example.petadmin.util.Header;
import com.example.petadmin.util.Pagination;
import com.example.petadmin.util.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public Header<List<ReviewEntity>> getReviewList (int page, int size, Search search){

        HashMap<String, Object> paramMap = new HashMap<>();

        if (page <= 1) {    //페이지가 1 이하로 입력되면 0으로 고정,
            paramMap.put("page", 0);
        } else {            //페이지가 2 이상
            paramMap.put("page", (page - 1) * size);
        }
        paramMap.put("size", size);
        paramMap.put("sk", search.getSk());
        paramMap.put("sv", search.getSv());

        List<ReviewEntity> reviewList = reviewMapper.getReviewList(paramMap);
        Pagination pagination = new Pagination(
                reviewMapper.getReviewListCount(paramMap),
                page,
                size,
                10
        );

        return Header.OK(reviewList, pagination);
    }

}
