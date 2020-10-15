package com.example.myrecipes.Network;

import com.example.myrecipes.model.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("android-test/recipes.json") // specify the sub url for the base url
    public Call<List<Recipe>> getRecipeList();// abstract method to be implemented

}
