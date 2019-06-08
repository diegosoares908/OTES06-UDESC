package semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.crud;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DirectorService {

    private String baseUrl;
    private String repositoryName;
    private String fullUrl;
    private URL url;
    private HttpURLConnection connection;

    public DirectorService(){
        baseUrl = "http://10.0.2.2:8080";
        repositoryName = "directors";
        fullUrl = baseUrl+"/"+repositoryName;
    }

    public Director getById(String id){
        StringBuilder content = new StringBuilder();

        try {
            url = new URL(fullUrl+ "/"+ id);
            connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Director director = new Director();
        try {
            JSONObject object = new JSONObject(content.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Director> getAll(){

        StringBuilder content = new StringBuilder();

        try {
            url = new URL(fullUrl);
            connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Director> directors = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(content.toString());

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                Director director = new Director();

                director.setId(object.getString("id"));
                director.setName(object.getString("name"));

                directors.add(director);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return directors;

    }
}
