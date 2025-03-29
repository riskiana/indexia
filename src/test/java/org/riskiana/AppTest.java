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

    assertEquals("Usage: java -jar indexio.jar <file1> <file2> ...\n", errContent.toString());
  }

}
