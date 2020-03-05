package mate.academy.boot.amazonreview.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import mate.academy.boot.amazonreview.dto.response.WordResponseDto;
import mate.academy.boot.amazonreview.dto.response.WordResponseDtoMapper;
import mate.academy.boot.amazonreview.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService {
    private WordResponseDtoMapper wordMapper;

    @Autowired
    public TextServiceImpl(WordResponseDtoMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    @Override
    public List<WordResponseDto> getMostUsedWords(List<String> reviews,
                                                  Integer page, Integer limit) {
        List<String> separatedWords = new ArrayList<>();
        for (String review : reviews) {
            String[] reviewWords = cleanString(review).split(" ");
            separatedWords.addAll(Arrays.asList(reviewWords));
        }
        Map<String, Long> map = separatedWords.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        List<WordResponseDto> result = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1000)
                .map(wordMapper::getWordDtoFromEntry)
                .collect(Collectors.toList());
        return getPage(result, page, limit);
    }

    private String cleanString(String review) {
        return review.toLowerCase().replaceAll("[^\\w\\s]", "")
                .trim().replaceAll("\\s{2,}", " ");
    }

    private List<WordResponseDto> getPage(List<WordResponseDto> list, Integer page, Integer limit) {
        if (list == null) {
            return Collections.emptyList();
        }
        if (limit == null || limit <= 0 || limit > list.size()) {
            limit = list.size();
        }
        int numPages = (int) Math.ceil((double)list.size() / (double)limit);
        List<List<WordResponseDto>> pages = new ArrayList<>(numPages);
        for (int pageNum = 0; pageNum < numPages;) {
            pages.add(list.subList(pageNum * limit, Math.min(++pageNum * limit, list.size())));
        }
        return pages.get(page);
    }
}
