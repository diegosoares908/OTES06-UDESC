package semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new LoadAllMovies().execute();
    }


    static class LoadAllMovies extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            MoviesService mvs = new MoviesService();
            List<Movie> movies = mvs.getAll();
            return null;
        }

        @Override
        protected void onPostExecute(Void nada) {

        }
    }
}