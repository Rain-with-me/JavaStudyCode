package com.lu.edu.utils.exception;

import com.lu.edu.config.security.common.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SecurityException extends DiyException {
    public SecurityException(Status status) {
        super(status);
    }

    public SecurityException(Integer code, String message) {
        super(code, message);
    }
}