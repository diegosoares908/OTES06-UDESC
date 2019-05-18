package semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.crud;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MoviesService {

    private String baseUrl;
    private String repositoryName;
    private String fullUrl;
    private URL url;
    private HttpURLConnection connection;

    public MoviesService(){
        this.baseUrl = "http://10.0.2.2:8080";
        this.repositoryName = "movies";
        this.fullUrl = this.baseUrl+"/"+this.repositoryName;
    }

    public List<Movie> getAll(){

        StringBuffer content = new StringBuffer();
        //ObjectMapper mapper = new ObjectMapper();
        try {
            this.url = new URL(this.fullUrl);
            this.connection = (HttpURLConnection) this.url.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(this.connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Movie> movies = null;
        try {
            JSONArray array = new JSONArray(content.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return movies;

    }
}