package com.example.myrecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myrecipes.Network.ApiRequest;
import com.example.myrecipes.adapter.RecyclerViewAdapter;
import com.example.myrecipes.model.Recipe;
import com.example.myrecipes.util.AppUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiRequest apiRequest;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);//apply the application main theme to get rid of the splash screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView= findViewById(R.id.main_activity_recyclerView);



        apiRequest= AppUtil.getAPIRequest();



        // Call the method with parameter in the interface to get the Recipe data*/
        Call<List<Recipe>> call = apiRequest.getRecipeList();

        //Log the URL called*/
        Log.d("URL Called", call.request().url() + "");

       call.enqueue(new Callback<List<Recipe>>() {
           @Override
           public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
              List<Recipe> recipesList = response.body();



               recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, recipesList);
               recyclerView.setHasFixedSize(true);
               linearLayoutManager = new LinearLayoutManager(MainActivity.this);
               recyclerView.setLayoutManager(linearLayoutManager);
               recyclerView.setAdapter(recyclerViewAdapter);


               for (int index =0 ; index< recipesList.size();index++)
                   Log.d("FetchedRecipes", "onResponse: "+ recipesList.get(index));
           }

           @Override
           public void onFailure(Call<List<Recipe>> call, Throwable t) {
               Toast.makeText(MainActivity.this, "Something went wrong...Error message: "
                       + t.getMessage(), Toast.LENGTH_SHORT).show();

           }
       });
    }
}


