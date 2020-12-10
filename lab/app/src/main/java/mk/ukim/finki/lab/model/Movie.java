package mk.ukim.finki.lab.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    public Long id;
    public String name;
    public String description;
    public String director;
    public List<Actor> actors;

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
