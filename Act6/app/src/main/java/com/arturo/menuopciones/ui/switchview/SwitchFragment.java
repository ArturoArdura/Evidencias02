package com.arturo.menuopciones.ui.switchview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.arturo.menuopciones.databinding.FragmentSwitchBinding;

public class SwitchFragment extends Fragment {
    private FragmentSwitchBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSwitchBinding.inflate(inflater, container, false);

        binding.sw.setOnCheckedChangeListener((buttonView, isChecked) ->
                binding.tvEstado.setText("Estado: " + (isChecked ? "ON" : "OFF")));

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
