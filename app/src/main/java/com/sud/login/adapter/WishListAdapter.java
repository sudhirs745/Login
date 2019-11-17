package com.sud.login.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.sud.login.R;


public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;

    public WishListAdapter(String[] myDataset, Context context) {
        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public WishListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wish_row_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  mContext.startActivity(new Intent(mContext, ChapterActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        ImageView cardIcon;
        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.ll_card_bacground);

        }
    }

}

