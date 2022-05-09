/**
 * ResponseDTO.java
 */
package com.bridgelabz.addressbookapp.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * class to response output with
 * message - sucessfull added/updated/deleted/Get
 * data- Data to be added or deleted or updated to be popUp
 */
@Getter
@Setter
public class ResponseDTO {
    private String message;
    private Object data;

    /**
     * Constructor to pass message and data
     * @param message -sucessfull added/updated/deleted/Get
     * @param data -Data to be added or deleted or updated to be popUp
     */
    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
