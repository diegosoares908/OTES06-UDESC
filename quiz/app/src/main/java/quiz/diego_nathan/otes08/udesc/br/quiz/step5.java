package quiz.diego_nathan.otes08.udesc.br.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class step5 extends AppCompatActivity {

    Button b;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step5);

        final int score4 = getIntent().getIntExtra("score4",0);

        b = (Button) findViewById(R.id.next_question);

        b.setEnabled(false);

        RadioGroup r = (RadioGroup) findViewById(R.id.group5);

        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                b.setEnabled(true);

                RadioButton rb = findViewById(checkedId);

                if(rb.getText().equals("Skadoosh")){
                    score = 15;
                }else {
                    score = 50;
                }

                score += score4;
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(step5.this, fim.class);
                i.putExtra("scoreFinal", score);
                startActivity(i);
            }
        });
    }
}
