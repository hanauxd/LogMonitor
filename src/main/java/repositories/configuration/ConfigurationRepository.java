package repositories.configuration;

import models.Configuration;

import java.util.List;

public interface ConfigurationRepository {
    List<Configuration> getConfigurations();
}
