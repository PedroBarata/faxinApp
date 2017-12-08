package com.example.pedrobarata.faxinapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pedrobarata.faxinapp.R;
import com.example.pedrobarata.faxinapp.model.Mes;

import java.util.List;

/**
 * Created by pedro.barata on 05/12/17.
 */

public class VisaoGeralAdapter extends RecyclerView.Adapter<VisaoGeralAdapter.VisaoGeralViewHolder> {
    private List<Mes> mesList;
    private Context mContext;
    private static final int VIEW_TYPE_PADDING = 1;
    private static final int VIEW_TYPE_ITEM = 2;

    public VisaoGeralAdapter(Context context, List<Mes> list) {
        this.mContext = context;
        this.mesList = list;
    }

    @Override
    public VisaoGeralViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mes, parent, false);
            return new VisaoGeralAdapter.VisaoGeralViewHolder(itemView);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_padding, parent, false);
            return new VisaoGeralAdapter.VisaoGeralViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(VisaoGeralAdapter.VisaoGeralViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_ITEM) {
            Mes mes = mesList.get(position - 1);

            holder.nome.setText(mes.getNome());
        }
    }


    @Override
    public int getItemCount() {
        return mesList.size()+2;
    }

    public static class VisaoGeralViewHolder extends RecyclerView.ViewHolder {
        private TextView nome;

        public VisaoGeralViewHolder(View itemView) {
            super(itemView);
            this.nome = (TextView)itemView.findViewById(R.id.tvItemListMes);
        }
    }
}
