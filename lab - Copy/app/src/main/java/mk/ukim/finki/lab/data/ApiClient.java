package mk.ukim.finki.lab.data;

import mk.ukim.finki.lab.model.Movie;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient{
    private static Api client = null;

    public static Api getApiInstance(){
        if(client==null){
            client = new Retrofit.Builder()
                    .baseUrl("http://www.omdbapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Api.class);
        }

        return client;
    }
}
