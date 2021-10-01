package com.example.befit_healthandfitnessapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link arm_beginner#newInstance} factory method to
 * create an instance of this fragment.
 */
public class arm_beginner extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public arm_beginner() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment arm_beginner.
     */
    // TODO: Rename and change types and number of parameters
    public static arm_beginner newInstance(String param1, String param2) {
        arm_beginner fragment = new arm_beginner();
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
        View view = inflater.inflate(R.layout.fragment_arm_beginner, container, false);
        ListView arm_beginner_exercises_lv = (ListView) view.findViewById(R.id.arm_beginner_exercises_lv);

        String[] arm_beginner_exercise_names = new String[] {
                "ARM RAISES \n 00:30" ,
                "SIDE ARM RAISE \n 00:30",
                "TRICEPS DIPS \n x10",
                "ARM CIRCLE CLOCKWISE \n 00:30",
                "DIAMOND PUSH-UPS \n x6",
                "JUMPING JACKS \n 00:30",
                "DIAGONAL PLANK \n x10",
                "PUNCHES \n 00:30",
                "PUSH-UPS \n X10",
                "INCHWORMS \n X8",
                "WALL PUSH-UPS \n X12"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.custom_list_view,R.id.textView1234,arm_beginner_exercise_names);
        arm_beginner_exercises_lv.setAdapter(adapter);
        return view;
    }

}
