package com.example.springsimulator.dto.response;

public class Response<T> {

    private Boolean isOk;
    private String error;
    private T answer;


    public Response() {
        isOk = false;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Boolean getOk() {
        return isOk;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public T getAnswer() {
        return answer;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
    }

}
