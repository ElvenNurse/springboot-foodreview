package mate.academy.boot.amazonreview.service;

import java.util.List;
import mate.academy.boot.amazonreview.dto.response.WordResponseDto;

public interface TextService {
    List<WordResponseDto> getMostUsedWords(List<String> reviews, Integer page, Integer limit);
}
