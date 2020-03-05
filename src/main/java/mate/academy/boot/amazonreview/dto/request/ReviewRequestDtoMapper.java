package mate.academy.boot.amazonreview.dto.request;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.boot.amazonreview.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewRequestDtoMapper {
    public List<Review> getReviewsFromDto(List<ReviewRequestDto> reviewsDto) {
        return reviewsDto.stream()
                .map(dto -> {
                    Review review = new Review();
                    review.setId(dto.getId());
                    review.setProductId(dto.getProductId());
                    review.setUserId(dto.getUserId());
                    review.setProfileName(dto.getProfileName());
                    review.setHelpfulnessNumerator(dto.getHelpfulnessNumerator());
                    review.setHelpfulnessDenominator(dto.getHelpfulnessDenominator());
                    review.setScore(dto.getScore());
                    Timestamp time = new Timestamp(Long.parseLong(dto.getTime()) * 1000);
                    review.setTime(time.toLocalDateTime().toLocalDate());
                    review.setSummary(dto.getSummary());
                    review.setText(dto.getText());
                    return review;
                })
                .collect(Collectors.toList());
    }
}
