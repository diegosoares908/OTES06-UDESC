package semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.crud;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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

        Button salvar = (Button) findViewById(R.id.salvarFilme);//filmes


        vTitle = findViewById(R.id.nomeFilme);
        vDuration = findViewById(R.id.duracaoFilme);
        vCost = findViewById(R.id.custoFilme);
        vYear = findViewById(R.id.anoFilme);
        vCurrency = findViewById(R.id.moedaFilme);

        salvar.setOnClickListener(new View.OnClickListener() {
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
            MovieServiceNew mvs = new MovieServiceNew();
            mvs.create(movies[0]);

            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
        }
    }
}
