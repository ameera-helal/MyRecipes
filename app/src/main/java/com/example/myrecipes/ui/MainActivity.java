package com.example.myrecipes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.myrecipes.Network.ApiRequest;
import com.example.myrecipes.R;
import com.example.myrecipes.adapter.RecyclerViewAdapter;
import com.example.myrecipes.model.Recipe;
import com.example.myrecipes.util.AppUtil;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private SearchView searchView;
    private CheckBox isSortByFats, isSortByCalory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);//apply the application main theme to get rid of the splash screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView= findViewById(R.id.main_activity_recyclerView);
        searchView= findViewById(R.id.main_activity_searchView);
        isSortByCalory=findViewById(R.id.main_activity_sortByCalories);
        isSortByFats=findViewById(R.id.main_activity_sortByFats);


        ApiRequest apiRequest = AppUtil.getAPIRequest();



        // Call the method with parameter in the interface to get the Recipe data*/
        Call<List<Recipe>> call = apiRequest.getRecipeList();

        //Log the URL called*/
        Log.d("URL Called", call.request().url() + "");

       call.enqueue(new Callback<List<Recipe>>() {
           @Override
           public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
               List<Recipe> recipesList = checkSorting(isSortByFats,isSortByCalory, response.body() );

               recyclerViewConfig(MainActivity.this,recipesList);
               searchBarConfig();
               for (int index =0 ; index< recipesList.size();index++)
                   Log.d("FetchedRecipes", "onResponse: "+ recipesList.get(index).getIntCalories());
           }

           @Override
           public void onFailure(Call<List<Recipe>> call, Throwable t) {
               Toast.makeText(MainActivity.this, "Something went wrong...Check your internet Connectivity "
                       + t.getMessage(), Toast.LENGTH_SHORT).show();

           }
       });
    }


    public void recyclerViewConfig(Context context, List<Recipe> list)
    {
        if (isSortByCalory.isChecked())
            Collections.sort(list,Recipe.ByCalories);
        else if (isSortByFats.isChecked())
            Collections.sort(list,Recipe.ByFats);
        recyclerViewAdapter = new RecyclerViewAdapter(context, list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);


    }

    public void searchBarConfig()
    {
        searchView.setActivated(true);
        searchView.setQueryHint("Search by the Recipe Name");
        searchView.onActionViewExpanded();
        searchView.setIconified(false);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerViewAdapter.getFilter().filter(newText);
                Log.d("SEARCH", "onQueryTextChange: "+newText);
                return false;
            }
        });

    }

    public List<Recipe> checkSorting(final CheckBox isSortByFats, final CheckBox isSortByCalory, final List<Recipe> list)
    {
        SharedPreferences shared = getSharedPreferences(AppUtil.APP_INFO,MODE_PRIVATE);
        String sortType= shared.getString(AppUtil.SORT_TYPE,"").trim();

        if (sortType.contentEquals(AppUtil.FATS))
        {
            isSortByFats.setChecked(true);

        }

        else if (sortType.contentEquals(AppUtil.CALORIES))
        {
            isSortByCalory.setChecked(true);
        }


        isSortByFats.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                if(isSortByFats.isChecked() && isSortByFats.isPressed())
                {
                    Collections.sort(list,Recipe.ByFats);
                    recyclerViewAdapter.notifyDataSetChanged();
                    isSortByCalory.setChecked(false);
                    SharedPreferences sharedPreferences = getSharedPreferences(AppUtil.APP_INFO,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(AppUtil.SORT_TYPE,AppUtil.FATS);
                    editor.apply();
                    Log.d("SORT_TYPE", "onCheckedChanged: "+ "fats");


                }
                else if (!isSortByFats.isChecked() && isSortByFats.isPressed())
                {
                    SharedPreferences sharedPreferences = getSharedPreferences(AppUtil.APP_INFO,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(AppUtil.SORT_TYPE,null);
                    editor.apply();

                }



            }
        });



        isSortByCalory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if(isSortByCalory.isChecked() && isSortByCalory.isPressed())
                {
                    Collections.sort(list,Recipe.ByCalories);
                    recyclerViewAdapter.notifyDataSetChanged();
                    isSortByFats.setChecked(false);
                    SharedPreferences sharedPreferences = getSharedPreferences(AppUtil.APP_INFO,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(AppUtil.SORT_TYPE,AppUtil.CALORIES);
                    editor.apply();
                    Log.d("SORT_TYPE", "onCheckedChanged: "+ "Calory");


                }
                else if (!isSortByCalory.isChecked() && isSortByCalory.isPressed())
                {
                    SharedPreferences sharedPreferences = getSharedPreferences(AppUtil.APP_INFO,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(AppUtil.SORT_TYPE,null);
                    editor.apply();

                }



            }
        });


        Log.d("History", "checkSorting: "+sortType);
        return list;
    }


}


