package com.arturo.menuopciones.ui.edad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.arturo.menuopciones.databinding.FragmentEdadBinding;

import java.util.Calendar;

public class EdadFragment extends Fragment {
    private FragmentEdadBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEdadBinding.inflate(inflater, container, false);

        binding.btnCalc.setOnClickListener(v -> {
            int day = binding.datePicker.getDayOfMonth();
            int month = binding.datePicker.getMonth();           // 0-11
            int year = binding.datePicker.getYear();

            int edad = calcularEdad(day, month, year);
            binding.tvEdad.setText("Edad: " + edad + " años");
        });

        return binding.getRoot();
    }

    private int calcularEdad(int day, int monthZeroBased, int year) {
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - year;

        int mActual = hoy.get(Calendar.MONTH); // 0-11
        int dActual = hoy.get(Calendar.DAY_OF_MONTH);

        if (mActual < monthZeroBased || (mActual == monthZeroBased && dActual < day)) {
            edad--;
        }
        return Math.max(0, edad);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
