package mate.academy.boot.amazonreview.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(value = "Get most active users",
            notes = "Gets 1000 users with most reviews count. Uses pagination.")
    public List<UserResponseDto> getTopUsers(
            @ApiParam(value = "Set the page number")
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @ApiParam(value = "Set the limit of results per page")
            @RequestParam(name = "limit", defaultValue = "50") Integer limit) {
        return reviewService.getMostActiveUsers(PageRequest.of(page, limit));
    }

    @GetMapping("/top-products")
    @ApiOperation(value = "Get most reviewed products",
            notes = "Gets 1000 products with most reviews count. Uses pagination.")
    public List<ProductResponseDto> getTopProducts(
            @ApiParam(value = "Set the page number")
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @ApiParam(value = "Set the limit of results per page")
            @RequestParam(name = "limit", defaultValue = "50") Integer limit) {
        return reviewService.getMostReviewedProduct(PageRequest.of(page, limit));
    }

    @GetMapping("/top-words")
    @ApiOperation(value = "Get most used words",
            notes = "Gets 1000 most used words in reviews. Uses pagination.")
    public List<WordResponseDto> getTopWords(
            @ApiParam(value = "Set the page number")
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @ApiParam(value = "Set the limit of results per page")
            @RequestParam(name = "limit", defaultValue = "50") Integer limit) {
        return reviewService.getMostUsedWords(page, limit);
    }
}
