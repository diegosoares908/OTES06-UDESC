package br.udesc.tads.otes.diego.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void shortToast(View view){

        Toast t = Toast.makeText(this, "Short", Toast.LENGTH_SHORT);

        t.show();
    }

    public void getRandom(View view){

        EditText min = findViewById(R.id.min);
        EditText max = findViewById(R.id.max);

        String stringMin = min.getText().toString();
        String stringMax = max.getText().toString();

        int numberMin = Integer.parseInt(stringMin);
        int numberMax = Integer.parseInt(stringMax);

        int rand = (int)(Math.random() * numberMax + numberMin);

        Toast t = Toast.makeText(this, rand+"", Toast.LENGTH_SHORT);

        t.show();
    }
}
