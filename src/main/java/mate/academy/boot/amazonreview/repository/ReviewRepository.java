package mate.academy.boot.amazonreview.repository;

import mate.academy.boot.amazonreview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
