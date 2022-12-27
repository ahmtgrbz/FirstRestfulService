package com.garanti.endpoint;

import com.garanti.model.Konu;
import com.garanti.repo.KonuRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import oracle.jdbc.proxy.annotation.Post;
import java.util.ArrayList;

@Path("konu")
public class KonuEndpoints {

    private KonuRepo repo;

    public KonuEndpoints() {
        this.repo = new KonuRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Konu> getAll() {
        return repo.getAll();
    }


    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Konu getByIdQueryParam(@QueryParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Konu getByIdPathParam(@PathParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Konu konu) {
        repo.save(konu);
        return "Başarı ile kaydedildi.";
    }


}
