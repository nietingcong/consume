package com.wiseweb.ntc.comment.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 验证码异常类
 * @author lenovo
 *
 */
public class ValidateCodeException extends AuthenticationException {

	public ValidateCodeException() {
		super();
	}

	public ValidateCodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateCodeException(String message) {
		super(message);
	}

}
