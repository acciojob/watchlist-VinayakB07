package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieService.addMovieDirectorPair(director,movie);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie response=movieService.getMovieByName(name);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director response=movieService.getDirectorByName(name);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @GetMapping("/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name){
        List<String> response=movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> response=movieService.findAllMovies();
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
