package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.services;

import org.json.JSONException;
import org.json.JSONObject;

import trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.entities.Director;

public class DirectorsService  extends RepositoryService<Director>{

    @Override
    public String getRepositoryName() {
        return "directors";
    }

    @Override
    public String getBaseUrl() {
        return "http://127.2.1.1:8080";
    }

    @Override
    public Director buildItem(JSONObject obj) throws JSONException {

        Director director = new Director();
        director.setId(obj.getString("id"));
        if(obj.has("name")) director.setName(obj.getString("name"));
        if(obj.has("birth")) director.setBirth(obj.getString("birth"));
        if(obj.has("country")) director.setCountry(obj.getString("country"));

        return director;
    }

    @Override
    public JSONObject unbuildItem(Director item) throws JSONException {

        JSONObject json = new JSONObject();

        json.put("id", item.getId());
        json.put("name", item.getName());
        json.put("birth", item.getBirth());
        json.put("country", item.getCountry());

        return json;
    }
}