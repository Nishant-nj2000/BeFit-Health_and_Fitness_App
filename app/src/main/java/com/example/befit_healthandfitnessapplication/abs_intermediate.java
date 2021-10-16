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
 * Use the {@link abs_intermediate#newInstance} factory method to
 * create an instance of this fragment.
 */
public class abs_intermediate extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public abs_intermediate() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment abs_intermediate.
     */
    // TODO: Rename and change types and number of parameters
    public static abs_intermediate newInstance(String param1, String param2) {
        abs_intermediate fragment = new abs_intermediate();
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
        View view = inflater.inflate(R.layout.fragment_abs_intermediate, container, false);
        ListView abs_intermediate_exercises_lv = (ListView) view.findViewById(R.id.abs_intermediate_exercises_lv);

        String[] abs_intermediate_exercise_names = new String[] {
                "JUMPING JACKS \n 00:30",
                "HEEL TOUCH \n x26",
                "CROSSOVER CRUNCH \n x20",
                "MOUNTAIN CLIMBER \n X20",
                "SIDE BRIDGES \n X16",
                "BUTT BRIDGE \n X20",
                "BICYCLE CRUNCHES \n X20",
                "ABDOMINAL CRUNCHES \n X20",
                "PLANK \n 00:20",
                "LEG RAISES \n X16",
                "PUSH-UP & ROTATION \n x20",
                "SIDE PLANK \n 00:20",
                "COBRA STRETCH \n 00:30"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.custom_list_view,R.id.textView1234,abs_intermediate_exercise_names);
        abs_intermediate_exercises_lv.setAdapter(adapter);
        return view;
    }
}