package com.example.BitStat;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.BitStat.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView bids ;
    TextView asks ;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        bids = itemView.findViewById(R.id.bids);
        asks = itemView.findViewById(R.id.asks);
    }
}
