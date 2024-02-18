package com.example.petadmin.dto.review;


import com.example.petadmin.entity.review.ReviewEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewUpdateDto {

    private Long reviewIdx;
    @NotBlank(message = "내용을 입력하세요")
    private String content;
    @NotBlank(message = "효과 평점을 입력하세요")
    private int effectScore;
    @NotBlank(message = "가격 평점을 입력하세요")
    private int priceScore;
    @NotBlank(message = "친절 평점을 입력하세요")
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
