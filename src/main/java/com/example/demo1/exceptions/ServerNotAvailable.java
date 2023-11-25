package com.example.demo1.exceptions;


import com.example.demo1.dto.ErrorDTO;

public class ServerNotAvailable extends RuntimeException {
    ErrorDTO errorDTO;
    public ServerNotAvailable() {
        super("asd");
    }
    public ServerNotAvailable(ErrorDTO errorDTO) {
        this.errorDTO=errorDTO;
    }

}
