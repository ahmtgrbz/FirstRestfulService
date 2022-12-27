package com.garanti.endpoint;

import com.garanti.model.Ders;
import com.garanti.repo.DersRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import oracle.jdbc.proxy.annotation.Post;

import java.util.ArrayList;

@Path("ders")
public class DersEndpoints {

    private DersRepo repo;

    public DersEndpoints() {
        this.repo = new DersRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders> getAll() {
        return repo.getAll();
    }

    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getByIdQueryParam(@QueryParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getByIdPathParam(@PathParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders ders) {
        repo.save(ders);
        return "Başarı ile kaydedildi.";
    }

}
