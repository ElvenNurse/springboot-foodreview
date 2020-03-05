package mate.academy.boot.amazonreview.repository;

import java.util.List;

import mate.academy.boot.amazonreview.dto.response.ProductResponseDto;
import mate.academy.boot.amazonreview.dto.response.UserResponseDto;
import mate.academy.boot.amazonreview.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT "
            + "new mate.academy.boot.amazonreview.dto.response.UserResponseDto("
            + "r.userId, r.profileName, COUNT(r.userId)) "
            + "FROM Review r GROUP BY r.userId, r.profileName ORDER BY COUNT(r.userId) DESC")
    Page<UserResponseDto> getMostActiveUsers(Pageable pageable);

    @Query("SELECT "
            + "new mate.academy.boot.amazonreview.dto.response.ProductResponseDto("
            + "r.productId, COUNT(r.productId)) "
            + "FROM Review r GROUP BY r.productId ORDER BY COUNT(r.productId) DESC")
    Page<ProductResponseDto> getMostReviewedProduct(Pageable pageable);

    @Query("SELECT new java.lang.String(r.text) FROM Review r")
    List<String> getReviewsText();
}
