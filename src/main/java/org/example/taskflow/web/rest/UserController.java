package org.example.taskflow.web.rest;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.taskflow.domain.dto.request.UserDtoRequest;
import org.example.taskflow.domain.dto.response.UserDtoResponse;
import org.example.taskflow.handler.exception.ValidationException;
import org.example.taskflow.domain.mapper.UserMapper;
import org.example.taskflow.service.UserService;
import org.example.taskflow.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response<UserDtoResponse>> createUser(@Valid @RequestBody UserDtoRequest userDtoRequest)
    {
        Response<UserDtoResponse> userDtoResponseResponse = new Response<>();
        try {
            userDtoResponseResponse.setMessage("User has been added");
            userDtoResponseResponse.setResult(UserMapper.UserToResponse(userService.CreateUser(UserMapper.RequestToUser(userDtoRequest))));
            return ResponseEntity.ok(userDtoResponseResponse);
        }catch (ValidationException e)
        {
            userDtoResponseResponse.setMessage("User has not been added");
            userDtoResponseResponse.setErrors(new ArrayList<>(e.getErrorMessages()));
            return ResponseEntity.ok(userDtoResponseResponse);
        }
    }

}
