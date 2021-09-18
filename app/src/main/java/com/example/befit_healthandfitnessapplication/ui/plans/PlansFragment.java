package com.example.befit_healthandfitnessapplication.ui.plans;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.befit_healthandfitnessapplication.BeginnerExercises;
import com.example.befit_healthandfitnessapplication.MainActivity;
import com.example.befit_healthandfitnessapplication.R;
import com.example.befit_healthandfitnessapplication.navigation_drawer;

import java.util.ArrayList;

public class PlansFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private ListAdapter mListadapter;

    public static PlansFragment newInstance() {
        return new PlansFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plans_fragment,container,false);
//        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        return inflater.inflate(R.layout.plans_fragment, container, false);

    }



}