package mk.ukim.finki.lab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import mk.ukim.finki.lab.adapter.ActorsViewAdapter;
import mk.ukim.finki.lab.data.FakeApi;
import mk.ukim.finki.lab.model.Actor;
import mk.ukim.finki.lab.model.Movie;

public class MovieDetailsFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView id,name,director,description;


        name = view.findViewById(R.id.name);
        director = view.findViewById(R.id.director);
        description = view.findViewById(R.id.description);
        int position = getArguments().getInt("movie_id");

        ListView actors = view.findViewById(R.id.actors);
        Movie movie = FakeApi.getInstance().getMovies().get(position);
        ActorsViewAdapter<Actor> adapter = new ActorsViewAdapter<Actor>(getContext(),movie.actors);
        actors.setAdapter(adapter);


        name.setText(movie.name);
        director.setText(movie.director);
        description.setText(movie.description);




    }
}