package org.riskiana.rules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.riskiana.Constants;
import org.riskiana.Rule;

@Slf4j(topic = Constants.LOGGER_NAME)
public class WordLengthRule implements Rule {
  private static int LONG_WORD_LENGTH = 5;
  private Set<String> uniqueLongWords = new HashSet<>();

  @Override
  public void apply(List<String> words) {
    log.info("Applying word length rule");

  }



}
