package br.udesc.tads.otes.diego.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class loginSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        String s = getIntent().getStringExtra("username");

        TextView welcome = findViewById(R.id.welcome);

        String text = welcome.getText().toString() +" "+ s;

        welcome.setText(text);
    }
}
