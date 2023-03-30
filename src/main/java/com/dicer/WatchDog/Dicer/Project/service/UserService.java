package com.dicer.WatchDog.Dicer.Project.service;

import com.dicer.WatchDog.Dicer.Project.dto.UserDTO;
import com.dicer.WatchDog.Dicer.Project.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    String registerUser(UserDTO userDTO);

    User makeEntityUser(UserDTO userDTO);
}
