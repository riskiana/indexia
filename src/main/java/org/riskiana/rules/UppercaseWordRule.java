package org.riskiana.rules;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.riskiana.Constants;
import org.riskiana.Rule;

@Slf4j(topic = Constants.LOGGER_NAME)
public class UppercaseWordRule implements Rule {
  private int count;

  @Override
  public void apply(List<String> words) {
    log.debug("Applying UppercaseWordRule");
    words.stream()
        .forEach(word -> {
          if (Character.isUpperCase(word.charAt(0))) {
            count++;
            log.debug("Found uppercase-starting word: {}", word);
          }
        });
    log.info("UpperCase words count: {}", count);

  }

  public int getCount() {
    return count;
  }
}
