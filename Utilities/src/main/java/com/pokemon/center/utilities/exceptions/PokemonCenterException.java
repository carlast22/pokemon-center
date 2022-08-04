package com.pokemon.center.utilities.exceptions;

import com.pokemon.center.utilities.response.KeyResponseInterface;

public class PokemonCenterException extends Exception {

    //Variables to adapt the exception into the api envelope
    private String responseCode;
    private String codeValue;
    private String messageValue;
    private Object data = null;

    public PokemonCenterException(KeyResponseInterface responseCode) {
        super(responseCode.getValue());
        this.responseCode = responseCode.getValue();
    }

    public PokemonCenterException(String responseCode) {
        super(responseCode);
        this.responseCode = responseCode;
    }

    public PokemonCenterException(String codeValue, String messageValue) {
        super(messageValue);
        this.codeValue = codeValue;
        this.messageValue = messageValue;
    }

    public PokemonCenterException(KeyResponseInterface responseCode, Object data) {
        super(responseCode.getValue());
        this.responseCode = responseCode.getValue();
        this.data = data;
    }

    public PokemonCenterException(String responseCode, Object data) {
        super(responseCode);
        this.responseCode = responseCode;
        this.data = data;
    }

    public PokemonCenterException(String codeValue, String messageValue, Object data) {
        super(messageValue);
        this.codeValue = codeValue;
        this.messageValue = messageValue;
        this.data = data;
    }

    public PokemonCenterException() {
    }


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
