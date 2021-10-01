package com.example.befit_healthandfitnessapplication;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Intermediate_Exercises#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Intermediate_Exercises extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Intermediate_Exercises() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Intermediate_Exercises.
     */
    // TODO: Rename and change types and number of parameters
    public static Intermediate_Exercises newInstance(String param1, String param2) {
        Intermediate_Exercises fragment = new Intermediate_Exercises();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intermediate__exercises, container, false);

        final CardView arm_intermediatecv = (CardView) view.findViewById(R.id.arm_intermediate);
        final CardView chest_intermediatecv = (CardView) view.findViewById(R.id.chest_intermediate);
        final CardView leg_intermediatecv = (CardView) view.findViewById(R.id.leg_intermediate);
        final CardView abs_intermediatecv = (CardView) view.findViewById(R.id.abs_intermediate);

        arm_intermediatecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arm_intermediate arm_intermediate = new arm_intermediate();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer, arm_intermediate,"arm_intermediate");
                fragmentTransaction.addToBackStack("arm_intermediate");
                fragmentTransaction.commit();
            }
        });

        chest_intermediatecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chest_intermediate chest_intermediate = new chest_intermediate();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer, chest_intermediate,"chest_intermediate");
                fragmentTransaction.addToBackStack("chest_intermediate");
                fragmentTransaction.commit();

            }
        });

        leg_intermediatecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leg_intermediate leg_intermediate = new leg_intermediate();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer, leg_intermediate,"leg_intermediate");
                fragmentTransaction.addToBackStack("leg_intermediate");
                fragmentTransaction.commit();

            }
        });

        abs_intermediatecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abs_intermediate abs_intermediate = new abs_intermediate();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer, abs_intermediate,"abs_intermediate");
                fragmentTransaction.addToBackStack("abs_intermediate");
                fragmentTransaction.commit();

            }
        });

        return view;
    }
}