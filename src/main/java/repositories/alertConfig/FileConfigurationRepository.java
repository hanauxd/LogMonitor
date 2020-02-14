package repositories.alertConfig;

import com.google.gson.Gson;
import models.Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileConfigurationRepository implements ConfigurationRepository {
    @Override
    public List<Configuration> getConfigurations() {
        try {
            return Arrays.asList(
                    new Gson().fromJson(
                            new FileReader("src/main/java/files/config/Configuration.json"),
                            Configuration[].class
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
