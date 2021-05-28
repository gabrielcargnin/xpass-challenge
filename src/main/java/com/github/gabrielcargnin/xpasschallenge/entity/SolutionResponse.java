package com.github.gabrielcargnin.xpasschallenge.entity;

public class SolutionResponse {

    String status;
    Integer statusCode;
    Object data;
    String message;

    public String getStatus() {
        return status;
    }

    public SolutionResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public SolutionResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Object getData() {
        return data;
    }

    public SolutionResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public SolutionResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
