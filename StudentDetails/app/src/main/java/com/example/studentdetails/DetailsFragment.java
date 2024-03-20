package com.example.studentdetails;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    String[] name = {"kshitij", "kumar", "Prince", "weathercast", "musical", "foodworld", "notable"};
    String[] section = {"8CSE1", "8CSE2", "8CSE3", "8CSE8", "8CSE9", "8CSE5", "8CSE7"};
    TextView rs;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        rs = v.findViewById(R.id.result);
        return v;
    }

    public void change(int position) {

        rs.setText("Name: " + name[position] + "\nSection Name: " + section[position]);
    }
}