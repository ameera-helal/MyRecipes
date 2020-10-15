package com.example.myrecipes.util;

import com.example.myrecipes.Network.ApiRequest;
import com.example.myrecipes.Network.RetrofitClient;

public final class AppUtil {
    public static final String BASE_URL = "https://hf-android-app.s3-eu-west-1.amazonaws.com/";


    public static ApiRequest getAPIRequest() {
        // instantiate RetrofitClient*/
        return RetrofitClient.getClient(BASE_URL).create(ApiRequest.class);
    }
}
