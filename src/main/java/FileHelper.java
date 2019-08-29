import java.io.IOException;

public class FileHelper {
    private FilePartReader filePartReader;

    public FileHelper(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public String getAnReverseString(String word) {
        return new StringBuilder(word.toLowerCase()).reverse().toString();
    }

    public String[] getWords() throws IOException {
        String content = filePartReader.readLines();
        return content.split(" ");
    }
}
