package com.sud.login;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sud.login.adapter.MyHorizontalAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;

public class HomeSearch extends AppCompatActivity {

    private RecyclerView mrecyclerView;

    MyHorizontalAdapter mHAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_search);


        mrecyclerView= findViewById(R.id.rv_horizanteal);

        mrecyclerView.setHasFixedSize(true);

        LinearLayoutManager  mCLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mrecyclerView.setLayoutManager(mCLayoutManager);

        mHAdapter = new MyHorizontalAdapter(new String[]{"0", "1", "2", "3", "4", "5"}, this);
        mrecyclerView.setAdapter(mHAdapter);

        ImageView im_wishlist = findViewById(R.id.im_wishlist);
        ImageView im_cart = findViewById(R.id.im_cart);
        CardView c_addReview = findViewById(R.id.c_addReview);

        im_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeSearch.this,WishlistActivity.class));


            }
        });

        im_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeSearch.this,HomeActivity.class));


            }
        });

        c_addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeSearch.this,AddReviewActivity.class));


            }
        });



    }

}
