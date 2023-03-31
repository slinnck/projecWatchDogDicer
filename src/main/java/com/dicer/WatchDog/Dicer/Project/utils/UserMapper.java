package com.dicer.WatchDog.Dicer.Project.utils;

import com.dicer.WatchDog.Dicer.Project.dto.UserDTO;
import com.dicer.WatchDog.Dicer.Project.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class UserMapper {

    @Autowired
    ModelMapper modelMapper;

    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO toDTOWithoutId(User user) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.typeMap(User.class, UserDTO.class).addMappings(mapping -> mapping.skip(UserDTO::setId));
        return modelMapper.map(user ,UserDTO.class);
    }

    public List<UserDTO> entityToDTOListWithoutId(List<User> users) {
        return users.stream()
                .map(this::toDTOWithoutId)
                .collect(Collectors.toList());
    }

    public List<UserDTO> entityToDTOList(List<User> users) {
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
