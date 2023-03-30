package com.dicer.WatchDog.Dicer.Project.service;

import com.dicer.WatchDog.Dicer.Project.dto.UserDTO;
import com.dicer.WatchDog.Dicer.Project.entity.User;
import com.dicer.WatchDog.Dicer.Project.enums.MessagesEnum;
import com.dicer.WatchDog.Dicer.Project.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public User makeEntityUser(UserDTO userDTO) {
        User user = new User();
        user.setNameUser(userDTO.getNameUser());
        user.setTaxpayernumber(userDTO.getTaxpayernumber());
        return user;
    }

    @Override
    public String registerUser(UserDTO userDTO) {
        User user = makeEntityUser(userDTO);
        userDao.save(user);
        return MessagesEnum.MESSAGE_OK.getIdentifier();
    }
}
