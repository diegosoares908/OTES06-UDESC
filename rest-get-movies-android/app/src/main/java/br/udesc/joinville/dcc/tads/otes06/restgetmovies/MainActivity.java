package br.udesc.joinville.dcc.tads.otes06.restgetmovies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMovieClickListener<Movie> {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadAllMovies loadAllMovies = new LoadAllMovies(this);
        loadAllMovies.execute();
    }

    @Override
    public void onMovieClick(Movie movie) {
        Toast.makeText(this,movie.getTitle(),Toast.LENGTH_SHORT).show();
    }


    class LoadAllMovies extends AsyncTask<Void, Void, List<Movie>>{


        OnMovieClickListener onMovieClickListener;

        LoadAllMovies(OnMovieClickListener onMovieClickListener){
            super();
            this.onMovieClickListener = onMovieClickListener;
        }

        @Override
        protected List<Movie> doInBackground(Void... voids) {
            MoviesService mvs = new MoviesService();
            List<Movie> movies = mvs.getAll();
            return movies;
        }

        @Override
        protected void onPostExecute(List<Movie> movies){
            list = findViewById(R.id.list);

            RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> adapter = new MovieListAdapter(movies, onMovieClickListener);

            RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
            list.setLayoutManager(manager);
            list.setHasFixedSize(true);
            list.setAdapter(adapter);


        }
    }
}
