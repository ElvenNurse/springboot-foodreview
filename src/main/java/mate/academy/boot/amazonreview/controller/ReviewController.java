package mate.academy.boot.amazonreview.controller;

import java.util.List;

import mate.academy.boot.amazonreview.dto.response.ProductResponseDto;
import mate.academy.boot.amazonreview.dto.response.UserResponseDto;
import mate.academy.boot.amazonreview.dto.response.WordResponseDto;
import mate.academy.boot.amazonreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/top-users")
    public List<UserResponseDto> getTopUsers(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "limit", defaultValue = "50") Integer limit) {
        return reviewService.getMostActiveUsers(PageRequest.of(page, limit));
    }

    @GetMapping("/top-products")
    public List<ProductResponseDto> getTopProducts(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "limit", defaultValue = "50") Integer limit) {
        return reviewService.getMostReviewedProduct(PageRequest.of(page, limit));
    }

    @GetMapping("/top-words")
    public List<WordResponseDto> getTopWords(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "limit", defaultValue = "50") Integer limit) {
        return reviewService.getMostUsedWords(page, limit);
    }
}
