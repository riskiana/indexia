package org.riskiana;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RuleProcessor {
  private final List<Rule> rules;

  public void execute(List<String> words) {
    rules.forEach(rule -> rule.apply(words));

  }

}
