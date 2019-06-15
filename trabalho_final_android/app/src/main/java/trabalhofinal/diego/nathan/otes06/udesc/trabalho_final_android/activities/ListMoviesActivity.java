package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.entities.Movie;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.ui.MovieListAdapter;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.ui.OnMovieClickListener;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.R;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.services.MoviesService;

public class ListMoviesActivity extends AppCompatActivity implements OnMovieClickListener<Movie> {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movies);
        list = findViewById(R.id.list);

        LoadAllMovies loadAllMovies = new LoadAllMovies(this);
        loadAllMovies.execute();

        FloatingActionButton addMovie = findViewById(R.id.addFab);//filmes
        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListMoviesActivity.this, AddMovieActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onMovieClick(Movie movie) {

        Intent i = new Intent(ListMoviesActivity.this, MovieInfoActivity.class);
        i.putExtra("idfilme", movie.getId());
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadAllMovies loadAllMovies = new LoadAllMovies(this);
        loadAllMovies.execute();
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

            RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> adapter = new MovieListAdapter(movies, onMovieClickListener);

            RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
            list.setLayoutManager(manager);
            list.setHasFixedSize(true);
            list.setAdapter(adapter);


        }
    }
}
