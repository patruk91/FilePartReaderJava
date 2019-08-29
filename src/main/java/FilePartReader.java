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

    private void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine) {
            throw new IllegalArgumentException("Invalid argument: fromLine is bigger than toLine");
        } else if (fromLine < 1) {
            throw new IllegalArgumentException("Invalid argument: fromLine is bigger than toLine");
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    public String read() throws IOException {
        return Files.readString(Paths.get(filePath));
    }

    public String readLines() throws IOException {
        StringBuilder sb = new StringBuilder();
        String content = read();
        if (!content.isEmpty()) {
            String newLineString = System.lineSeparator();
            String[] lines = content.split(System.lineSeparator());
            toLine = Math.min(toLine, lines.length);

            int startLine = fromLine - 1;
            for (int i = startLine; i < toLine; i++) {
                sb.append(lines[i]).append(" ");
            }
        }
        return sb.toString();
    }
}
