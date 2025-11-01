package com.arturo.menuopciones.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.arturo.menuopciones.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;

    // mis credenciales personalizadas
    private static final String VALID_USER = "arturo";
    private static final String VALID_PASS = "1234";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        binding.btnLogin.setOnClickListener(v -> {
            String u = binding.etUser.getText().toString().trim();
            String p = binding.etPass.getText().toString().trim();

            boolean ok = u.equals(VALID_USER) && p.equals(VALID_PASS);
            if (ok) {
                binding.tvError.setVisibility(View.GONE);
                Toast.makeText(requireContext(), "¡Bienvenido, estás logueado!", Toast.LENGTH_SHORT).show();
            } else {
                binding.tvError.setText("Las credenciales no son correctas.");
                binding.tvError.setVisibility(View.VISIBLE);
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
