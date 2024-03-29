import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine) {
            throw new IllegalArgumentException(
                    "Invalid argument: fromLine is bigger than toLine");
        } else if (fromLine < 1) {
            throw new IllegalArgumentException(
                    "Invalid argument: fromLine is less than one. Cannot read the file");
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    public String read() throws IOException {
        return Files.readString(Paths.get(filePath)).stripTrailing();
    }

    public String readLines() throws IOException {
        StringBuilder sb = new StringBuilder();
        String content = read();
        if (!content.isEmpty()) {
            String[] lines = content.split("\\n");
            toLine = Math.min(toLine, lines.length);

            int startLine = fromLine - 1;
            for (int i = startLine; i < toLine; i++) {
                sb.append(lines[i].trim()).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
