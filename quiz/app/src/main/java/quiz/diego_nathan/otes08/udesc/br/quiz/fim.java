package quiz.diego_nathan.otes08.udesc.br.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static quiz.diego_nathan.otes08.udesc.br.quiz.R.id.restart;

public class fim extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim);

        final int scoreFinal = getIntent().getIntExtra("scoreFinal",0);

        score = scoreFinal / 5;

        TextView t = (TextView) findViewById(R.id.msg_final2);

        t.setText(score+"");

        Toast.makeText(fim.this, ""+scoreFinal, Toast.LENGTH_SHORT).show();

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
