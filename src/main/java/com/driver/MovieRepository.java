package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class MovieRepository {
    private HashMap<String,Movie>movieMap;
    private HashMap<String,Director>directorMap;
    private HashMap<String, List<String>>movieDirectorMap;

    public MovieRepository() {
        this.movieMap = new HashMap<String,Movie>();
        this.directorMap =new HashMap<String,Director>();
        this.movieDirectorMap = new HashMap<String, List<String>>();
    }

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
    }
    public void addDirector(Director director){
        directorMap.put(director.getName(), director);
    }
    public void addMovieDirectorPair(String movie,String director){
        if(movieMap.containsKey(movie)&&directorMap.containsKey(director)){
            List<String>currentMovie=new ArrayList<>();
            if(movieDirectorMap.containsKey(director)) currentMovie=movieDirectorMap.get(director);
            currentMovie.add(movie);
            movieDirectorMap.put(director,currentMovie);
        }
    }
    public Movie getMovieByName(String name){
        if(!movieMap.containsKey(name)){
            return null;
        }
        return movieMap.get(name);
    }
    public Director getDirectorByName(String name){
        if(!directorMap.containsKey(name)){
            return null;
        }
        return directorMap.get(name);
    }
    public List<String> getMoviesByDirectorName(String name){
        if(!movieDirectorMap.containsKey(name)){
            return null;
        }
        return movieDirectorMap.get(name);
    }
    public List<String> findAllMovies(){
        List<String>movies=new ArrayList<>();
        for(String s:movieMap.keySet()){
            movies.add(s);
        }
        return movies;
    }
    public void deleteDirectorByName(String name){
        List<String>movies=movieDirectorMap.get(name);
        for(String x:movies){
            if(movieMap.containsKey(x)){
                movieMap.remove(x);
            }
        }
        directorMap.remove(name);
        movieDirectorMap.remove(name);
    }
    public void deleteAllDirectors(){
        for(String s:movieDirectorMap.keySet()){
            List<String>movies=movieDirectorMap.get(s);
            for(String x:movies){
                if(movieMap.containsKey(x)){
                    movieMap.remove(x);
                }
            }
        }
        movieDirectorMap.clear();
        directorMap.clear();
    }
}
