import models.Configuration;
import repositories.alertConfig.FileConfigurationRepository;
import services.LogMonitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Configuration> configurations = new FileConfigurationRepository().getConfigurations();

        LogMonitor logMonitor;
        for (Configuration config : configurations) {
            logMonitor = new LogMonitor(config);
            logMonitor.action();
        }
    }
}
