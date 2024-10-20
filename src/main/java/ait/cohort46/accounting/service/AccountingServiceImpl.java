package ait.cohort46.accounting.service;

import ait.cohort46.accounting.dao.AccountingRepository;
import ait.cohort46.accounting.dto.RegisterDto;
import ait.cohort46.accounting.dto.UpdateDto;
import ait.cohort46.accounting.dto.UserDto;
import ait.cohort46.accounting.dto.UserRolesDto;
import ait.cohort46.accounting.dto.exceptions.UserAlreadyExistsException;
import ait.cohort46.accounting.dto.exceptions.UserNotFoundException;
import ait.cohort46.accounting.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountingServiceImpl implements AccountingService {
    private final AccountingRepository accountingRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createAccount(RegisterDto registerDto) {
        if (accountingRepository.findById(registerDto.getLogin()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        User user = modelMapper.map(registerDto, User.class);
        user.addRole("USER");
        accountingRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto deleteAccount(String userName) {
        User user = accountingRepository.findById(userName).orElseThrow(UserNotFoundException::new);
        accountingRepository.delete(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateAccount(String userName, UpdateDto updateDto) {
        User user = accountingRepository.findById(userName).orElseThrow(UserNotFoundException::new);
        if (updateDto.getFirstName() != null) {
            user.setFirstName(updateDto.getFirstName());
        }
        if (updateDto.getLastName() != null) {
            user.setLastName(updateDto.getLastName());
        }
        accountingRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserRolesDto addUserRole(String userName, String role) {
        User user = accountingRepository.findById(userName).orElseThrow(UserNotFoundException::new);
        user.addRole(role);
        accountingRepository.save(user);
        return modelMapper.map(user, UserRolesDto.class);
    }

    @Override
    public UserRolesDto removeUserRole(String userName, String role) {
        User user = accountingRepository.findById(userName).orElseThrow(UserNotFoundException::new);
        user.removeRole(role);
        accountingRepository.save(user);
        return modelMapper.map(user, UserRolesDto.class);
    }

    @Override
    public UserDto getUser(String userName) {
        User user = accountingRepository.findById(userName).orElseThrow(UserNotFoundException::new);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto loginIntoAccount() {
        return null;
    }

    @Override
    public void changePassword(String exPassword) {

    }
}
