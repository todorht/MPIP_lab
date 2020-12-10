package mk.ukim.finki.lab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.lab.adapter.ActorsCheckAdapter;
import mk.ukim.finki.lab.adapter.ActorsViewAdapter;
import mk.ukim.finki.lab.adapter.RecyclerViewAdapter;
import mk.ukim.finki.lab.data.FakeApi;
import mk.ukim.finki.lab.model.Actor;
import mk.ukim.finki.lab.model.Movie;

public class MovieListFragment extends Fragment{

    public MovieListFragment(){}

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerView);

        rView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(FakeApi.getInstance().getMovies());

        adapter.notifyDataSetChanged();

        rView.setAdapter(adapter);

        adapter.setMoviesClickListener(new RecyclerViewAdapter.MoviesClickListener() {
            @Override
            public void onMoviesClicked(int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("movie_id",position);
                NavHostFragment.findNavController(MovieListFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);
            }
        });

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(adapter);
            }
        });

    }

    public void showDialog(RecyclerViewAdapter Radapter){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add new movie");

        View view = LayoutInflater.from(getContext()).inflate(R.layout.add_movie,null);

        builder.setView(view);

        final EditText name, director, description;
        name = view.findViewById(R.id.name);
        director = view.findViewById(R.id.director);
        description = view.findViewById(R.id.description);
        ListView listView = view.findViewById(R.id.actorsList);
        ActorsCheckAdapter<Actor> adapter = new ActorsCheckAdapter<>(getContext(),FakeApi.getInstance().actors);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(name.getText().toString().isEmpty() ||
                        director.getText().toString().isEmpty() ||
                             description.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(),"Please fill the fields", Toast.LENGTH_LONG).show();
                }
                SparseBooleanArray checked = listView.getCheckedItemPositions();
                List<Actor> actorList = new ArrayList<>();
                for(int i =0;i<listView.getAdapter().getCount();i++){
                    if(checked.get(i)){
                        actorList.add((Actor) listView.getAdapter().getItem(i));
                    }
                }
                Movie movie = new Movie(
                        name.getText().toString(),
                        director.getText().toString(),
                        description.getText().toString(),
                        actorList
                );

                FakeApi.getInstance().addNewMovie(movie);
                Radapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

}