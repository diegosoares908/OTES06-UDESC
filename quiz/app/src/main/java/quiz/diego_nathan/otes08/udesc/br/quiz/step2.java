package quiz.diego_nathan.otes08.udesc.br.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class step2 extends AppCompatActivity {

    Button b;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        final int score1 = getIntent().getIntExtra("score1",0);

        //Toast.makeText(step2.this, "."+score1, Toast.LENGTH_SHORT).show();

        b = (Button) findViewById(R.id.next_question);

        b.setEnabled(false);

        RadioGroup r = (RadioGroup) findViewById(R.id.group2);

        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                b.setEnabled(true);

                RadioButton rb = findViewById(checkedId);

                if(rb.getText().equals("Cavalo de fogo")){
                    score = 30;
                }else {
                    score = 20;
                }

                score += score1;
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(step2.this, step3.class);
                i.putExtra("score2", score);
                startActivity(i);
            }
        });
    }
}
