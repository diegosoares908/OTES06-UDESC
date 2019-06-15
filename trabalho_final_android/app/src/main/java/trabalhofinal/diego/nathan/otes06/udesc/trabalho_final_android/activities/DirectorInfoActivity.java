package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.activities;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.R;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.entities.Director;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.services.DirectorsService;

public class DirectorInfoActivity extends AppCompatActivity {
    private TextView vName;
    private TextView vBirth;
    private TextView vCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_info);

        final String id = getIntent().getStringExtra("iddirector");

        vName = findViewById(R.id.vName);
        vBirth = findViewById(R.id.vBirth);
        vCountry = findViewById(R.id.vCountry);
        new LoaDirectorById().execute(id);
    }


    class LoaDirectorById extends AsyncTask<String, Void, Director> {

        @Override
        protected Director doInBackground(String... ids) {
            DirectorsService mvs = new DirectorsService();
            return mvs.getById(ids[0]);
        }

        @Override
        protected void onPostExecute(Director directors) {
            vName.setText((directors.getName()));
            vBirth.setText(directors.getBirth() + "");
            vCountry.setText(directors.getCountry() + "");
        }
    }
}
