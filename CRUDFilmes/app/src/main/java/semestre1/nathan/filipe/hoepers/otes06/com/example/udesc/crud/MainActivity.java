package semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.crud;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.crud.Filmes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button filmes = (Button) findViewById(R.id.button3);//filmes

        filmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Filmes.class);
                startActivity(i);
            }
        });
    }


    static class LoadAllMovies extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            GetService mvs = new GetService("directors");
            //List<Movie> movies = mvs.getAll();
            List<Director> directors = mvs.getDirector();
            return null;
        }

        @Override
        protected void onPostExecute(Void nada) {

        }
    }
}
