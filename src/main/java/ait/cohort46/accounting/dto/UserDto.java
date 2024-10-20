package ait.cohort46.accounting.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserDto {
    private String login;
    private String firstName;
    private String lastName;
    private List<String> roles;
}
