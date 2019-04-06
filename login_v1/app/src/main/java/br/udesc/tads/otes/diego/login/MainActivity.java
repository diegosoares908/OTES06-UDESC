package br.udesc.tads.otes.diego.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.login);

        this.user = findViewById(R.id.username);
        this.pass = findViewById(R.id.password);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userStr = user.getText().toString();
                String passStr = pass.getText().toString();

                boolean allowAccess = verifyLogin(userStr,passStr);

                if(allowAccess){

                    Intent i = new Intent(MainActivity.this, loginSuccess.class);
                    i.putExtra("username", user.getText().toString());
                    startActivity(i);

                }else{

                    Intent i = new Intent(MainActivity.this, loginError.class);
                    startActivity(i);
                }
            }
        });
    }

    public boolean verifyLogin(String user, String pass){

        if(user.equals("diego") && pass.equals("123")){
            return true;
        }else{
            return false;
        }
    }
}
