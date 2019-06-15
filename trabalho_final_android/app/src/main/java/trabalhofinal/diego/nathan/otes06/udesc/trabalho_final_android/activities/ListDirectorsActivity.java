package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.R;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.entities.Director;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.services.DirectorsService;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.ui.DirectorListAdapter;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.ui.OnDirectorClickListener;

public class ListDirectorsActivity extends AppCompatActivity implements OnDirectorClickListener<Director> {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_directors);
        list = findViewById(R.id.list);

        LoadAllDirectors loadAllDirectors = new LoadAllDirectors(this);
        loadAllDirectors.execute();

        FloatingActionButton addMovie = findViewById(R.id.addFab);//filmes
        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListDirectorsActivity.this, AddDirectorActivity.class); //addDirectors
                startActivity(i);
            }
        });
    }

    @Override
    public void onDirectorClick(Director director) {
        Intent i = new Intent(ListDirectorsActivity.this, DirectorInfoActivity.class);
        i.putExtra("iddirector", director.getId());
        startActivity(i);
    }

    class LoadAllDirectors extends AsyncTask<Void, Void, List<Director>> {

        OnDirectorClickListener onDirectorClickListener;

        LoadAllDirectors(OnDirectorClickListener onDirectorClickListener){
            super();
            this.onDirectorClickListener = onDirectorClickListener;
        }

        @Override
        protected List<Director> doInBackground(Void... voids) {
            DirectorsService directorsService = new DirectorsService();
            List<Director> director = directorsService.getAll();
            return director;
        }

        @Override
        protected void onPostExecute(List<Director> movies){

            RecyclerView.Adapter<DirectorListAdapter.DirectorListViewHolder> adapter = new DirectorListAdapter(movies, onDirectorClickListener);

            RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
            list.setLayoutManager(manager);
            list.setHasFixedSize(true);
            list.setAdapter(adapter);


        }
    }
}