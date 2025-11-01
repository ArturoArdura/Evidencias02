package com.arturo.arturomovieapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {
    private final MutableLiveData<List<Movie>> movies = new MutableLiveData<>();

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        List<Movie> currentMovies = movies.getValue();
        if (currentMovies == null) {
            currentMovies = new ArrayList<>();
        }
        currentMovies.add(movie);
        movies.setValue(currentMovies);
    }

    public void updateMovie(int index, Movie movie) {
        List<Movie> currentMovies = movies.getValue();
        if (currentMovies != null) {
            currentMovies.set(index, movie);
            movies.setValue(currentMovies);
        }
    }

    // In a real app, you would load the initial data from a repository (e.g., from a database or network)
    public void loadInitialMovies() {
        List<Movie> initialMovies = new ArrayList<>();
        initialMovies.add(new Movie("The Shawshank Redemption", "1994", "file:///android_asset/shawshank.png"));
        initialMovies.add(new Movie("The Godfather", "1972", "file:///android_asset/godfather.webp"));
        initialMovies.add(new Movie("The Dark Knight", "2008", "file:///android_asset/darknight.jpg"));
        initialMovies.add(new Movie("Pulp Fiction", "1994", "file:///android_asset/pulp.jpg"));
        initialMovies.add(new Movie("Forrest Gump", "1994", "file:///android_asset/forrest.jpg"));
        initialMovies.add(new Movie("Fight Club", "1999", "file:///android_asset/fight.jpg"));
        initialMovies.add(new Movie("Inception", "2010", "file:///android_asset/inception.jpg"));
        initialMovies.add(new Movie("The Matrix", "1999", "file:///android_asset/matrix.jpg"));
        initialMovies.add(new Movie("Goodfellas", "1990", "file:///android_asset/god.jpg"));
        initialMovies.add(new Movie("The Silence of the Lambs", "1991", "file:///android_asset/silence.jpg"));
        movies.setValue(initialMovies);
    }
}
