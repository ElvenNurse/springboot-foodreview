package mate.academy.boot.amazonreview.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import mate.academy.boot.amazonreview.dto.request.ReviewRequestDto;
import mate.academy.boot.amazonreview.dto.request.ReviewRequestDtoMapper;
import mate.academy.boot.amazonreview.entity.Review;
import mate.academy.boot.amazonreview.service.FileService;
import mate.academy.boot.amazonreview.service.ReviewService;
import mate.academy.boot.amazonreview.util.CsvUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitializationController {
    private Logger logger = LogManager.getLogger(InitializationController.class);

    private ReviewService reviewService;
    private CsvUtils csvUtils;
    private ReviewRequestDtoMapper requestDtoMapper;
    private FileService fileService;

    @Autowired
    public InitializationController(ReviewService reviewService, CsvUtils csvUtils,
                                    ReviewRequestDtoMapper requestDtoMapper,
                                    FileService fileService) {
        this.reviewService = reviewService;
        this.csvUtils = csvUtils;
        this.requestDtoMapper = requestDtoMapper;
        this.fileService = fileService;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            LocalDateTime now = LocalDateTime.now();
            logger.info("Start reading from file");
            File file = fileService.getInitFile();
            List<ReviewRequestDto> dtoList = csvUtils.read(ReviewRequestDto.class, file);
            logger.info("Successfully read data from file!");
            logger.debug("Time spent for reading in seconds "
                    + ChronoUnit.SECONDS.between(now, now = LocalDateTime.now()));
            List<Review> reviews = requestDtoMapper.getReviewsFromDto(dtoList);
            logger.info("Start writing  to DB, it may take time, please wait.");
            reviewService.saveAll(reviews);
            logger.info("Successfully write data to DB!");
            logger.debug("Time spent for writing in seconds "
                    + ChronoUnit.SECONDS.between(now, LocalDateTime.now()));
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while initializing application!\n"
                    + "Please check input file, refer to README.MD\n" + e);
        }
    }
}
