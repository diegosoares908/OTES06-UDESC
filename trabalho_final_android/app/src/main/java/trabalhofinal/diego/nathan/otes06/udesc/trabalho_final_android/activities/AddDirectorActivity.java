package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.R;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.entities.Director;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.services.DirectorsService;

public class AddDirectorActivity extends AppCompatActivity {

    private EditText vName;
    private EditText vBirth;
    private EditText vCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_director);

        Button saveDirector = (Button) findViewById(R.id.saveDirectorLayout);

        vName = findViewById(R.id.nameDirectorLayout);
        vBirth = findViewById(R.id.birthDirectorLayout);
        vCountry = findViewById(R.id.countryDirectorLayout);

        saveDirector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Director director = new Director();

                Random randomId = new Random();
                String id = Integer.toString(randomId.nextInt(9999999 - 1000000));

                String name = vName.getText().toString();
                String birth = vBirth.getText().toString();
                String country = vCountry.getText().toString();

                director.setId(id);
                director.setName(name);
                director.setBirth(birth);
                director.setCountry(country);

                AddDirector addMovie = new AddDirector();
                addMovie.execute(director);

                Toast.makeText(AddDirectorActivity.this ,"Salvo!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    class AddDirector extends AsyncTask<Director, Void, Void> {

        @Override
        protected Void doInBackground(Director... movies) {
            DirectorsService mvs = new DirectorsService();
            mvs.create(movies[0]);

            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
        }
    }
}
