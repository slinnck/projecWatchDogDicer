package com.dicer.WatchDog.Dicer.Project.service;

import com.dicer.WatchDog.Dicer.Project.dto.UserDTO;
import com.dicer.WatchDog.Dicer.Project.entity.User;
import com.dicer.WatchDog.Dicer.Project.enums.MessagesEnum;
import com.dicer.WatchDog.Dicer.Project.repository.UserRepository;
import com.dicer.WatchDog.Dicer.Project.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper mapper;

    public User makeEntityUser(UserDTO userDTO) {
        User user = new User();
        user.setNameUser(userDTO.getNameUser());
        user.setTaxpayernumber(userDTO.getTaxpayernumber());
        return user;
    }

    @Override
    public String registerUser(UserDTO userDTO) {
        User user = makeEntityUser(userDTO);
        userRepository.save(user);
        return MessagesEnum.MESSAGE_OK.getIdentifier();
    }

    @Override
    public UserDTO getUserByTaxpayernumber(HttpHeaders headers) {
        UserDTO userDTO = new UserDTO();
        String taxpayernumber = headers.containsKey("taxpayernumber") ? headers.get("taxpayernumber").get(0) : null;
        userDTO.setTaxpayernumber(taxpayernumber);
        return mapper.toDTOWithoutId(userRepository.findByTaxpayernumber(userDTO.getTaxpayernumber()));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = mapper.entityToDTOListWithoutId(userRepository.findAll());
        return userDTOList;
    }

    @Override
    public String updateUser(HttpHeaders headers) {
        UserDTO user = getUserByTaxpayernumber(headers);
    }

}
