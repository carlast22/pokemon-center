package com.pokemon.center.utilities.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

@Service
public class ResponseManager {

    @Autowired
    ResponseInformation responseInformation;


    public ResponseEntity<Object> getResponseEntity(KeyResponseInterface responseCode, Object responseData) {
        return getResponseEntity(HttpStatus.OK, responseCode.getValue(), responseData);
    }

    public ResponseEntity<Object> getResponseEntity(String responseCode, Object responseData) {
        return getResponseEntity(HttpStatus.OK, responseCode, responseData);
    }

    public ResponseEntity<Object> getResponseEntity(String responseCode) {
        return getResponseEntity(HttpStatus.OK, responseCode, null);
    }

    public ResponseEntity<Object> getResponseEntity(KeyResponseInterface responseCode) {
        return getResponseEntity(HttpStatus.OK, responseCode.getValue(), null);
    }

    public ResponseEntity<Object> getResponseEntity(HttpStatus httpStatus, String responseCode, Object responseData) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setCode(responseInformation.getResponseCode(responseCode));
        responseObject.setData(responseData);
        responseObject.setMessage(responseInformation.getResponseMessage(responseCode));
        responseObject.setStatus(httpStatus.value());
        return new ResponseEntity<>(responseObject, httpStatus);
    }


    public ResponseEntity<Object> getResponseEntity(ResponseObjectAbstract responseObjectAbstract, HttpStatus httpStatus, String responseCode, Object responseData) {
        responseObjectAbstract.setStatus(httpStatus.value());
        responseObjectAbstract.setMessage(responseInformation.getResponseMessage(responseCode));
        responseObjectAbstract.setData(responseData);
        responseObjectAbstract.setCode(responseInformation.getResponseCode(responseCode));
        return new ResponseEntity<>(responseObjectAbstract, httpStatus);
    }

    public ResponseEntity<Object> getCustomResponseEntity(HttpStatus httpStatus, Object responseData) {
        return new ResponseEntity<>(responseData, httpStatus);
    }

}
