package ait.cohort46.accounting.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserRolesDto {
    private String login;
    private List<String> roles;
}
