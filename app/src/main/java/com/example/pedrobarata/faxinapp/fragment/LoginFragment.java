package com.example.pedrobarata.faxinapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pedrobarata.faxinapp.activity.HomeActivity;
import com.example.pedrobarata.faxinapp.R;

public class LoginFragment extends Fragment {
    private EditText edLogin, edSenha;
    private Button btEntrar;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        edLogin = (EditText) view.findViewById(R.id.ed_login);
        edSenha = (EditText) view.findViewById(R.id.ed_senha);
        btEntrar = (Button) view.findViewById(R.id.bt_entrar);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
