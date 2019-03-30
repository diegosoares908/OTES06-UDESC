package quiz.diego_nathan.otes08.udesc.br.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class step1 extends AppCompatActivity {

    Button b;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);

        b = (Button) findViewById(R.id.next_question);

        RadioGroup r = (RadioGroup) findViewById(R.id.group1);

        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                b.setEnabled(true);

                RadioButton rb = findViewById(checkedId);

                if(rb.getText().equals("Doug")){
                    score = 27;
                }else {
                    score = 15;
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(step1.this, step2.class);
                i.putExtra("score1", score);
                startActivity(i);
            }
        });
    }
}
