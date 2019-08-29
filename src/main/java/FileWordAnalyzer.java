import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FileHelper fileHelper;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.fileHelper = new FileHelper(filePartReader);
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String[] words = fileHelper.getWords();
        return Arrays.stream(words)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getWordsContainingSubstring(String substring) throws IOException {
        String[] words = fileHelper.getWords();
        return Arrays.stream(words)
                .filter(word -> word.contains(substring))
                .collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        String[] words = fileHelper.getWords();
        return Arrays.stream(words)
                .filter(word -> word.toLowerCase().equals(fileHelper.getAnReverseString(word)))
                .collect(Collectors.toList());
    }

}
