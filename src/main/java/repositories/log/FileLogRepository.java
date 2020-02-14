package repositories.log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileLogRepository implements LogRepository {
    private String filepath;

    public FileLogRepository(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<String> getLogs() {
        try {
            return Files.readAllLines(Paths.get(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
