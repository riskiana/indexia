package org.riskiana;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

public class AppTest {

  @Test
  void testMainWithNoArguments() {

    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    System.setErr(new PrintStream(errContent));

    App.main(new String[]{});

    assertEquals("Usage: java -jar indexia.jar <file1> <file2> ...", errContent.toString());
  }

  @Test
  void testMissingFile() {
    Path path = Path.of("src/test/resources/missing.txt");
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> App.validateFile(path));
    assertEquals("File does not exist", exception.getMessage());

  }

  @Test
  void testPdfFile() {
    Path path = Path.of("src/test/resources/file3.pdf");
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> App.validateFile(path));
    assertEquals("PDF files are not supported", exception.getMessage());

  }


}
