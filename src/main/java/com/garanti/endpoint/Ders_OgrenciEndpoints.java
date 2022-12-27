package com.garanti.endpoint;

import com.garanti.model.Ders_Ogrenci;
import com.garanti.repo.Ders_OgrenciRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import oracle.jdbc.proxy.annotation.Post;
import java.util.ArrayList;

@Path("dersogrenci")
public class Ders_OgrenciEndpoints {

    private Ders_OgrenciRepo repo;

    public Ders_OgrenciEndpoints() {
        this.repo = new Ders_OgrenciRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders_Ogrenci> getAll() {
        return repo.getAll();
    }

    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders_Ogrenci getByIdQueryParam(@QueryParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders_Ogrenci getByIdPathParam(@PathParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders_Ogrenci dersOgrenci) {
        repo.save(dersOgrenci);
        return "Başarı ile kaydedildi.";
    }
}
