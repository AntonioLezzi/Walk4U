package com.example.walk4you.ModelInterfaccia;

import com.example.walk4you.Model.Utente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IntUtente {

    @GET("/utente/{nome}")
    Call<Utente> getUser(@Path("nome") String nome);
    @GET("/group/{id}/users")
    Call<List<Utente>> groupList(@Path("id") int groupId, @Query("sort") String sort);
    @POST("/users/new")
    Call<Utente> createUser(@Body Utente user);
}
