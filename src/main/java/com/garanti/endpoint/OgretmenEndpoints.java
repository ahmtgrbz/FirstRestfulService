package com.garanti.endpoint;

import com.garanti.model.Ogretmen;
import com.garanti.repo.OgretmenRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path("ogretmen")
public class OgretmenEndpoints {

    private OgretmenRepo repo;

    public OgretmenEndpoints() {
        this.repo = new OgretmenRepo();
    }

    // localhost:8080/FirstRestfulService/ogretmen/getAll
    // localhost:8080/FirstRestfulService/ogretmen/getById
    // localhost:8080/FirstRestfulService/ogretmen/save
    // localhost:8080/FirstRestfulService/ogretmen/deleteById

    //Arraylisti json array olarak geri veriyor. GetAll için yazdığımız metod.
    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ogretmen> getAll(){
        return repo.getAll();
    }


    //queryParam anotasyonu ile yaptım.
    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdQueryParam(@QueryParam(value = "id") Integer id){
        return repo.getById(id);
    }

    //PathParam anotasyonu ile yaptık.
    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdPathParam(@PathParam(value = "id") Integer id){
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ogretmen ogretmen){
        repo.save(ogretmen);
        return "Başarı ile kaydedildi.";
    }

}
