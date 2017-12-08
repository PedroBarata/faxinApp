package com.example.pedrobarata.faxinapp.adapter;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pedrobarata.faxinapp.R;
import com.example.pedrobarata.faxinapp.model.Semana;
import com.example.pedrobarata.faxinapp.model.Situacao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by pedro.barata on 06/12/17.
 */

public class SemanaAdapter extends RecyclerView.Adapter<SemanaAdapter.SemanaHolder> {

    private List<Semana> semanaList;

    public SemanaAdapter(List<Semana> lista) {
        this.semanaList = lista;

    }

    public static class SemanaHolder extends RecyclerView.ViewHolder {
        TextView tvNome;
        TextView tvComodo;
        CardView cardSemana;
        public SemanaHolder(View itemView) {
            super(itemView);
            tvNome = (TextView) itemView.findViewById(R.id.tvNome);
            tvComodo = (TextView) itemView.findViewById(R.id.tvComodo);
            cardSemana = (CardView) itemView.findViewById(R.id.cardSemana);
        }
    }

    @Override
    public SemanaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_semana, parent, false);
        SemanaAdapter.SemanaHolder semanaHolder = new SemanaAdapter.SemanaHolder(view);
        return semanaHolder;
    }

    @Override
    public void onBindViewHolder(SemanaHolder holder, int position) {
//        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());

            long data = semanaList.get(position).getDataFim().getTime() - semanaList.get(position).getDataIncio().getTime();

            holder.tvNome.setText(semanaList.get(position).getNomeUsuario());
            holder.tvComodo.setText(semanaList.get(position).getComodo().getNome());
            if(semanaList.get(position).getSituacao() == Situacao.CONCLUIDO) {
                holder.cardSemana.setBackgroundColor(Color.parseColor("#bbeec3"));
                }
            if(semanaList.get(position).getSituacao() == Situacao.PENDENTE) {
//                    && data < -7) {
                holder.cardSemana.setBackgroundColor(Color.parseColor("#bbeec3"));
            }

        }  catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void addItem(Semana semana, int index) {
        semanaList.add(semana);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        semanaList.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return semanaList.size();
    }

}
