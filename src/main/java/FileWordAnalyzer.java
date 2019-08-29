import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String content = filePartReader.readLines();
        List<String> words = Arrays.asList(content.split(" "));
        Collections.sort(words);
        return words;
    }

    public List<String> getWordsContainingSubstring(String substring) throws IOException {
        String content = filePartReader.readLines();
        String[] words = content.split(" ");
        return Arrays.stream(words).filter(word -> word.equals(substring)).collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        String content = filePartReader.readLines();
        String[] words = content.split(" ");
        return Arrays.stream(words)
                .filter(word -> word.toLowerCase().equals(getAnReverseString(word)))
                .collect(Collectors.toList());
    }

    private String getAnReverseString(String word) {
        return new StringBuilder(word.toLowerCase()).reverse().toString();
    }


}
