package ait.cohort46.accounting.service;

import ait.cohort46.accounting.dto.RegisterDto;
import ait.cohort46.accounting.dto.UpdateDto;
import ait.cohort46.accounting.dto.UserDto;
import ait.cohort46.accounting.dto.UserRolesDto;

public interface AccountingService {
    UserDto createAccount(RegisterDto registerDto);

    UserDto deleteAccount(String userName);

    UserDto updateAccount(String userName, UpdateDto updateDto);

    UserRolesDto addUserRole(String userName, String role);

    UserRolesDto removeUserRole(String userName, String role);

    UserDto getUser(String userName);

    //TODO
    UserDto loginIntoAccount();

    void changePassword(String exPassword);
}
