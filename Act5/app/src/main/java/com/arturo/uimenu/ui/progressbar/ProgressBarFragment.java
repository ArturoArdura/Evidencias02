package com.arturo.uimenu.ui.progressbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.arturo.uimenu.databinding.FragmentProgressBarBinding;

public class ProgressBarFragment extends Fragment {
    private FragmentProgressBarBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProgressBarBinding.inflate(inflater, container, false);

        binding.btnInc.setOnClickListener(v -> {
            int p = binding.pb.getProgress() + 10;
            if (p > 100) p = 100;
            binding.pb.setProgress(p);
            binding.tvPb.setText("Progreso: " + p + "%");
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
