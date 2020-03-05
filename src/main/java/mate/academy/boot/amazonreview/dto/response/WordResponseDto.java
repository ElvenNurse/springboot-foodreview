package mate.academy.boot.amazonreview.dto.response;

import lombok.Data;

@Data
public class WordResponseDto {
    private String word;
    private Long occurrences;
}
