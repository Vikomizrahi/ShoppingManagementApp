package com.example.shoppingmanagementapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingmanagementapp.R;
import com.example.shoppingmanagementapp.activitys.Item;
import com.example.shoppingmanagementapp.activitys.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentLogin extends Fragment {

    private static final String ARG_USERNAME = "username";
    private String username;

    public FragmentLogin() {
        // Required empty public constructor
    }

    public static FragmentLogin newInstance(String username) {
        FragmentLogin fragment = new FragmentLogin();
        Bundle args = new Bundle();
        args.putString(ARG_USERNAME, username);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString(ARG_USERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);



        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Bamba", R.drawable.bamba));
        items.add(new Item("Bisli", R.drawable.bisli));
        items.add(new Item("Bira corona", R.drawable.bira));
        items.add(new Item("Light bird", R.drawable.bird));
        items.add(new Item("Coca cola", R.drawable.cola));
        items.add(new Item("Milk", R.drawable.milk));
        items.add(new Item("Chocolate milk", R.drawable.shoko));


        recyclerView.setAdapter(new MyAdapter(getContext(), items));

        return view;
    }
}