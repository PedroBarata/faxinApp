package com.example.pedrobarata.faxinapp.fragment;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
    private LinearLayout tarefaSemana;
    private ImageButton ibCheck;

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
        tarefaSemana = (LinearLayout) view.findViewById(R.id.tarefaSemana);
        ibCheck = (ImageButton) view.findViewById(R.id.ibCheck);

        configurarRecyclerView(rcSemana, getActivity());
        List<Semana> semanaList = new ArrayList<>();

        Semana semana1 = new Semana();
        Semana semana2 = new Semana();
        Comodo comodo1 = new Comodo();
        Comodo comodo2 = new Comodo();
        Comodo comodo = new Comodo();



        comodo.setNome("Sala");
        comodo.setDescricao("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");

        tvComodo.setText(comodo.getNome());
        tvDescricao.setText(comodo.getDescricao());

        comodo1.setNome("Teste");
        comodo1.setDescricao("Limpar chão, passar pano nas mesas...");
        semana1.setComodo(comodo1);
        semana1.setDataIncio(new Date());
        semana1.setDataFim(new Date());

        semana1.setNomeUsuario("Juvenal");
        semana1.setSituacao(Situacao.PENDENTE);

        comodo1.setNome("Banheiro");
        comodo1.setDescricao("Pano no chão, boxe...");

        semana2.setComodo(comodo2);
        semana2.setNomeUsuario("Teste");
        semana2.setSituacao(Situacao.CONCLUIDO);
        semana2.setDataIncio(new Date());
        semana2.setDataFim(new Date());

        semanaList.add(semana1);
        semanaList.add(semana2);
        semanaList.add(semana1);
        semanaList.add(semana1);

        if(semana1.getSituacao() == Situacao.CONCLUIDO) {

//            tarefaSemana.setBackgroundColor(Color.parseColor("#fefeaa"));
            tarefaSemana.setBackgroundColor(Color.parseColor("#bbeec3"));
            ibCheck.setBackgroundResource(R.drawable.shape_check_cinza);
            ibCheck.setEnabled(false);
            ibCheck.setClickable(false);
        }
        if(semana1.getSituacao() == Situacao.PENDENTE) {
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                tarefaSemana.setBackgroundColor(Color.parseColor("#fefeaa"));

            }
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                tarefaSemana.setBackgroundColor(Color.parseColor("#fea59a"));

            }
        }

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
