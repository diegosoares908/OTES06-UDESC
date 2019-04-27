package semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.myapplication;

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

        List<Movie> movies = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(content.toString());


            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
//                Movie movie = new Movie();
//
//                movie.setId(object.getLong("id"));
//                movie.setCost(object.getLong("cost"));
//                movie.setTitle(object.getString("title"));
//                movie.setDuration(object.getInt("duration"));
//                movie.setYear(object.getInt("year"));
//                movie.setDirector_id(object.getInt("director_id"));
//                movie.setCurrency(object.getString("currency"));

                Log.d("TESTE", object.toString());
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        //try {
            //movies = mapper.readValue(content.toString(), new TypeReference<List<Movie>>(){});
        //} catch (IOException e) {
          //  e.printStackTrace();
        //}


        return movies;

    }


}
