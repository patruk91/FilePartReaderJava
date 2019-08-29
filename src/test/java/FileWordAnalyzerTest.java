import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileWordAnalyzerTest {
    @Mock
    FilePartReader filePartReaderMock = mock(FilePartReader.class);

    @InjectMocks
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReaderMock);

    @Test
    void SortWordAlphabeticallyFromString() {

        List<String> expected = Arrays.asList("alpha", "beta", "gamma", "theta", "zeta");
        try {
            when(filePartReaderMock.readLines()).thenReturn("gamma zeta beta theta alpha");
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> actual = new ArrayList<>();
        try {
            actual = fileWordAnalyzer.getWordsOrderedAlphabetically();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    void IfIsEmptyListFromEmptyString() {

        List<String> expected = Collections.singletonList("");
        try {
            when(filePartReaderMock.readLines()).thenReturn("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> actual = new ArrayList<>();
        try {
            actual = fileWordAnalyzer.getWordsOrderedAlphabetically();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    void verifyIsReadLinesMethodIsInvokedWhenExecute() {
        String filePath = "F:\\JAVA\\PROJECTS\\FilePartReaderJava\\src\\main\\resources\\test.txt";
        int fromLine = 1;
        int toLine = 5;
        FilePartReader filePartReaderSpy = spy(FilePartReader.class);
        filePartReaderSpy.setup(filePath, fromLine, toLine);
        FileWordAnalyzer fileWordAnalyzerSpy = new FileWordAnalyzer(filePartReaderSpy);

        try {
            fileWordAnalyzerSpy.getWordsOrderedAlphabetically();
            verify(filePartReaderSpy).readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}