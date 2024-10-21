package ait.cohort46.accounting.controller;

import ait.cohort46.accounting.dto.RegisterDto;
import ait.cohort46.accounting.dto.UpdateDto;
import ait.cohort46.accounting.dto.UserDto;
import ait.cohort46.accounting.dto.UserRolesDto;
import ait.cohort46.accounting.service.AccountingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/account")
@RestController
@Controller
@RequiredArgsConstructor
public class AccountingController {
    private final AccountingService accountingService;

    @PostMapping("/register")
    public UserDto createAccount(@RequestBody RegisterDto registerDto) {
        return accountingService.createAccount(registerDto);
    }

    @DeleteMapping("/user/{userName}")
    public UserDto deleteAccount(@PathVariable String userName) {
        return accountingService.deleteAccount(userName);
    }

    @PatchMapping("/user/{userName}")
    public UserDto updateAccount(@PathVariable String userName, @RequestBody UpdateDto updateDto) {
        return accountingService.updateAccount(userName, updateDto);
    }

    @PatchMapping("/user/{userName}/role/{role}")
    public UserRolesDto addUserRole(@PathVariable String userName, @PathVariable String role) {
        return accountingService.addUserRole(userName, role);
    }

    @DeleteMapping("/user/{userName}/role/{role}")
    public UserRolesDto removeUserRole(@PathVariable String userName, @PathVariable String role) {
        return accountingService.removeUserRole(userName, role);
    }

    @GetMapping("/user/{userName}")
    public UserDto getUser(@PathVariable String userName) {
        return accountingService.getUser(userName);
    }

    @PostMapping("/login")
    public UserDto loginIntoAccount(Principal principal) {
        return accountingService.getUser(principal.getName());
    }

    @PatchMapping("/user/password")
    public void changePassword(Principal principal, @RequestHeader("X-Password") String newPassword) {
        accountingService.changePassword(principal.getName(), newPassword);
    }
}
