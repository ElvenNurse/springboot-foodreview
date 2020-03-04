package mate.academy.boot.amazonreview.service;

import java.util.List;

import mate.academy.boot.amazonreview.dto.response.ProductResponseDto;
import mate.academy.boot.amazonreview.dto.response.UserResponseDto;
import mate.academy.boot.amazonreview.dto.response.WordResponseDto;
import mate.academy.boot.amazonreview.entity.Review;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

public interface ReviewService {
    List<Review> saveAll(List<Review> reviews);

    List<UserResponseDto> getMostActiveUsers(PageRequest pageRequest);

    List<ProductResponseDto> getMostReviewedProduct(PageRequest pageRequest);

    List<WordResponseDto> getMostUsedWords(Integer page, Integer limit);
}
