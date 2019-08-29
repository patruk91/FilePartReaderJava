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
}
