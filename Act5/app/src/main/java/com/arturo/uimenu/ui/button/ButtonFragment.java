package com.arturo.uimenu.ui.button;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.arturo.uimenu.databinding.FragmentButtonBinding;

public class ButtonFragment extends Fragment {
    private FragmentButtonBinding binding;
    private int count = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentButtonBinding.inflate(inflater, container, false);

        binding.btnAdd.setOnClickListener(v -> {
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
