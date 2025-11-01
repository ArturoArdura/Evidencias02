package com.arturo.uimenu.ui.checkbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.arturo.uimenu.databinding.FragmentCheckBoxBinding;

public class CheckBoxFragment extends Fragment {
    private FragmentCheckBoxBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCheckBoxBinding.inflate(inflater, container, false);

        View.OnClickListener update = v -> {
            String res = "Marcadas: ";
            boolean any = false;
            if (binding.cb1.isChecked()) { res += "Opción 1 "; any = true; }
            if (binding.cb2.isChecked()) { res += "Opción 2 "; any = true; }
            if (!any) res += "-";
            binding.tvChecked.setText(res.trim());
        };

        binding.cb1.setOnClickListener(update);
        binding.cb2.setOnClickListener(update);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
