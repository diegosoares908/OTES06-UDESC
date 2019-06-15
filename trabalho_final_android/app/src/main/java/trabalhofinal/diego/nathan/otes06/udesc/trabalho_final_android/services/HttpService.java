package trabalhofinal.diego.nathan.otes06.udesc.trabalho_final_android.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpService {

    public final String GET = "GET";
    public final String POST = "POST";
    public final String DELETE = "DELETE";
    public final String PUT =  "PUT";

    private URL url;
    private HttpURLConnection connection;

    public String get(String url) throws IOException {
        this.build(url, GET);
        return this.dataToString(this.connection);
    }

    public String delete(String url) throws IOException {
        this.build(url, DELETE);
        return this.dataToString(this.connection);
    }

    public String post(String url, String payload) throws IOException {
        this.build(url, POST);
        this.connection.setDoOutput(true);

        try(OutputStream os = this.connection.getOutputStream()) {
            byte[] input = payload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        return this.dataToString(this.connection);
    }

    public String put(String url, String payload) throws IOException{
        this.build(url, PUT);
        this.connection.setDoOutput(true);

        try(OutputStream os = this.connection.getOutputStream()) {
            byte[] input = payload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        return this.dataToString(this.connection);
    }

    private HttpURLConnection build(String url, String method) throws IOException{
        try {
            this.url = new URL(url);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        this.connection = (HttpURLConnection) this.url.openConnection();
        this.connection.setRequestMethod(method);
        return this.setJson(this.connection);
    }

    private HttpURLConnection setJson(HttpURLConnection connection){
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    }

    private String dataToString(HttpURLConnection connection) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(), "utf-8"));

        StringBuilder response = new StringBuilder();
        String responseLine = null;

        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }

        return response.toString();
    }
}
