package com.pokemon.center.utilities.response;

public class ResponseObject extends ResponseObjectAbstract {

    public ResponseObject(Integer status, String code, String message, Object data, String appInfo) {
        super(status, code, message, data,appInfo );
    }

    public ResponseObject() {
    }


}

