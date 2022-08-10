package com.pokemon.center.utilities.response;

public class ResponseObjectAbstract {
    private Integer status;
    private String code;
    private String message;
    private Object data = null;
    private String appInfo;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseObjectAbstract{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public ResponseObjectAbstract(Integer status, String code, String message, Object data, String appInfo) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
        this.appInfo = appInfo;
    }

    public ResponseObjectAbstract() {
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }
}
