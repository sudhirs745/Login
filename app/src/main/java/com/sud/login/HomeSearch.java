package com.sud.login;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sud.login.adapter.MyHorizontalAdapter;
import com.sud.login.bottomsheet.CookieBar;
import com.sud.login.bottomsheet.OnActionClickListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeSearch extends AppCompatActivity {

    TextView tv_add_cart;
    LinearLayout lv_add_plus;
    private RecyclerView mrecyclerView;
    int count = 0;
    Button bt_more;
    Button bt_less;

    MyHorizontalAdapter mHAdapter;

    TextView tv_set_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_search);


        mrecyclerView = findViewById(R.id.rv_horizanteal);

        mrecyclerView.setHasFixedSize(true);

        LinearLayoutManager mCLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mrecyclerView.setLayoutManager(mCLayoutManager);

        mHAdapter = new MyHorizontalAdapter(new String[]{"0", "1", "2", "3", "4", "5"}, this);
        mrecyclerView.setAdapter(mHAdapter);

        ImageView im_wishlist = findViewById(R.id.im_wishlist);
        ImageView im_cart = findViewById(R.id.im_cart);
        CardView c_addReview = findViewById(R.id.c_addReview);


        tv_add_cart = findViewById(R.id.tv_add_to_cart);
        lv_add_plus = findViewById(R.id.lv_add_plus);

         bt_more = findViewById(R.id.bt_more);
         bt_less = findViewById(R.id.bt_less);
         tv_set_count = findViewById(R.id.tv_set_count);
        tv_set_count.setText(count+"");

        bt_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tv_set_count.setText(count+"");

            }
        });
        bt_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(count>0)
                   count--;
                else
                    count=0;

                tv_set_count.setText(count+"");

            }
        });


        lv_add_plus.setVisibility(View.GONE);
        tv_add_cart.setVisibility(View.VISIBLE);
        tv_add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lv_add_plus.setVisibility(View.VISIBLE);
                tv_add_cart.setVisibility(View.GONE);

            }
        });


        im_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeSearch.this, WishlistActivity.class));


            }
        });

        im_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomsheet();

                // startActivity(new Intent(HomeSearch.this,HomeActivity.class));


            }
        });

        c_addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeSearch.this, AddReviewActivity.class));


            }
        });

        findViewById(R.id.activity_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CookieBar.dismiss(HomeSearch.this);
            }
        });


    }


    public void showBottomsheet() {

        CookieBar.build(HomeSearch.this)
                .setCustomView(R.layout.layout_review_bottom)
                .setCustomViewInitializer(new CookieBar.CustomViewInitializer() {
                    @Override
                    public void initView(View view) {

                        EditText editText = view.findViewById(R.id.et_wishlist);
                        ImageView im_close = view.findViewById(R.id.im_close);

                        im_close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                CookieBar.dismiss(HomeSearch.this);
                            }
                        });


                    }
                })
                .setAction("Close", new OnActionClickListener() {
                    @Override
                    public void onClick() {
                        CookieBar.dismiss(HomeSearch.this);
                    }
                })
                .setTitle("Add to wiashList")
                .setMessage("Add to wiashList")
                .setEnableAutoDismiss(false)
                .setSwipeToDismiss(false)
                .setCookiePosition(Gravity.BOTTOM)
                .show();


    }

}
