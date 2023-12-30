package org.example.taskflow.domain.mapper;

import org.example.taskflow.domain.entities.User;
import org.example.taskflow.domain.dto.request.UserDtoRequest;
import org.example.taskflow.domain.dto.response.UserDtoResponse;

public class UserMapper {
    public static User RequestToUser(UserDtoRequest userDtoRequest)
    {
        return User.builder()
                .firstName(userDtoRequest.getFirstName())
                .lastName(userDtoRequest.getLastName())
                .username(userDtoRequest.getUsername())
                .email(userDtoRequest.getEmail())
                .password(userDtoRequest.getPassword()).build();
    }
    public static UserDtoResponse UserToResponse(User user)
    {
        return UserDtoResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
