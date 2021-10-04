package com.example.befit_healthandfitnessapplication;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link arm_beginner#newInstance} factory method to
 * create an instance of this fragment.
 */
public class arm_beginner extends Fragment{

    private static final long START_TIME_IN_MILIS = 600000;
    private CountDownTimer countDownTimer;
    private  boolean mTimerRunning;
    private long mTimeLeftInMilis = START_TIME_IN_MILIS;
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

        arm_beginner_exercises_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    beginner_click();

            }
        });


        return view;
    }

    private void beginner_click() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        Button cancel  = (Button) dialog.findViewById(R.id.cancel);
        Button start  = (Button) dialog.findViewById(R.id.start);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                        mTimerRunning = false;
                        start.setText("Start");
                        cancel.setVisibility(View.INVISIBLE);
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }


    private void pauseTimer() {
    }


}
