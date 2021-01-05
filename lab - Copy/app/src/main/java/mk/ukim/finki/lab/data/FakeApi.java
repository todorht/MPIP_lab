package mk.ukim.finki.lab.data;

import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.lab.model.Actor;
import mk.ukim.finki.lab.model.Movie;

public class FakeApi {

    private static FakeApi fakeApi;

    private List<Movie> movies = new ArrayList<>();
    public List<Actor> actors = new ArrayList<>();

    private FakeApi(){}

    public static FakeApi getInstance(){
        if(fakeApi==null){
            fakeApi = new FakeApi();
            fakeApi.actors.add(new Actor("Cacko", "Konjopishki"));

            fakeApi.actors.add(new Actor("Marlon","Brando"));
            fakeApi.actors.add(new Actor("Al", "Pacino"));

            fakeApi.actors.add(new Actor("Christian","Bale"));
            fakeApi.actors.add(new Actor("Heath","Ledger"));

            fakeApi.actors.add(new Actor("Brad","Pitt"));
            fakeApi.actors.add(new Actor("Edward","Norton"));

            fakeApi.actors.add(new Actor("Tom","Hanks"));
            fakeApi.actors.add(new Actor("Robin","Wright"));
            fakeApi.movies.add(new Movie("Na brat mu mu ja krshat kichmata","Cacko",
                    "Toj koga ide i na site im ja krshi kichmata",fakeApi.actors.subList(0,1)));
            fakeApi.movies.add(new Movie("The Godfather","Francis Ford Coppola",
                    "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",fakeApi.actors.subList(1,3)));
            fakeApi.movies.add(new Movie("The Dark Knight","Christopher Nolan",
                    "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",fakeApi.actors.subList(3,5)));
            fakeApi.movies.add(new Movie("Fight Club","David Fincher",
                    "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.",fakeApi.actors.subList(5,7)));
            fakeApi.movies.add(new Movie("Forrest Gump","Robert Zemeckis",
                    "The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate and other historical events unfold through the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.", fakeApi.actors.subList(7,fakeApi.actors.size())));


        }
        return fakeApi;
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public void addNewMovie(Movie movie){
        this.movies.add(movie);
    }

    public void deleteMovie(Movie movie){
        this.movies.remove(movie);
    }
}
