package mate.academy.boot.amazonreview.service.impl;

import java.util.List;

import mate.academy.boot.amazonreview.dto.response.ProductResponseDto;
import mate.academy.boot.amazonreview.dto.response.UserResponseDto;
import mate.academy.boot.amazonreview.dto.response.WordResponseDto;
import mate.academy.boot.amazonreview.entity.Review;
import mate.academy.boot.amazonreview.repository.ReviewRepository;
import mate.academy.boot.amazonreview.service.ReviewService;
import mate.academy.boot.amazonreview.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private TextService textService;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, TextService textService) {
        this.reviewRepository = reviewRepository;
        this.textService = textService;
    }

    @Override
    public List<Review> saveAll(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

    @Override
    public List<UserResponseDto> getMostActiveUsers(PageRequest pageRequest) {
        return reviewRepository.getMostActiveUsers(pageRequest).getContent();
    }

    @Override
    public List<ProductResponseDto> getMostReviewedProduct(PageRequest pageRequest) {
        return reviewRepository.getMostReviewedProduct(pageRequest).getContent();
    }

    @Override
    public List<WordResponseDto> getMostUsedWords(Integer page, Integer limit) {
        List<String> reviewsText = reviewRepository.getReviewsText();
        return textService.getMostUsedWords(reviewsText, page, limit);
    }
}
