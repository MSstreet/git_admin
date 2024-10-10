package com.example.petadmin.controller;

import com.example.petadmin.model.dto.review.ReviewUpdateDto;
import com.example.petadmin.model.entity.review.ReviewEntity;
import com.example.petadmin.service.ReviewService;
import com.example.petadmin.util.Header;
import com.example.petadmin.util.Search;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/review")
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/list")
    Header<List<ReviewEntity>> getReviewList(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size, Search search) {
        return reviewService.getReviewList(page, size, search);
    }

    @DeleteMapping("/{idx}")
    Header<String> deleteReview(@PathVariable Long idx){
        return reviewService.deleteReview(idx);
    }

    @PatchMapping("/update")
    Header<ReviewEntity> updateReview(@RequestBody @Valid ReviewUpdateDto reviewUpdateDto){
        return reviewService.updateReview(reviewUpdateDto);
    }

    @PatchMapping("/approve/{reviewIdx}")
    Header<ReviewEntity> approveReview(@PathVariable("reviewIdx") Long reviewIdx){
        return reviewService.approveReview(reviewIdx);
    }

    @GetMapping("/{reviewIdx}")
    Header<ReviewEntity> getReview(@PathVariable("reviewIdx") Long idx){
        return reviewService.getReview(idx);
    }

}
