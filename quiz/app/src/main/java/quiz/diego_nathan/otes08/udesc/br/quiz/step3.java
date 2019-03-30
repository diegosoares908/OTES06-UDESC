package quiz.diego_nathan.otes08.udesc.br.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class step3 extends AppCompatActivity {

    Button b;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);

        final int score2 = getIntent().getIntExtra("score2",0);

        //Toast.makeText(step3.this, ""+score2, Toast.LENGTH_SHORT).show();

        b = (Button) findViewById(R.id.next_question);

        b.setEnabled(false);

        RadioGroup r = (RadioGroup) findViewById(R.id.group3);

        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                b.setEnabled(true);

                RadioButton rb = findViewById(checkedId);

                if(rb.getText().equals("Palmtopinho")){
                    score = 23;
                }else {
                    score = 18;
                }

                score += score2;
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(step3.this, step4.class);
                i.putExtra("score3", score);
                startActivity(i);
            }
        });
    }
}
