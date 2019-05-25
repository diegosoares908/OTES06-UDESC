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

                String title = vTitle.getText().toString();
                String duration = vDuration.getText().toString();
                String cost = vCost.getText().toString();
                String year = vYear.getText().toString();
                String currency = vCurrency.getText().toString();

                AddMovie addMovie = new AddMovie();
                addMovie.execute(title, duration, cost, year, currency);

                Toast.makeText(AddMovieActivity.this ,"Salvo!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    class AddMovie extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... ids) {
            MoviesService mvs = new MoviesService();

            String title = ids[0];
            int duration = Integer.parseInt(ids[1]);
            double cost = Double.parseDouble(ids[2]);
            int year = Integer.parseInt(ids[3]);
            String currency = ids[4];

            mvs.addMovie(title, duration, cost, year, currency);
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
        }
    }
}
