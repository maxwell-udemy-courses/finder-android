package com.maxwell.finder.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.maxwell.finder.R;

public class DemoViewHolder extends RecyclerView.ViewHolder {
    CardView cvDemoContainer;
    TextView tvDemo;


    public DemoViewHolder(@NonNull View v) {
        super(v);

        cvDemoContainer = v.findViewById(R.id.cvDemoContainer);
        tvDemo = v.findViewById(R.id.tvDemo);
    }
}
