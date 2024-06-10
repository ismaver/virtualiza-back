package com.web.servicios;

import com.web.gestion.*;
import com.web.modelo.Calificacion;

import java.util.List;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("calificaciones")
public class ServicioCalificacion{


    @Inject
    private GestionCalificacion gCalificacion;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("agregar")
    public Response agregar(Calificacion calificacion){
    	System.out.println(calificacion);
        try{
            gCalificacion.agregarCalificacion(calificacion);
            ErrorMessage error = new ErrorMessage(1, "OK");
            return Response.status(Response.Status.CREATED)
                .entity(error)
                .build();
        }catch (Exception e) {
            ErrorMessage error = new ErrorMessage(10, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("actualizar")
    public Response actualizar(Calificacion calificacion){
        try{
            gCalificacion.actualizarCalificacion(calificacion);
            return Response.ok(calificacion).build();
        }catch (Exception e) {
            ErrorMessage error = new ErrorMessage(10, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("eliminar")
    public String eliminar(@QueryParam("codigo") int codigo){
        try{
            gCalificacion.eliminarCalificacion(codigo);
            return "OK";
        }catch (Exception e) {
            return "Error";
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar")
    public Response listarCalificaciones(){
    	System.out.println("Listando Calificaciones");
    	List<Calificacion> calificaciones = gCalificacion.listarCalificaciones();
    	if(calificaciones.size() > 0)
            return Response.ok(calificaciones).build();
    	ErrorMessage error = new ErrorMessage(10, "No existen calificaciones");
    	return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(error)
            .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("buscar")
    public Response buscar(@QueryParam("codigo") int codigo){
        try{
            System.out.println("Codigo calificacion: " + codigo);
            Calificacion calificacion = gCalificacion.buscarCalificacion(codigo);//obtenemos la calificacion
            return Response.ok(calificacion).build();//retornamos un OK y con el objeto del carro encontrado
        }catch (Exception e) {
            ErrorMessage error = new ErrorMessage(10, "No existe la calificacion");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
        }
    }
}
