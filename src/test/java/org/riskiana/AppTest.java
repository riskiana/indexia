package org.riskiana;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class AppTest {
  @Test
  void testMainWithNoArguments() {

    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    System.setErr(new PrintStream(errContent));

    App.main(new String[]{});

    assertEquals("Usage: java -jar indexia.jar <file1> <file2> ...\n", errContent.toString());
  }

  @Test
  void testMissingFile() {

    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    System.setErr(new PrintStream(errContent));
    String[] args = new String[]{"file1.txt"};

    App.main(args);
    final var expected = "skipping missing file: "+args[0].trim();
    final var actual = errContent.toString().trim();
    assertEquals(expected, actual);
  }

}
