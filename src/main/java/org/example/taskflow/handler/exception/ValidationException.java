package org.example.taskflow.handler.exception;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.taskflow.utils.ErrorMessage;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ValidationException extends RuntimeException {
    private List<ErrorMessage> errorMessages;

    public ValidationException(List<ErrorMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }
}
