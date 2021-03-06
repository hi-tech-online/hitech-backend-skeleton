package com.hitech.skeleton.framework.exception.cases;

import com.hitech.skeleton.framework.exception.BaseException;

/**
 * @author Steven
 * @date 2019-04-26
 */
public class AlreadyExistException extends BaseException {
    public AlreadyExistException(String message, int code) {
        super(message, code);
    }
}
