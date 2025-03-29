package org.riskiana;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.riskiana.rules.UppercaseWordRule;
import org.riskiana.rules.WordLengthRule;

public class RuleProcessorTest {

  static String file1 = "src/test/resources/file1.txt";
  static String file2 = "src/test/resources/file2.html";
  private UppercaseWordRule uppercaseWordRule;
  private WordLengthRule wordLengthRule;

  @BeforeEach
  public void setUp() {
    uppercaseWordRule = new UppercaseWordRule();
    wordLengthRule = new WordLengthRule();
  }

  @Test
  void processFileTest() {
    App.processFile(new String[]{file1, file2});
  }

  @Test
  public void testUppercaseWordCountRule() {
    List<String> words = List.of("HELLO", "world", "HELLO", "world");
    uppercaseWordRule.apply(words);
    assertEquals(2, uppercaseWordRule.getCount());
  }

  @Test
  public void testWordLengthRule() {
    List<String> words = List.of("Indonesia", "Belgia", "USA", "Canada");
    wordLengthRule.apply(words);
    final var expected = List.of("Indonesia", "Belgia", "Canada");
    assertTrue(expected.containsAll(wordLengthRule.getUniqueLongWords()));
  }

  @Test
  public void testEmptyText() {
    List<String> words = List.of();
    uppercaseWordRule.apply(words);
    assertEquals(0, uppercaseWordRule.getCount());
  }

}
