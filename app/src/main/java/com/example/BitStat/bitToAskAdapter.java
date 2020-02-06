package com.example.BitStat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class bitToAskAdapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<BidtoAsk> bidtoAsks ;
    public bitToAskAdapter() {
        bidtoAsks = new ArrayList<>();
    }

    public void setData(ArrayList<BidtoAsk> bidtoAsks)
    {
        this.bidtoAsks = bidtoAsks ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_b2a_layout, parent, false);
        return new ViewHolder(view) ;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
BidtoAsk bidtoAsk = bidtoAsks.get(position);
holder.bids.setText(bidtoAsk.bids);
holder.asks.setText(bidtoAsk.asks);
    }

    @Override
    public int getItemCount() {
        return bidtoAsks.size();
    }
}
