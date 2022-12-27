package com.garanti.endpoint;


import com.garanti.model.Ogrenci;
import com.garanti.repo.OgrenciRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("ogrenci")
public class OgrenciEndpoints {

    private OgrenciRepo repo;

    public OgrenciEndpoints() {
        this.repo = new OgrenciRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ogrenci> getAll() {
        return repo.getAll();
    }

    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogrenci getByIdQueryParam(@QueryParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogrenci getByIdPathParam(@PathParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ogrenci ogrenci) {
        repo.save(ogrenci);
        return "Başarı ile kaydedildi.";
    }
}
