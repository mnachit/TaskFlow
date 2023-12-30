package org.example.taskflow.domain.dto.response;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.taskflow.domain.enums.Role;

@Data
@Enabled
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDtoResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Role role;
}
