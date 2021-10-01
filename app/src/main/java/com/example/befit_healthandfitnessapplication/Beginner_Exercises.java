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
 * Use the {@link Beginner_Exercises#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Beginner_Exercises extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Beginner_Exercises() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Beginner_Exercises.
     */
    // TODO: Rename and change types and number of parameters
    public static Beginner_Exercises newInstance(String param1, String param2) {
        Beginner_Exercises fragment = new Beginner_Exercises();
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
        View view = inflater.inflate(R.layout.fragment_beginner__exercises, container, false);

        final CardView arm_beginnercv = (CardView) view.findViewById(R.id.arm_beginner);
        final CardView chest_beginnercv = (CardView) view.findViewById(R.id.chest_beginner);
        final CardView leg_beginnercv = (CardView) view.findViewById(R.id.leg_beginner);
        final CardView abs_beginnercv = (CardView) view.findViewById(R.id.abs_beginner);

        arm_beginnercv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arm_beginner arm_beginner = new arm_beginner();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer, arm_beginner,"arm_beginner");
                fragmentTransaction.addToBackStack("arm_beginner");
                fragmentTransaction.commit();
            }
        });

        chest_beginnercv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chest_beginner chest_beginner = new chest_beginner();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer, chest_beginner,"chest_beginner");
                fragmentTransaction.addToBackStack("chest_beginner");
                fragmentTransaction.commit();

            }
        });

        leg_beginnercv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leg_beginner leg_beginner = new leg_beginner();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer, leg_beginner,"leg_beginner");
                fragmentTransaction.addToBackStack("leg_beginner");
                fragmentTransaction.commit();

            }
        });

        abs_beginnercv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abs_beginner abs_beginner = new abs_beginner();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_navigation_drawer, abs_beginner,"abs_beginner");
                fragmentTransaction.addToBackStack("abs_beginner");
                fragmentTransaction.commit();

            }
        });


        return view;
    }
}