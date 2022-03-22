package com.example.demospringrest.controllers;

import com.example.demospringrest.models.Bootcamper;
import com.example.demospringrest.services.BootcamperService;
import org.apache.coyote.Response;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class BootcamperControllers {
    private final BootcamperService bootcamperService;

    public BootcamperControllers (BootcamperService bootcamperService) {
        this.bootcamperService = bootcamperService;


        this.bootcamperService.add(new Bootcamper("Juan", Math.random()*100));
        this.bootcamperService.add(new Bootcamper("Pedro", Math.random()*100));
        this.bootcamperService.add(new Bootcamper("Carlos", Math.random()*100));
        this.bootcamperService.add(new Bootcamper("David", Math.random()*100));
        this.bootcamperService.add(new Bootcamper("Jorge", Math.random()*100));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> listarTodos() {
        return bootcamperService.getAll();
    }

    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public Bootcamper listarUno(@PathParam("nombre") String nombre) {
        return bootcamperService.get(nombre);
    }

   /* @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response meterBootcamper(Bootcamper bootcamper) {
        bootcamperService.add(bootcamper);
        return Response.created(URI.create("/bootcampers/" + bootcamper.getNombre())).build();
    }
    */
}
