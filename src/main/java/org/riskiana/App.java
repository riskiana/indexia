package org.riskiana;

public class App {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println("Usage: java -jar indexio.jar <file1> <file2> ...");
      return;
    }
    try {
      processFile(args);
    } catch (Exception e) {
      System.out.println("Error processing file:"+ e.getMessage());
      System.exit(1);
    }
  }

  private static void processFile(String[] args) {
    //to do
  }
}