package com.example.demo1.exceptionsMappers;

import com.example.demo1.dto.ErrorData;
import com.example.demo1.exceptions.ServerNotAvailable;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServerNotAvailableExceptionMapper implements ExceptionMapper<ServerNotAvailable> {

    public Response toResponse(ServerNotAvailable ex) {
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(new ErrorData("Service unavailable")).build();
    }
}
