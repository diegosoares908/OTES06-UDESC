package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewMovies = (Button) findViewById(R.id.showMovies);
        Button viewDirectors = (Button) findViewById(R.id.showDirectors);

        viewMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListMoviesActivity.class);
                startActivity(i);
            }
        });

        viewDirectors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListDirectorsActivity.class);
                startActivity(i);
            }
        });

    }
}
