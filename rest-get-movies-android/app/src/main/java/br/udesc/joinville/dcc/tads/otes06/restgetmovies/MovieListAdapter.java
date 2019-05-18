package br.udesc.joinville.dcc.tads.otes06.restgetmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

    List<Movie> movies;
    OnMovieClickListener onMovieClickListener;

    MovieListAdapter(List<Movie> movies, OnMovieClickListener onMovieClickListener) {
        this.movies = movies;
        this.onMovieClickListener = onMovieClickListener;
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View movieItem = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.movie_item_list, viewGroup, false);
        return new MovieListViewHolder(movieItem);
    }

    @Override
    public void onBindViewHolder( MovieListViewHolder movieListViewHolder, int i) {
        final Movie m = this.movies.get(i);
        movieListViewHolder.year.setText(Integer.toString(m.getYear()));
        movieListViewHolder.title.setText(m.getTitle());
        movieListViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMovieClickListener.onMovieClick(m);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView year;

        public MovieListViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.xtitle);
            this.year = itemView.findViewById(R.id.xyear);
        }
    }
}
