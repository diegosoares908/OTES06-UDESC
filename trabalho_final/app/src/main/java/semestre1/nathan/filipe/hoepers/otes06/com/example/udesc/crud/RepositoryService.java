package semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.crud;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryService<T> {

    private HttpService httpService;

    public RepositoryService(){
        this.httpService = new HttpService();
    }

    public abstract String getRepositoryName();

    public abstract String getBaseUrl();

    public abstract T buildItem(JSONObject obj) throws JSONException;

    public abstract JSONObject unbuildItem(T item) throws JSONException;

    public String getFullUrl(){
        return this.getBaseUrl()+"/"+this.getRepositoryName();
    }

    public void deleteById(String id){
        String path = this.getFullUrl()+"/"+id;
        try {
            String response = this.httpService.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create(T item){
        try {
            JSONObject obj = this.unbuildItem(item);
            String payload = obj.toString();
            String response = this.httpService.post(this.getFullUrl(), payload);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public T getById(String id){
        String path = this.getFullUrl()+"/"+id;
        T item = null;
        try {
            String response = this.httpService.get(path);
            JSONObject itemJson = new JSONObject(response);
            item = this.buildItem(itemJson);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return item;
    }

    public void updateById(T item, String id){
        try {
            JSONObject obj = this.unbuildItem(item);
            String payload = obj.toString();
            String response = this.httpService.put(this.getFullUrl()+"/"+id, payload);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<T> getAll(){
        List<T> items = new ArrayList<T>();

        try {
            String response = this.httpService.get(this.getFullUrl());
            JSONArray itemsJson = new JSONArray(response);
            for(int i = 0;i<itemsJson.length();i++){
                JSONObject obj = itemsJson.getJSONObject(i);
                items.add(this.buildItem(obj));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return items;
    }
}
