package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Configuration {
    private String log_file;
    private String application_name;
    private List<User> users;
}
