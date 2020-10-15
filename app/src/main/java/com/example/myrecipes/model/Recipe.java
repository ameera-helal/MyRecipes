package com.example.myrecipes.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Recipe {

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

    public String getCalories() {
        return calories;
    }

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