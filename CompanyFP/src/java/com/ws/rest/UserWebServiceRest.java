package com.ws.rest;

import com.dao.beans.*;
import com.google.gson.Gson;
import com.service.StudentService;
import com.service.UserService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("user")
public class UserWebServiceRest {
    
    public UserWebServiceRest() {
    }

    /* TABLA PRODUCTO */
    
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("email") String email,
                          @QueryParam("password") String password) {
        try {
            User user = new UserService().getUser(email, password);
            if (user != null) {                
                List<User> list = new ArrayList();
                list.add(user);
                return Response.ok(new Gson().toJson(new JSONApp("OK", "", list)), MediaType.APPLICATION_JSON).build();   
            } else {
                return Response.ok(new Gson().toJson(new JSONApp("KO", "No existe el usuario", null)), MediaType.APPLICATION_JSON).build();   
            }         
            
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }

    @GET
    @Path("listUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUsers(@QueryParam("descripcion") String nombre) {
        try {
            List<Student> productos = new StudentService().getAllStudents(nombre);
            String json = new Gson().toJson(productos);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("singin")
    public int registrarUser(String json){
        try {
            Gson gson = new Gson();
            User user = (User) gson.fromJson(json, User.class);
            new UserService().registrarUser(user);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }


}