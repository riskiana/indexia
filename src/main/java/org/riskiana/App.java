package org.riskiana;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class App {

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

  private static void processFile(String[] args) {
    Arrays.stream(args).forEach(fileName -> {
      Path path = Paths.get(fileName);
      if (!path.toFile().exists()) {
        System.err.println("skipping missing file: " + fileName);
        return;
      }

      System.out.println("Processing file: " + fileName);
    });
  }
}