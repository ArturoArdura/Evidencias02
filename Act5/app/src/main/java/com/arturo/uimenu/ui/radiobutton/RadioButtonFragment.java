package com.arturo.uimenu.ui.radiobutton;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.arturo.uimenu.databinding.FragmentRadioButtonBinding;

public class RadioButtonFragment extends Fragment {
    private FragmentRadioButtonBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRadioButtonBinding.inflate(inflater, container, false);

        binding.rg.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == binding.rbA.getId()) {
                binding.tvChoice.setText("Seleccionado: Opción A");
            } else if (checkedId == binding.rbB.getId()) {
                binding.tvChoice.setText("Seleccionado: Opción B");
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
