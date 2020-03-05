package mate.academy.boot.amazonreview.dto.response;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class WordResponseDtoMapper {
    public WordResponseDto getWordDtoFromEntry(Map.Entry<String, Long> entry) {
        WordResponseDto word = new WordResponseDto();
        word.setWord(entry.getKey());
        word.setOccurrences(entry.getValue());
        return word;
    }
}
