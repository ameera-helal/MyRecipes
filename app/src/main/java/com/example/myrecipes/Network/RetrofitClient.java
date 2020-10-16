package com.example.myrecipes.Network;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    //Create only one instance of Retrofit object
    public static Retrofit getClient(String baseUrl, Context context) {
        if (retrofit==null) {


            OkHttpClient.Builder oktHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new NetworkConnectionInterceptor(context));
            // Adding NetworkConnectionInterceptor with okHttpClientBuilder.

            oktHttpClient.addInterceptor(new NetworkConnectionInterceptor(context));
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
