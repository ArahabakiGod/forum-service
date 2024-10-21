package ait.cohort46.accounting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Document(collection = "users")
public class User {
    @Id
    private String login;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    private List<Role> roles;
    @Setter
    private String password;

    public User() {
        roles = new ArrayList<>();
        roles.add(Role.USER);
    }

    public User(String login, String password, String firstName, String lastName) {
        this();
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addRole(String role) {
        roles.add(Role.valueOf(role.toUpperCase()));
    }

    public void removeRole(String role) {
        roles.remove(Role.valueOf(role.toUpperCase()));
    }
}
