package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private String email;
    private String phone;
    private List<String> notificationTypes;
}
