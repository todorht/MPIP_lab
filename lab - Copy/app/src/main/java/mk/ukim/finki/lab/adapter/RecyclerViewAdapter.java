package mk.ukim.finki.lab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mk.ukim.finki.lab.R;
import mk.ukim.finki.lab.model.Actor;
import mk.ukim.finki.lab.model.Movie;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private MoviesClickListener moviesClickListener;
    private List<Movie> movies;

    public RecyclerViewAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //generirame View od shablonot movies.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Go povrzivame kreiraniot virwHolderot
        holder.bindHolder(movies.get(position), moviesClickListener);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{ //ViewHolder - eden zapis
        private TextView id;
        private TextView name;
        private TextView director;
        private View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            director = itemView.findViewById(R.id.director);
        }

        public void bindHolder(final Movie movie, final MoviesClickListener moviesClickListener){
            id.setText(String.valueOf(movie.id));
            name.setText(movie.name);
            director.setText(movie.director);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    moviesClickListener.onMoviesClicked(getAdapterPosition());
                }
            });
        }
    }

    public interface MoviesClickListener{
        void onMoviesClicked(int position);
    }
    public void setMoviesClickListener(MoviesClickListener moviesClickListener){
        this.moviesClickListener = moviesClickListener;
    }


    public void update(List<Movie> movies) {
        this.movies = movies;
    }
}
