package com.pokemon.center.utilities.response;

public interface ResponseObjectInterface {
    void setStatus(Integer status);

    void setCode(String code);

    void setMessage(String message);

    void setData(Object data);
}
