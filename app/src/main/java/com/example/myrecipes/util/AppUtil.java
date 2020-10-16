package com.example.myrecipes.util;

import com.example.myrecipes.Network.ApiRequest;
import com.example.myrecipes.Network.RetrofitClient;

public final class AppUtil {
    public static final String BASE_URL = "https://hf-android-app.s3-eu-west-1.amazonaws.com/";
    public static final String CURRENT_RECIPE="current_recipe";
    public static final String APP_INFO="app_info";
    public static final String SORT_TYPE="sort_type";
    public static final String FATS="fats";
    public static final String CALORIES="calory";


    public static ApiRequest getAPIRequest() {
        // instantiate RetrofitClient*/
        return RetrofitClient.getClient(BASE_URL).create(ApiRequest.class);
    }
}
