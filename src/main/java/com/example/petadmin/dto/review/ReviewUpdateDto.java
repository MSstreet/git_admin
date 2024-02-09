package com.example.petadmin.dto.review;


import com.example.petadmin.entity.ReviewEntity;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewUpdateDto {

    private Long reviewIdx;
    private String content;

    private int effectScore;
    private int priceScore;
    private int kindnessScore;

    private float score;
    private float tmpScore;

    private int approveYn;
    private int deleteYn;

    private String updatedAt;

    public ReviewEntity toEntity(){
        return ReviewEntity.builder()
                .content(content)
                .effectScore(effectScore)
                .priceScore(priceScore)
                .kindnessScore(kindnessScore)
                .score(score)
                .tmpScore(tmpScore)
                .approveYn(approveYn)
                .deleteYn(deleteYn)
                .updatedAt(updatedAt)
                .build();
    }

}
