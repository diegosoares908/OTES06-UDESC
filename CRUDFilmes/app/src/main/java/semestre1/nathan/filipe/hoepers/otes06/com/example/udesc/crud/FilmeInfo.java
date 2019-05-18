package semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.crud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class FilmeInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_info);

        String s = getIntent().getStringExtra("idfilme");

        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
