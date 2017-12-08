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
import android.widget.TextView;

import com.example.pedrobarata.faxinapp.R;
import com.example.pedrobarata.faxinapp.adapter.SemanaAdapter;
import com.example.pedrobarata.faxinapp.model.Comodo;
import com.example.pedrobarata.faxinapp.model.Semana;
import com.example.pedrobarata.faxinapp.model.Situacao;
import com.example.pedrobarata.faxinapp.model.Usuario;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SemanaFragment extends Fragment {

    private RecyclerView rcSemana;
    private TextView numeroSemana;
    private TextView tvComodo;
    private TextView tvDescricao;

    public SemanaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_semana, container, false);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Integer nSemana = calendar.get(Calendar.WEEK_OF_MONTH);

        numeroSemana = (TextView) view.findViewById(R.id.numeroSemana);
        numeroSemana.setText(nSemana.toString());
        rcSemana = (RecyclerView) view.findViewById(R.id.rvSemana);
        tvDescricao = (TextView) view.findViewById(R.id.tvDescricaoTarefa);
        tvComodo = (TextView) view.findViewById(R.id.tvComodoTarefa);

        configurarRecyclerView(rcSemana, getActivity());
        List<Semana> semanaList = new ArrayList<>();

        Semana semana1 = new Semana();
        Semana semana2 = new Semana();
        Comodo comodo1 = new Comodo();
        Comodo comodo2 = new Comodo();
        Comodo comodo = new Comodo();

        comodo.setNome("Sala");
        comodo.setDescricao("Limpar chão, passar pano nas mesas...");

        tvComodo.setText(comodo.getNome());
        tvDescricao.setText(comodo.getDescricao());

        comodo1.setNome("Teste");
        comodo1.setDescricao("Limpar chão, passar pano nas mesas...");
        semana1.setComodo(comodo1);

        semana1.setNomeUsuario("Juvenal");
        semana1.setSituacao(Situacao.PENDENTE);

        comodo1.setNome("Banheiro");
        comodo1.setDescricao("Pano no chão, boxe...");

        semana2.setComodo(comodo2);
        semana2.setNomeUsuario("Teste");
        semana2.setSituacao(Situacao.CONCLUIDO);

        semanaList.add(semana1);
        semanaList.add(semana2);

        SemanaAdapter semanaAdapter = new SemanaAdapter(semanaList);

        rcSemana.setAdapter(semanaAdapter);



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
