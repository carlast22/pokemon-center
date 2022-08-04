package com.pokemon.center.utilities.response;

public class ResponseObject extends ResponseObjectAbstract {

    public ResponseObject(Integer status, String code, String message, Object data) {
        super(status, code, message, data);
    }

    public ResponseObject() {
    }


}

