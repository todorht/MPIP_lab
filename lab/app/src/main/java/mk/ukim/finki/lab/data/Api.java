package mk.ukim.finki.lab.data;

import mk.ukim.finki.lab.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("?t={title}&apikey=56bc7216")
    Call<Movie> getAllMovies(@Path("title") String title);
}
