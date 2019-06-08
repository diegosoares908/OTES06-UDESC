package semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.crud;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetService {

    private String baseUrl;
    private String repositoryName;
    private String fullUrl;
    private URL url;
    private HttpURLConnection connection;

    public GetService(String url){
        this.baseUrl = "http://10.0.2.2:8080";
        this.fullUrl = this.baseUrl+"/"+url;
    }

    public List<Movie> getMovies(){

        StringBuffer content = new StringBuffer();

        try {
            this.url = new URL(this.fullUrl);
            this.connection = (HttpURLConnection) this.url.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(this.connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                //Armazena os filmes na variável content
                content.append(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Informações que serão retornadas
        List<Movie> data = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(content.toString());

            //Mostra as info no console
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                Log.d("TESTE", object.toString());
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return data;

    }

    public List<Director> getDirector(){

        StringBuffer content = new StringBuffer();

        try {
            this.url = new URL(this.fullUrl);
            this.connection = (HttpURLConnection) this.url.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(this.connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                //Armazena os filmes na variável content
                content.append(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Informações que serão retornadas
        List<Director> directors = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(content.toString());

            //Mostra as info no console
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                Log.d("TESTE", object.toString());
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return directors;

    }

}
