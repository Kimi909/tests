package com.kbp.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Administrator on 2018/9/28.
 */
public class ValidationException extends AuthenticationException{

    private static final long serialVersionUID = 1869230917082874809L;

    public ValidationException(String msg) {
        super(msg);
    }
}
