package com.dicer.WatchDog.Dicer.Project.service;

import com.dicer.WatchDog.Dicer.Project.dto.UserDTO;
import com.dicer.WatchDog.Dicer.Project.entity.User;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface UserService {

    String registerUser(UserDTO userDTO);

    User makeEntityUser(UserDTO userDTO);

    UserDTO getUserByTaxpayernumber(HttpHeaders headers);

    List<UserDTO> getAllUsers();

    String updateUser(HttpHeaders headers);
}
