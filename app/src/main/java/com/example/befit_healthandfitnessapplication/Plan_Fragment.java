package com.example.befit_healthandfitnessapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Plan_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Plan_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Plan_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Plan_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Plan_Fragment newInstance(String param1, String param2) {
        Plan_Fragment fragment = new Plan_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    Intent intent;
    private ArrayList<PlanModel> planModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.plans_fragment, container, false);

//        RecyclerView planRV = view.findViewById(R.id.idRVPlan);
//        planModelArrayList = new ArrayList<>();
//        planModelArrayList.add(new PlanModel("BEGINNER",R.drawable.beginner));
//        planModelArrayList.add(new PlanModel("INTERMEDIATE",R.drawable.intermediate));
//        planModelArrayList.add(new PlanModel("ADVANCED",R.drawable.advanced));
//
//        PlanAdapter planAdapter = new PlanAdapter(this, planModelArrayList);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Plan_Fragment.this,LinearLayoutManager.VERTICAL,false);
//        planRV.setLayoutManager(linearLayoutManager);
//        planRV.setAdapter(planAdapter);

        final CardView cardview1 = (CardView) view.findViewById(R.id.first);
        final CardView cardview2 = (CardView) view.findViewById(R.id.second);
        final CardView cardview3 = (CardView) view.findViewById(R.id.third);

        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Beginner_Exercises beginner_exercises = new Beginner_Exercises();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer,beginner_exercises,"null");
                fragmentTransaction.addToBackStack("null");
                fragmentTransaction.commit();

            }
        });

        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intermediate_Exercises intermediate_exercises = new Intermediate_Exercises();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer,intermediate_exercises,"null");
                fragmentTransaction.addToBackStack("null");
                fragmentTransaction.commit();

            }
        });

        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Advanced_Exercises advanced_exercises = new Advanced_Exercises();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer,advanced_exercises,"null");
                fragmentTransaction.addToBackStack("null");
                fragmentTransaction.commit();

            }
        });


            return  view;
    }
}