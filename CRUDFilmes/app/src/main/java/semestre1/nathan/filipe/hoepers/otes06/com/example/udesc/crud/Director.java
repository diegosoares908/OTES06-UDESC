package semestre1.nathan.filipe.hoepers.otes06.com.example.udesc.crud;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private int id;
    private String name;
    private String birth;
    private String country;
    private List<Movie> movies;

    public Director(String name, String birth, String country, List<Movie> movies){
        this.name = name;
        this.birth = birth;
        this.country = country;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
