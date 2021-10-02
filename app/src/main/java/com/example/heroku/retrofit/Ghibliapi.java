package com.example.heroku.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Ghibliapi {

    @GET("/films/{id}")
    public Call<Films> getFilms(@Path("id") String id);


}
