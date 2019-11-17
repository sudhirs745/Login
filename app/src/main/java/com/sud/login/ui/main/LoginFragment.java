package com.sud.login.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sud.login.HomeActivity;
import com.sud.login.ForgotActivity;
import com.sud.login.HomeSearch;
import com.sud.login.R;

public class LoginFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";



    public static LoginFragment newInstance(int index) {
        LoginFragment fragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_login, container, false);

        TextView tv_login =root. findViewById(R.id.tv_login);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity( new Intent(getActivity(), HomeSearch.class));
            }
        });

        TextView tv_forgot = root.findViewById(R.id.tv_forgot);

        tv_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity( new Intent(getActivity(), ForgotActivity.class));
            }
        });


        return root;
    }
}