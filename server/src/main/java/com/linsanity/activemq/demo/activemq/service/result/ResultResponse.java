package com.linsanity.activemq.demo.activemq.service.result;

public class ResultResponse {
    private int state;

    private Object data;

    public ResultResponse(int state, Object data) {
        this.state = state;
        this.data = data;
    }

    public ResultResponse() {
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultResponse{" +
                "state=" + state +
                ", data=" + data +
                '}';
    }
}
