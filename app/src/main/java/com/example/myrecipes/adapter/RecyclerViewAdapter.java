package com.example.myrecipes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecipes.R;
import com.example.myrecipes.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Recipe> recipeList;


    public RecyclerViewAdapter(Context context, List<Recipe> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.recipeName.setText(recipe.getName());
        holder.recipeCalories.setText(recipe.getCalories());
        holder.recipeFats.setText(recipe.getFats());
        Picasso.get().load(recipe.getThumb()).into(holder.recipeThumb);


    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView recipeName;
        public TextView recipeCalories;
        public TextView recipeFats;
        public ImageView recipeThumb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recipeName = itemView.findViewById(R.id.recycler_view_recipeName);
            recipeCalories = itemView.findViewById(R.id.recycler_view_recipeCalories);
            recipeFats = itemView.findViewById(R.id.recycler_view_recipeFats);
            recipeThumb = itemView.findViewById(R.id.recycler_view_recipeThumb);

        }

    }
}







