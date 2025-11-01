package com.arturo.menuopciones.ui.calculadora;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.arturo.menuopciones.databinding.FragmentCalculadoraBinding;

public class CalculadoraFragment extends Fragment {
    private FragmentCalculadoraBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCalculadoraBinding.inflate(inflater, container, false);

        binding.btnSumar.setOnClickListener(v -> {
            String a = binding.etA.getText().toString().trim();
            String b = binding.etB.getText().toString().trim();

            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
                binding.tvRes.setText("Resultado: ingresa ambos números");
                return;
            }
            try {
                double x = Double.parseDouble(a);
                double y = Double.parseDouble(b);
                binding.tvRes.setText("Resultado: " + (x + y));
            } catch (NumberFormatException e) {
                binding.tvRes.setText("Resultado: entrada inválida");
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
