package com.sud.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.sud.login.adapter.MyHorizontalAdapter;
import com.sud.login.adapter.WishListAdapter;

public class WishlistActivity extends AppCompatActivity {


    private RecyclerView mrecyclerView;

    WishListAdapter mWAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mrecyclerView= findViewById(R.id.rv);

        mrecyclerView.setHasFixedSize(true);

        LinearLayoutManager mCLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mrecyclerView.setLayoutManager(mCLayoutManager);

        mWAdapter = new WishListAdapter(new String[]{"0", "1", "2", "3", "4", "5"}, this);
        mrecyclerView.setAdapter(mWAdapter);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
