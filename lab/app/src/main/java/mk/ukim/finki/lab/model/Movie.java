package mk.ukim.finki.lab.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("Rated")
    private String rated;
    @SerializedName("Released")
    private String released;
    @SerializedName("Runtime")
    private String runtime;
    @SerializedName("Genre")
    private String genre;
    @SerializedName("Director")
    private String director;
    @SerializedName("Writer")
    private String writer;
    @SerializedName("Actors")
    private String actors;
    @SerializedName("Plot")
    private String plot;
    @SerializedName("Language")
    private String language;
    @SerializedName("Country")
    private String country;
    @SerializedName("Awards")
    private String awards;
    @SerializedName("Poster")
    private String poster;
    @SerializedName("Ratings")
    private List<Rating> ratings;
    @SerializedName("Metascore")
    private String metascore;
    private String imdbRating;
    private String imdbVotes;
    @SerializedName("imdbID")
    private String imdbId;
    @SerializedName("Type")
    private String type;
    @SerializedName("DVD")
    private String dvd;
    @SerializedName("BoxOffice")
    private String boxOffice;
    @SerializedName("Production")
    private String production;
    @SerializedName("Website")
    private String website;
    @SerializedName("Response")
    private String response;

    public Movie(String name, String director ,String description) {
        this.id = (long) (Math.random() *1000);
        this.name = name;
        this.director = director;
        this.description = description;
        this.actors = new ArrayList<>();
    }
    public Movie(String name, String director ,String description, List<Actor> actors) {
        this.id = (long) (Math.random() *1000);
        this.name = name;
        this.director = director;
        this.description = description;
        this.actors = actors;
    }
}
