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

public class MoviesService {

    private String baseUrl;
    private String repositoryName;
    private String fullUrl;
    private URL url;
    private HttpURLConnection connection;

    public MoviesService(){
        baseUrl = "http://10.0.2.2:8080";
        repositoryName = "movies";
        fullUrl = baseUrl+"/"+repositoryName;
    }

    public void addMovie(String title, int duration, double cost, int year, String currency){
        try {
            this.url = new URL(this.fullUrl);
            this.connection = (HttpURLConnection) this.url.openConnection();
            this.connection.setRequestMethod("POST");
            this.connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            this.connection.setRequestProperty("Accept", "application/json");
            this.connection.setDoOutput(true);

            Random randomId = new Random();

            int idFilme = randomId.nextInt(9999999 - 1000000);

            String jsonInputString = "{\"id\": \"tt"+idFilme+"\",\"title\" : \""+title+"\", \"duration\" : "+duration+",\"cost\" : "+cost+",\"year\" : "+year+",\"currency\" : \""+currency+"\"}";
            System.out.println(jsonInputString);

            try(OutputStream os = this.connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(this.connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteMovie(String id){
        StringBuilder content = new StringBuilder();

        try {
            url = new URL(fullUrl+ "/"+ id);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Movie getById(String id){
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

        Movie movie = new Movie();
        try {
            JSONObject object = new JSONObject(content.toString());

            movie.setId(object.getString("id"));
            movie.setTitle(object.getString("title"));
            movie.setDuration(object.getInt("duration"));
            movie.setCost(object.getDouble("cost"));
            movie.setYear(object.getInt("year"));
            movie.setCurrency(object.getString("currency"));

            return movie;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Movie> getAll(){

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

        List<Movie> movies = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(content.toString());

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                Movie movie = new Movie();

                movie.setId(object.getString("id"));
                //movie.setCost(object.getDouble("cost"));
                movie.setTitle(object.getString("title"));
                //movie.setDuration(object.getInt("duration"));
                movie.setYear(object.getInt("year"));
                //movie.setDirector_id(object.getInt("director_id"));
                //movie.setCurrency(object.getString("currency"));

                movies.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return movies;

    }
}