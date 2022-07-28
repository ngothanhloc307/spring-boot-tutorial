package com.dailycodebuffer.Springboot.tutorial.error;

public class DepartmentNotFoundExceptiom extends Exception{
    public DepartmentNotFoundExceptiom() {
        super();
    }

    public DepartmentNotFoundExceptiom(String message) {
        super(message);
    }

    public DepartmentNotFoundExceptiom(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundExceptiom(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundExceptiom(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
