package quiz.diego_nathan.otes08.udesc.br.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class step4 extends AppCompatActivity {

    Button b;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step4);

        final int score3 = getIntent().getIntExtra("score3",0);

        b = (Button) findViewById(R.id.next_question);

        b.setEnabled(false);

        RadioGroup r = (RadioGroup) findViewById(R.id.group4);

        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                b.setEnabled(true);

                RadioButton rb = findViewById(checkedId);

                if(rb.getText().equals("Enormossauro")){
                    score = 18;
                }else {
                    score = 25;
                }

                score += score3;
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(step4.this, step5.class);
                i.putExtra("score4", score);
                startActivity(i);
            }
        });
    }
}
