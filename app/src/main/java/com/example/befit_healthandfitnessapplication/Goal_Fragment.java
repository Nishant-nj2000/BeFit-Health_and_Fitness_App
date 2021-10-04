package com.example.befit_healthandfitnessapplication;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Goal_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Goal_Fragment extends Fragment {
    DBHelper db;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Goal_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Goal_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Goal_Fragment newInstance(String param1, String param2) {
        Goal_Fragment fragment = new Goal_Fragment();
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
        View v =  inflater.inflate(R.layout.goals_fragment, container, false);

        SharedPreferences pref = getContext().getSharedPreferences("user", 0); // 0 - for private mode
        String goal = pref.getString("goal",null);

        String [] values = {"---","1","2","3","4","5","6","7"};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner1);
        TextView textView1 = (TextView)v.findViewById(R.id.result_tv);
        Button save_goal = (Button) v.findViewById(R.id.save_goal);

        textView1.setText(goal);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int positions, long l) {
                String no_of_days = String.valueOf(spinner.getSelectedItem());
                if(spinner.getSelectedItem()!="---")
                {
                    textView1.setText(no_of_days);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        save_goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int no_of_days = Integer.parseInt(String.valueOf(textView1.getText()));
                    SharedPreferences pref = getContext().getSharedPreferences("user", 0); // 0 - for private mode
                    String userid = pref.getString("userid",null);
                    db = new DBHelper(getContext());
                    long val = db.set_goal(userid,no_of_days);
                    if(val>0)
                    {
                        SharedPreferences.Editor editor = getContext().getSharedPreferences("user", 0).edit();
                        editor.putString("goal", String.valueOf(no_of_days));
                        editor.apply();
                        Toast.makeText(getContext(), "Goal Saved for "+no_of_days+" training per week.", Toast.LENGTH_LONG).show();
                    }

                    try {
                        long val2 = db.update_goal(userid,no_of_days);
                        if(val2>0)
                        {
                            SharedPreferences.Editor editor = getContext().getSharedPreferences("user", 0).edit();
                            editor.putString("goal", String.valueOf(no_of_days));
                            editor.apply();
                            Toast.makeText(getContext(), "Goal Updated to "+no_of_days+" days training per week.", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (NumberFormatException e) {

                }

            }
        });

//        spinner.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Dialog d = new Dialog(getContext());
//                d.setContentView(R.layout.dialog);
//                NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
//                Button b1 = (Button) d.findViewById(R.id.cancel);
//                Button b2 = (Button) d.findViewById(R.id.ok);
//                np.setMaxValue(7);
//                np.setMinValue(1);
//                d.show();
//                b1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        d.dismiss();
//                    }
//                });
//                b2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        int pickedValue = np.getValue();
//                        textView1.setText(Integer.toString(pickedValue));
//                        d.dismiss();
//                    }
//                });
//                return true;
//            }
//        });
        return v;

    }
}