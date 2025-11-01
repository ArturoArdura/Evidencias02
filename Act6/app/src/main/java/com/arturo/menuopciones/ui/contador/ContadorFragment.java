package com.arturo.menuopciones.ui.contador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.arturo.menuopciones.databinding.FragmentContadorBinding;

public class ContadorFragment extends Fragment {
    private FragmentContadorBinding binding;
    private int count = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContadorBinding.inflate(inflater, container, false);

        binding.btnSumar.setOnClickListener(v -> {
            count++;
            binding.tvCount.setText("Cuenta: " + count);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
