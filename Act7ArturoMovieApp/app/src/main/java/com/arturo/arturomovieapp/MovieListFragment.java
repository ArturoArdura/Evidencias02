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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.arturo.arturomovieapp.databinding.FragmentMovieListBinding;

import java.util.ArrayList;

public class MovieListFragment extends Fragment implements MovieAdapter.OnMovieClickListener {

    private FragmentMovieListBinding binding;
    private MovieViewModel movieViewModel;
    private MovieAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMovieListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.movieRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MovieAdapter(getContext(), new ArrayList<>(), this);
        binding.movieRecyclerView.setAdapter(adapter);

        movieViewModel = new ViewModelProvider(requireActivity()).get(MovieViewModel.class);
        movieViewModel.getMovies().observe(getViewLifecycleOwner(), movies -> {
            adapter.setMovies(movies);
        });

        if (movieViewModel.getMovies().getValue() == null) {
            movieViewModel.loadInitialMovies();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onMovieClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("movieIndex", position);
        NavHostFragment.findNavController(this).navigate(R.id.action_movieListFragment_to_modifyMovieFragment, bundle);
    }
}
