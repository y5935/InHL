package com.manage.student.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    public enum Status {
        OK,
        ERR_UNKNOWN,
        ERR_ILLEGAL_ARGUMENT,
        ERR_CHECK,
        ERR_REMOTE_CALL,
        ERR_INVALID,
        ERR_NO_LOGIN
    }

    private Status status;
    private String message;
    private Object data;

    public Response(Status status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

}
