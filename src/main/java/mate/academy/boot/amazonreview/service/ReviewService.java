package mate.academy.boot.amazonreview.service;

import java.util.List;
import mate.academy.boot.amazonreview.dto.response.ProductResponseDto;
import mate.academy.boot.amazonreview.dto.response.ReviewUserResponseDto;
import mate.academy.boot.amazonreview.dto.response.WordResponseDto;
import mate.academy.boot.amazonreview.entity.Review;
import org.springframework.data.domain.PageRequest;

public interface ReviewService {
    List<Review> saveAll(List<Review> reviews);

    List<ReviewUserResponseDto> getMostActiveUsers(PageRequest pageRequest);

    List<ProductResponseDto> getMostReviewedProduct(PageRequest pageRequest);

    List<WordResponseDto> getMostUsedWords(Integer page, Integer limit);
}
