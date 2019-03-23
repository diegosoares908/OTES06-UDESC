package quiz.diego_nathan.otes08.udesc.br.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static quiz.diego_nathan.otes08.udesc.br.quiz.R.id.restart;

public class fim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim);

        Button b = (Button) findViewById(restart);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(fim.this, Inicio.class);
                startActivity(i);
            }
        });
    }
}
