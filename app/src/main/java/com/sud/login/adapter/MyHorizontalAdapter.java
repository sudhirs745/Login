package com.sud.login.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.sud.login.R;
import com.sud.login.ReviewActivity;

public class MyHorizontalAdapter extends RecyclerView.Adapter<MyHorizontalAdapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public MyHorizontalAdapter(String[] myDataset, Context context) {
        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public MyHorizontalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.h_row_item, parent, false);
        ViewHolder vh = new ViewHolder(v);




        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, ReviewActivity.class);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}