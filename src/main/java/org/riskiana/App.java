package org.riskiana;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.riskiana.rules.UppercaseWordRule;
import org.riskiana.rules.WordLengthRule;

@Slf4j(topic = Constants.LOGGER_NAME)
public class App {
  static final List<Rule> rules = Arrays.asList(
      new WordLengthRule(),
      new UppercaseWordRule());

  public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println("Usage: java -jar indexia.jar <file1> <file2> ...");
      return;
    }
    try {
      processFile(args);
    } catch (Exception e) {
      System.err.println("Error processing file: " + e.getMessage());
      System.exit(1);
    }
  }

  public static void processFile(String[] args) {
    Arrays.stream(args).forEach(fileName -> {
      Path path = Paths.get(fileName);
      if (!path.toFile().exists()) {
        System.err.println("skipping missing file: " + fileName);
        return;
      }
      log.info("processing file: {}", fileName);
      RuleProcessor processor = new RuleProcessor(rules);
      processor.execute(getContents(fileName));
    });
  }

  public static List<String> getContents(String fileName) {
    try {
      return Files.lines(Paths.get(fileName))
          .flatMap(line -> Arrays.stream(line.split("\\W+")))
          .map(String::trim) // Remove whitespace
          .filter(word -> !word.isEmpty()) // Remove empty strings
          .collect(Collectors.toList());
    } catch (IOException e) {
      log.error("Error reading file: {} - {}", fileName, e.getMessage());
      return List.of();
    }
  }
}