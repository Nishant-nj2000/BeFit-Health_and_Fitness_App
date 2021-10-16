package com.example.befit_healthandfitnessapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link chest_beginner#newInstance} factory method to
 * create an instance of this fragment.
 */
public class chest_beginner extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public chest_beginner() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment chest_beginner.
     */
    // TODO: Rename and change types and number of parameters
    public static chest_beginner newInstance(String param1, String param2) {
        chest_beginner fragment = new chest_beginner();
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
        View view = inflater.inflate(R.layout.fragment_chest_beginner, container, false);
        ListView chest_beginner_exercises_lv = (ListView) view.findViewById(R.id.chest_beginner_exercises_lv);

        String[] chest_beginner_exercise_names = new String[] {
                "JUMPING JACKS \n 00:30" ,
                "INCLINE PUSH-UPS \n X16",
                "KNEE PUSH-UPS \n x12",
                "PUSH-UPS \n X10",
                "WIDE ARM PUSH-UPS \n x10",
                "BOX PUSH-UPS \n X12",
                "HINDU PUSH-UPS \n x10",
                "COBRA STRETCH \n 00:20",
                "CHEST STRETCH \n 00:20"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.custom_list_view,R.id.textView1234,chest_beginner_exercise_names);
        chest_beginner_exercises_lv.setAdapter(adapter);
        return  view;
    }
}