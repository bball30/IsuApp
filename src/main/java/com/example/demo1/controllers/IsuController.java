package com.example.demo1.controllers;

import com.example.demo1.services.IsuGroupService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/isu")
@Stateless
public class IsuController {

    @EJB
    private IsuGroupService isuGroupService;

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        return Response.ok().entity("pong").build();
    }

    @GET
    @Path("/group/{group-id}/expel-all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response expelStudents(@PathParam("group-id") @Valid @Positive(message = "id должен быть положительным числом.") long groupId) {
        return Response.ok().entity(isuGroupService.expelAllStudents(groupId)).build();
    }

    @GET
    @Path(value = "/statistics/count-expelled")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countExpelledStudents() {
        System.out.println("OOOOOOOOOO");
        return Response.ok().entity(isuGroupService.countExpelledStudents()).build();
    }

    @OPTIONS
    @Path("{path : .*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response options() {
        return Response.status(202)
                .build();
    }
}
