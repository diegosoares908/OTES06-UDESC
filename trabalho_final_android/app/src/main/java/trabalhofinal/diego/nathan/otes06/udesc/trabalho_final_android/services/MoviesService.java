package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.services;

import org.json.JSONException;
import org.json.JSONObject;

import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.entities.Movie;

public class MoviesService extends RepositoryService<Movie>{

    @Override
    public String getRepositoryName() {
        return "movies";
    }

    @Override
    public String getBaseUrl() {
        return "http://10.0.2.2:8080";
    }

    @Override
    public Movie buildItem(JSONObject obj) throws JSONException {
        Movie movie = new Movie();
        movie.setId(obj.getString("id"));
        if(obj.has("title")) movie.setTitle(obj.getString("title"));
        if(obj.has("duration")) movie.setDuration(obj.getInt("duration"));
        if(obj.has("cost")) movie.setCost(obj.getDouble("cost"));
        if(obj.has("year")) movie.setYear(obj.getInt("year"));
        if(obj.has("director_id")) movie.setDirector_id(obj.getInt("director_id"));
        if(obj.has("currency")) movie.setCurrency(obj.getString("currency"));
        return movie;
    }

    @Override
    public JSONObject unbuildItem(Movie item) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("id", item.getId());
        json.put("title", item.getTitle());
        json.put("duration", item.getDuration());
        json.put("cost", item.getCost());
        json.put("year", item.getYear());
        json.put("director_id", item.getDirector_id());
        json.put("currency", item.getCurrency());
        return json;

    }
}
