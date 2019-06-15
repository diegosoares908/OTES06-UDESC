package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.R;
import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.entities.Director;

public class DirectorListAdapter extends RecyclerView.Adapter<DirectorListAdapter.DirectorListViewHolder> {

    List<Director> directors;
    OnDirectorClickListener onDirectorClickListener;

    public DirectorListAdapter(List<Director> directors, OnDirectorClickListener onDirectorClickListener) {
        this.directors = directors;
        this.onDirectorClickListener = onDirectorClickListener;
    }

    @Override
    public DirectorListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View directorItem = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.director_item_list, viewGroup, false);
        return new DirectorListViewHolder(directorItem);
    }

    @Override
    public void onBindViewHolder(DirectorListAdapter.DirectorListViewHolder directorListViewHolder, int i) {
        final Director d = this.directors.get(i);
        System.out.println(d.getName());
        directorListViewHolder.name.setText(d.getName());
        directorListViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDirectorClickListener.onDirectorClick(d);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.directors.size();
    }

    public class DirectorListViewHolder extends RecyclerView.ViewHolder{

        TextView name;

        public DirectorListViewHolder(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
        }
    }
}
