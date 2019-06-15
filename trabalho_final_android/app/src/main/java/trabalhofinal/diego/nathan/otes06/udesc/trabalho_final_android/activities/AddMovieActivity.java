package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.entities.Movie;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.R;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.services.MoviesService;

public class AddMovieActivity extends AppCompatActivity {

    private EditText vTitle;
    private EditText vDuration;
    private EditText vCost;
    private EditText vYear;
    private EditText vCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        Button saveMovie = (Button) findViewById(R.id.saveMovieLayout);//filmes


        vTitle = findViewById(R.id.nameMovieLayout);
        vDuration = findViewById(R.id.durationMovieLayout);
        vCost = findViewById(R.id.costMovieLayout);
        vYear = findViewById(R.id.yearMovieLayout);
        vCurrency = findViewById(R.id.currencyMovieLayout);

        saveMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Movie movie = new Movie();

                Random randomId = new Random();
                String id = Integer.toString(randomId.nextInt(9999999 - 1000000));
                int duration = Integer.parseInt(vDuration.getText().toString());
                double cost = Double.parseDouble(vCost.getText().toString());
                int year = Integer.parseInt(vYear.getText().toString());
                String title = vTitle.getText().toString();
                String currency = vCurrency.getText().toString();

                movie.setId(id);
                movie.setCost(cost);
                movie.setTitle(title);
                movie.setDuration(duration);
                movie.setYear(year);
                movie.setCurrency(currency);

                AddMovie addMovie = new AddMovie();
                addMovie.execute(movie);

                Toast.makeText(AddMovieActivity.this ,"Salvo!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    class AddMovie extends AsyncTask<Movie, Void, Void> {

        @Override
        protected Void doInBackground(Movie... movies) {
            MoviesService mvs = new MoviesService();
            mvs.create(movies[0]);

            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
        }
    }
}
