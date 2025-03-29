package org.riskiana;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.riskiana.rules.UppercaseWordRule;
import org.riskiana.rules.WordLengthRule;

public class RuleProcessorTest {
  private UppercaseWordRule uppercaseWordRule;
  private WordLengthRule wordLengthRule;
  static String file1 = "src/test/resources/file1.txt";
  static String file2 = "src/test/resources/file2.html";

  @BeforeEach
  public void setUp() {
    uppercaseWordRule = new UppercaseWordRule();
    wordLengthRule = new WordLengthRule();
  }

  @Test
  void processFileTest() {
    App.processFile(new String[]{file1});
  }

  @Test
  public void testUppercaseWordCountRule() {
    List<String> words = List.of("HELLO", "world", "HELLO", "world");
    uppercaseWordRule.apply(words);
    assertEquals(2, uppercaseWordRule.getCount());
  }

}
