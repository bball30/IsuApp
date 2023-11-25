package com.example.demo1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMM");
        return "Hello, World!";
    }
}