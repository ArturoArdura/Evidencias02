package com.arturo.arturomovieapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.arturo.arturomovieapp.databinding.FragmentModifyMovieBinding;

public class ModifyMovieFragment extends Fragment {

    private FragmentModifyMovieBinding binding;
    private MovieViewModel movieViewModel;
    private int movieIndex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentModifyMovieBinding.inflate(inflater, container, false);
        movieViewModel = new ViewModelProvider(requireActivity()).get(MovieViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movieIndex = getArguments().getInt("movieIndex");
        Movie movie = movieViewModel.getMovies().getValue().get(movieIndex);

        binding.editMovieTitle.setText(movie.getTitle());
        binding.editMovieYear.setText(movie.getYear());

        binding.buttonSave.setOnClickListener(v -> {
            String title = binding.editMovieTitle.getText().toString();
            String year = binding.editMovieYear.getText().toString();

            if (!title.isEmpty() && !year.isEmpty()) {
                movieViewModel.updateMovie(movieIndex, new Movie(title, year, movie.getPosterUrl()));
                NavHostFragment.findNavController(ModifyMovieFragment.this).popBackStack();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
