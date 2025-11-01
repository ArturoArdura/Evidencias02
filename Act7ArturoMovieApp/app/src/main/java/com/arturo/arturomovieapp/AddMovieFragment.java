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

import com.arturo.arturomovieapp.databinding.FragmentAddMovieBinding;

public class AddMovieFragment extends Fragment {

    private FragmentAddMovieBinding binding;
    private MovieViewModel movieViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddMovieBinding.inflate(inflater, container, false);
        movieViewModel = new ViewModelProvider(requireActivity()).get(MovieViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSave.setOnClickListener(v -> {
            String title = binding.editMovieTitle.getText().toString();
            String year = binding.editMovieYear.getText().toString();

            if (!title.isEmpty() && !year.isEmpty()) {
                Movie movie = new Movie(title, year, "file:///android_asset/placeholder.jpg");
                movieViewModel.addMovie(movie);
                NavHostFragment.findNavController(AddMovieFragment.this).popBackStack();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
