package com.pokemon.center.utilities.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Properties;

/**
 * This is an utlitity for managing response information as key-value
 * in the destiny project its necesary to create a file called responseCodes.properties, this for the key values
 * and as a resource, a group of files with name messages.properties, this can be used with internationalization
 */
@Service
public class ResponseInformation {
    @Autowired
    private MessageSource messages;
    private static final String RESPONSE_PROPERTIES = "responseCodes.properties";
    Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(ResponseInformation.class);


    public String getResponseCode(String keyValue) {
        String value = "UNDEFINED";
        try {

            if (properties.isEmpty()) {
                InputStream archivo = ResponseInformation.class.getClassLoader().getResourceAsStream(RESPONSE_PROPERTIES);
                properties.load(archivo);
            }
            value = properties.getProperty(keyValue);
        } catch (Exception e) {
            logger.info(String.format("ERROR RETRIEVING RESPONSE CODE %s ", keyValue));
        }
        return value;
    }

    public String getResponseMessage(String keyValue) {
        String message = keyValue;
        try {
            message = messages.getMessage(keyValue, null, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            logger.info(String.format("ERROR RETRIEVING RESPONSE  MESSAGE: %s", keyValue));
        }
        return message;
    }


}
