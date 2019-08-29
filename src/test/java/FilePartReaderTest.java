import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FilePartReaderTest {
    private FilePartReader filePartReader;

    @BeforeEach
    void setUp() {
         this.filePartReader = new FilePartReader();
    }

    @Test
    void throwIOExceptionAtDefaultSetup() {
        assertThrows(IOException.class, () -> filePartReader.read());
    }

    @Test
    void throwIllegalArgumentExceptionIfFromLineIsBiggerThanToLine() {
        String filePath = "";
        int fromLine = 4;
        int toLine = 1;
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(filePath, fromLine, toLine));
    }

    @Test
    void throwIllegalArgumentExceptionIfFromLineIsLessThanOne() {
        String filePath = "";
        int fromLine = 0;
        int toLine = 4;
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(filePath, fromLine, toLine));
    }

    @Test
    void getFileContentWhenReadFromFile() {
        String expectedContent =
                "first line of text\r\n" +
                "second line add remove edit\r\n" +
                "third line some words extra\r\n" +
                "fourth";
        String filePath = "F:\\JAVA\\PROJECTS\\FilePartReaderJava\\src\\main\\resources\\test.txt";
        int fromLine = 1;
        int toLine = 4;
        filePartReader.setup(filePath, fromLine, toLine);
        String actual = null;
        try {
            actual = filePartReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expectedContent, actual);
    }
}