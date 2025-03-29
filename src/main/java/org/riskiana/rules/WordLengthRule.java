package org.riskiana.rules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.riskiana.Constants;
import org.riskiana.Rule;

@Slf4j(topic = Constants.LOGGER_NAME)
public class WordLengthRule implements Rule {
  private static final int LONG_WORD_LENGTH = 5;
  private final Set<String> uniqueLongWords = new HashSet<>();

  @Override
  public void apply(List<String> words) {
    log.info("Applying word length rule");
   final var longWords = words.stream()
        .filter(word -> word.length() > LONG_WORD_LENGTH)
        .collect(Collectors.toSet());
    uniqueLongWords.addAll(longWords);
    log.info("uniqueLongWords with length > {}: {}",LONG_WORD_LENGTH,  uniqueLongWords);

  }


  public Set<String> getUniqueLongWords() {
    return uniqueLongWords;
  }


}
