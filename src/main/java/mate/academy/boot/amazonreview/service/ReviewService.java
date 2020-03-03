package mate.academy.boot.amazonreview.service;

import java.util.List;

import mate.academy.boot.amazonreview.entity.Review;

public interface ReviewService {
    List<Review> saveAll(List<Review> reviews);
}
