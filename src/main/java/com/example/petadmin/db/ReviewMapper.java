package com.example.petadmin.db;

import com.example.petadmin.model.entity.review.ReviewEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ReviewMapper {

    List<ReviewEntity> getReviewList(HashMap<String, Object> paramMap);

    int getReviewListCount(HashMap<String, Object> paramMap);

    int deleteReview(Long idx);

    int updateReview(ReviewEntity reviewEntity);

    int approveReview(ReviewEntity entity);

    ReviewEntity getReview(Long idx);
}


