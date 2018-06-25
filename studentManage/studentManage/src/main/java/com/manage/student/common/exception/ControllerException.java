package com.manage.student.common.exception;


import com.manage.student.common.response.Response.Status;

public class ControllerException extends RuntimeException {

    private Status status;

    private Object data;

    public ControllerException(Status status, String message) {
        super(message);
        this.status = status;
    }

    public ControllerException(Status status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public ControllerException(Status status, String message, Object data) {
        super(message);
        this.status = status;
        this.data = data;
    }

    public ControllerException(Status status, String message, Object data, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
