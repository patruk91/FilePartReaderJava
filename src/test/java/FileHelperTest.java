import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class FileHelperTest {
    @Mock
    FilePartReader filePartReaderMock = mock(FilePartReader.class);

    @InjectMocks
    FileHelper fileHelper = new FileHelper(filePartReaderMock);

    @Test
    void splitWordsToArrayFromString() {
        String[] expected = new String[] {"some", "words", "to", "check"};
        String[] actual = new String[4];
        try {
            when(filePartReaderMock.readLines()).thenReturn("some words to check");
            actual = fileHelper.getWords();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    void verifyIsReadLinesMethodIsInvokedWhenExecuteGetWords() {
        String filePath = "F:\\JAVA\\PROJECTS\\FilePartReaderJava\\src\\main\\resources\\test.txt";
        int fromLine = 1;
        int toLine = 5;
        FilePartReader filePartReaderSpy = spy(FilePartReader.class);
        filePartReaderSpy.setup(filePath, fromLine, toLine);
        FileHelper fileHelperSpy = new FileHelper(filePartReaderSpy);

        try {
            fileHelperSpy.getWords();
            verify(filePartReaderSpy).readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void reverseStringFromGivenWord() {
        String expected = "sdrow";
        String actual = "";
        actual = fileHelper.getReverseString("words");
        assertEquals(expected, actual);
    }

    @Test
    void reverseStringFromGivenWordForDifferentCases() {
        String expected = "abba";
        String actual = "";
        actual = fileHelper.getReverseString("AbBa");
        assertEquals(expected, actual);
    }
}