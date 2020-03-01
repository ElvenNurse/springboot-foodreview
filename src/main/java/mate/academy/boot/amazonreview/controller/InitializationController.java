package mate.academy.boot.amazonreview.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import mate.academy.boot.amazonreview.entity.Review;
import mate.academy.boot.amazonreview.entity.ReviewRequestDto;
import mate.academy.boot.amazonreview.service.ReviewService;
import mate.academy.boot.amazonreview.util.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class InitializationController {
    private ReviewService reviewService;

    @Autowired
    public InitializationController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            File file = new ClassPathResource("Reviews.csv").getFile();
            List<ReviewRequestDto> dtoList = CsvUtils.read(ReviewRequestDto.class, file);
            List<Review> reviews = getReviewsFromDto(dtoList);
            reviewService.saveAll(reviews);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Review> getReviewsFromDto(List<ReviewRequestDto> reviewsDto) {
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
