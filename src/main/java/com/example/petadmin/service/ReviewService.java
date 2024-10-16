package com.example.petadmin.service;

import com.example.petadmin.db.ReviewMapper;
import com.example.petadmin.model.dto.review.ReviewUpdateDto;
import com.example.petadmin.model.entity.review.ReviewEntity;
import com.example.petadmin.utils.Header;
import com.example.petadmin.utils.Pagination;
import com.example.petadmin.utils.Search;
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

    public Header<String> deleteReview(Long idx) {
        // To do : Null일 경우 예외처리
        if(reviewMapper.deleteReview(idx) > 0) {
            return Header.OK();
        }else{
            return Header.ERROR("ERROR");
        }
    }

    public Header<ReviewEntity> updateReview(ReviewUpdateDto reviewUpdateDto) {
        // To do : Null일 경우 예외처리
        ReviewEntity entity = reviewUpdateDto.toEntity();
        if(reviewMapper.updateReview(entity) > 0){
            return Header.OK(entity);
        }
        else{
            return Header.ERROR("ERROR");
        }
    }

    public Header<ReviewEntity> approveReview(Long reviewIdx) {
        // To do : Null일 경우 예외처리
        ReviewEntity entity = reviewMapper.getReview(reviewIdx);
        if(entity.getApproveYn() == 0){
           entity.setApproveYn(1);
        }
        if(reviewMapper.approveReview(entity) > 0){
            return Header.OK(entity);
        }
        else{
            return Header.ERROR("ERROR");
        }
    }

    public Header<ReviewEntity> getReview(Long idx) {
        ReviewEntity entity = reviewMapper.getReview(idx);
        return Header.OK(entity);
    }
}
