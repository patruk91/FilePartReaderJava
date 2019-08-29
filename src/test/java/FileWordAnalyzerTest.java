import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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
        //should be split at arrange act?
        //arrange
        List<String> expected = Arrays.asList("alpha", "beta", "gamma", "theta", "zeta");
        //act
        List<String> actual = new ArrayList<>();
        try {
            when(filePartReaderMock.readLines()).thenReturn("gamma zeta beta theta alpha");
            actual = fileWordAnalyzer.getWordsOrderedAlphabetically();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    void IfIsEmptyListFromEmptyString() {
        List<String> expected = Collections.singletonList("");
        List<String> actual = new ArrayList<>();
        try {
            when(filePartReaderMock.readLines()).thenReturn("");
            actual = fileWordAnalyzer.getWordsOrderedAlphabetically();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    void verifyIsReadLinesMethodIsInvokedWhenExecuteGetWordsOrderedAlphabetically() {
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

    @Test
    void getWordsContainingSubstringFromString() {
        List<String> expected = Arrays.asList("zeta", "beta", "theta");
        List<String> actual = new ArrayList<>();
        try {
            when(filePartReaderMock.readLines()).thenReturn("gamma zeta beta theta alpha");
            actual = fileWordAnalyzer.getWordsContainingSubstring("eta");

        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    void getWordsContainingSubstringFromStringWithDifferentCases() {
        List<String> expected = Arrays.asList("Zeta", "beta", "Theta");
        List<String> actual = new ArrayList<>();
        try {
            when(filePartReaderMock.readLines()).thenReturn("gamma Zeta beta Theta alpha");
            actual = fileWordAnalyzer.getWordsContainingSubstring("eta");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    void verifyIsReadLinesMethodIsInvokedWhenExecuteGetWordsContainingSubstring() {
        String filePath = "F:\\JAVA\\PROJECTS\\FilePartReaderJava\\src\\main\\resources\\test.txt";
        int fromLine = 1;
        int toLine = 5;
        FilePartReader filePartReaderSpy = spy(FilePartReader.class);
        filePartReaderSpy.setup(filePath, fromLine, toLine);
        FileWordAnalyzer fileWordAnalyzerSpy = new FileWordAnalyzer(filePartReaderSpy);

        try {
            fileWordAnalyzerSpy.getWordsContainingSubstring("test");
            verify(filePartReaderSpy).readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getWordsWhichArePalindromesFromString() {
        List<String> expected = Arrays.asList("abba", "rotor", "kayak");
        List<String> actual = new ArrayList<>();
        try {
            when(filePartReaderMock.readLines()).thenReturn("palindromes abba arguments class rotor kayak");
            actual = fileWordAnalyzer.getStringsWhichPalindromes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    void getWordsWhichArePalindromesFromStringWithDifferentCases() {
        List<String> expected = Arrays.asList("Abba", "rOtor", "kayaK");
        List<String> actual = new ArrayList<>();
        try {
            when(filePartReaderMock.readLines()).thenReturn("PalinDromes Abba arguments class rOtor kayaK");
            actual = fileWordAnalyzer.getStringsWhichPalindromes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    void verifyIsReadLinesMethodIsInvokedWhenExecuteGetStringsWhichPalindromes() {
        String filePath = "F:\\JAVA\\PROJECTS\\FilePartReaderJava\\src\\main\\resources\\test.txt";
        int fromLine = 1;
        int toLine = 5;
        FilePartReader filePartReaderSpy = spy(FilePartReader.class);
        filePartReaderSpy.setup(filePath, fromLine, toLine);
        FileWordAnalyzer fileWordAnalyzerSpy = new FileWordAnalyzer(filePartReaderSpy);

        try {
            fileWordAnalyzerSpy.getStringsWhichPalindromes();
            verify(filePartReaderSpy).readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}