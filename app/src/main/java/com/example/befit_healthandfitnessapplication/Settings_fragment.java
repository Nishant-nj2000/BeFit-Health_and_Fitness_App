package com.example.befit_healthandfitnessapplication;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Settings_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Settings_fragment extends Fragment {
    DBHelper db;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Settings_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Settings_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Settings_fragment newInstance(String param1, String param2) {
        Settings_fragment fragment = new Settings_fragment();
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
        View view = inflater.inflate(R.layout.settings_fragment, container, false);
        TextView fullname_tv = (TextView) view.findViewById(R.id.fullname_field);
        TextView email_field = (TextView) view.findViewById(R.id.email_field);
        EditText email_tv = (EditText) view.findViewById(R.id.email_tv);
        EditText password_tv = (EditText) view.findViewById(R.id.password_tv);
        Button submit = (Button)view.findViewById(R.id.submit);


        SharedPreferences pref = getContext().getSharedPreferences("user", 0); // 0 - for private mode
        String userid = pref.getString("userid",null);


        db = new DBHelper(getContext());
        Cursor cursor = db.userdata(userid);

        if (cursor.moveToFirst()) {
            fullname_tv.setText("" + cursor.getString(1));
            password_tv.setText(""+ cursor.getString(4));
            email_field.setText(""+ cursor.getString(2));
            email_tv.setText(""+ cursor.getString(2));
            Log.i("value is",""+cursor);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String email = email_field.getText().toString();
               String password = password_tv.getText().toString();
               long val = db.update_user(userid,email,password);
                if(val>0)
                {
                    Toast.makeText(getContext(), "Profile Updated Successfully", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}