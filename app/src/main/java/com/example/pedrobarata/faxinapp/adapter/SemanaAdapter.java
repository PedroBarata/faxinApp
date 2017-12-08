package com.example.pedrobarata.faxinapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pedrobarata.faxinapp.R;
import com.example.pedrobarata.faxinapp.model.Semana;

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

        public SemanaHolder(View itemView) {
            super(itemView);
            tvNome = (TextView) itemView.findViewById(R.id.tvNome);
            tvComodo = (TextView) itemView.findViewById(R.id.tvComodo);
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

            holder.tvNome.setText(semanaList.get(position).getNomeUsuario());
            holder.tvComodo.setText(semanaList.get(position).getComodo().getNome());
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
