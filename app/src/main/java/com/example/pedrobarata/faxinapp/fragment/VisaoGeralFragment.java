package com.example.pedrobarata.faxinapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pedrobarata.faxinapp.R;
import com.example.pedrobarata.faxinapp.adapter.VisaoGeralAdapter;

public class VisaoGeralFragment extends Fragment {

    private RecyclerView rcVisaoGeral;
    private VisaoGeralAdapter visaoGeralAdapter;
    public VisaoGeralFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_visao_geral, container, false);
        rcVisaoGeral = (RecyclerView) view.findViewById(R.id.rvMes);

        configurarRecyclerView(rcVisaoGeral, getActivity());

        return view;
    }

    public static void configurarRecyclerView(RecyclerView recyclerView, Context contexto) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(contexto);
        recyclerView.setLayoutManager(mLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(contexto, 1);
        recyclerView.addItemDecoration(itemDecoration);
    }

}
