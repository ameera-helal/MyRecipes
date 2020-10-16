package com.example.myrecipes.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Comparator;


public class Recipe {
//** Retrofit annotations to achieve successful serialization
    @SerializedName("calories")
    @Expose
    private String calories;
    @SerializedName("carbos")
    @Expose
    private String carbos;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("difficulty")
    @Expose
    private int difficulty;
    @SerializedName("fats")
    @Expose
    private String fats;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("proteins")
    @Expose
    private String proteins;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("time")
    @Expose
    private String time;

//**constructors
    public Recipe(String calories, String carbos, String description, int difficulty, String fats, String headline, String id, String image, String name, String proteins, String thumb, String time) {
        this.calories = calories;
        this.carbos = carbos;
        this.description = description;
        this.difficulty = difficulty;
        this.fats = fats;
        this.headline = headline;
        this.id = id;
        this.image = image;
        this.name = name;
        this.proteins = proteins;
        this.thumb = thumb;
        this.time = time;
    }

    public Recipe() {
    }

    //** getters and setters//
    public String getCalories() {
        return calories;
    }

    //** to be used in sorting
    public int getIntCalories(){
        if(!calories.isEmpty())
           return Integer.parseInt(calories.replace("kcal"," ").trim());
        else return 0;}

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCarbos() {
        return carbos;
    }

    public void setCarbos(String carbos) {
        this.carbos = carbos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getFats() {
        return fats;
    }

    //to be used in sorting
    public int getIntFats(){
        if(!fats.isEmpty())
            return Integer.parseInt(fats.replace("g"," ").trim());
        else return 0;

    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProteins() {
        return proteins;
    }

    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
//** sorting comparator methods
    public static Comparator<Recipe> ByCalories = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe o1, Recipe o2) {
            return  Integer.valueOf(o1.getIntCalories()).compareTo(Integer.valueOf(o2.getIntCalories()));
        }
    };

    public static Comparator<Recipe> ByFats = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe o1, Recipe o2) {
            return  Integer.valueOf(o1.getIntFats()).compareTo(Integer.valueOf(o2.getIntFats()));
        }
    };

    @Override
    public String toString() {
        return "Recipe{" +
                "calories='" + calories + '\'' +
                ", carbos='" + carbos + '\'' +
                ", description='" + description + '\'' +
                ", difficulty=" + difficulty +
                ", fats='" + fats + '\'' +
                ", headline='" + headline + '\'' +
                ", id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", proteins='" + proteins + '\'' +
                ", thumb='" + thumb + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}