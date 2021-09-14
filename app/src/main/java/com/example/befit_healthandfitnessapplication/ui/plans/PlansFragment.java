package com.example.befit_healthandfitnessapplication.ui.plans;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.befit_healthandfitnessapplication.R;
import com.example.befit_healthandfitnessapplication.databinding.FragmentHomeBinding;

public class PlansFragment extends Fragment {

    private PlansViewModel plansViewModel;
    private FragmentHomeBinding binding;

    public static PlansFragment newInstance() {
        return new PlansFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.plans_fragment, container, false);
    }



}