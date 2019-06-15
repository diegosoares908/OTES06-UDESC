package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.entities.Movie;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.R;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.services.MoviesService;

public class MovieInfoActivity extends AppCompatActivity {
    private TextView vTitle;
    private TextView vDuration;
    private TextView vCost;
    private TextView vYear;
    private TextView vCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        final String id = getIntent().getStringExtra("idfilme");

        vTitle = findViewById(R.id.vTitle);
        vDuration = findViewById(R.id.vDuration);
        vCost = findViewById(R.id.vCost);
        vYear = findViewById(R.id.vYear);
        vCurrency = findViewById(R.id.vCurrency);

        new LoadMovieById().execute(id);

        Button movies = findViewById(R.id.button);//filmes

        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(id);
            }
        });
    }

    private void openDialog(final String id) {
        new AlertDialog.Builder(this)
                .setTitle("Tem certeza?")
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new DeleteMovieById().execute(id);
                    }
                }).show();
    }

    class LoadMovieById extends AsyncTask<String, Void, Movie> {

        @Override
        protected Movie doInBackground(String... ids) {
            MoviesService mvs = new MoviesService();
            return mvs.getById(ids[0]);
        }

        @Override
        protected void onPostExecute(Movie movies) {
            vTitle.setText(movies.getTitle());
            vDuration.setText(movies.getDuration() + "");
            vCost.setText(movies.getCost() + "");
            vYear.setText(movies.getYear() + "");
            vCurrency.setText(movies.getCurrency());

        }
    }

    class DeleteMovieById extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... ids) {
            MoviesService mvs = new MoviesService();
            mvs.deleteById(ids[0]);

            return null;
        }

        @Override
        protected void onPostExecute(Void v){
            Intent i = new Intent(MovieInfoActivity.this, ListMoviesActivity.class);
            startActivity(i);
        }
    }
}
