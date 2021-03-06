package com.example.myrecipes.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecipes.R;
import com.example.myrecipes.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {

    private Context context;
    private List<Recipe> recipeList;
    private List<Recipe> recipesFiltered;


    public RecyclerViewAdapter(Context context, List<Recipe> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
        this.recipesFiltered = recipeList;
    }

    //** extract the views from the xml file
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_element, parent, false);
        return new ViewHolder(view);
    }

    //** binding data with views
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = recipesFiltered.get(position);
        holder.recipeName.setText(recipe.getName());
        holder.recipeCalories.setText(recipe.getCalories());
        holder.recipeFats.setText(recipe.getFats());
        Picasso.get().load(recipe.getThumb()).into(holder.recipeThumb);


    }

    //** get the number of the recycler elements
    @Override
    public int getItemCount() {
        return recipesFiltered.size();
    }



    //**extract child views from the recycler view to setup the viewHolder
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
//** open the popup dialog when clicked on the recycler view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createExpandedPopup(getAdapterPosition());
                }
            });
        }

    }

//** apply filter while searching in the Search View bar
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();

                Log.d("FILTER", "SEARCH MSG "+query);

                List<Recipe> filtered = new ArrayList<>();

                if (query.isEmpty()) {
                    filtered=recipeList;
                    Log.d("FILTER", "emptyy "+filtered);

                } else {
                    for (Recipe recipe : recipeList) {
                        if (recipe.getName().toLowerCase().contains(query.toLowerCase())) {
                            filtered.add(recipe);
                            Log.d("FILTER", "RESULT ADDED "+recipe);

                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.count = filtered.size();
                results.values = filtered;
                Log.d("FILTER", "performFiltering: "+filtered);
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {


                //recipesFiltered.clear();
                recipesFiltered=((List) results.values);
                notifyDataSetChanged();
            }
        };
    }


    //** create a pop up dialog to view the Recipe details

    public void createExpandedPopup(int position) {

        final Recipe recipe = this.recipesFiltered.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.popup_dialog_expand,null);
        AlertDialog dialog;
        builder.setView(view);

        dialog = builder.create();

        ImageView expandImage = view.findViewById(R.id.expand_item_image);
        TextView expandName=view.findViewById(R.id.expand_item_name);
        TextView expandHeadline=view.findViewById(R.id.expand_item_headline);
        TextView expandDescription=view.findViewById(R.id.expand_item_description);
        TextView expandCalories =view.findViewById(R.id.expand_item_calories);
        TextView expandFats =view.findViewById(R.id.expand_item_fats);
        TextView expandCarbos= view.findViewById(R.id.expand_item_carbos);
        TextView expandProtein=view.findViewById(R.id.expand_item_protein);

        Button expandBackButton=view.findViewById(R.id.expand_backButton);

        Picasso.get().load(recipe.getImage()).into(expandImage);
        expandName.setText(recipe.getName());
        expandHeadline.setText(recipe.getHeadline());
        expandDescription.setText(recipe.getDescription());
        expandCarbos.setText(recipe.getCarbos());
        expandCalories.setText(recipe.getCalories());
        expandFats.setText(recipe.getFats());
        expandCarbos.setText(recipe.getCarbos());
        expandProtein.setText(recipe.getProteins());

        final AlertDialog finalDialog = dialog;
        expandBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalDialog.dismiss();
            }
        });
        // Create the AlertDialog object and return it

        dialog.show();
    }
}









