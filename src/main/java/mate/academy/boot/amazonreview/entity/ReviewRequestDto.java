package mate.academy.boot.amazonreview.entity;

import lombok.Data;

@Data
public class ReviewRequestDto {
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private Integer helpfulnessNumerator;
    private Integer helpfulnessDenominator;
    private Integer score;
    private String time;
    private String summary;
    private String text;
}
