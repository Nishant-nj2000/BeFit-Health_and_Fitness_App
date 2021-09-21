package com.example.befit_healthandfitnessapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlanAdapter {
    private Plan_Fragment context;
    private ArrayList<PlanModel> planModelArrayList;

    public PlanAdapter(Plan_Fragment context, ArrayList<PlanModel> planModelArrayList) {
        this.context = context;
        this.planModelArrayList = planModelArrayList;
    }

    @NonNull
    public PlanAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        return new Viewholder(view);
    }


    public void onBindViewHolder(@NonNull PlanAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        PlanModel model = planModelArrayList.get(position);
        holder.planName.setText(model.getPlan_name());
        holder.planIV.setImageResource(model.getPlan_image());
    }

    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return planModelArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        private ImageView planIV;
        private TextView planName;

        public Viewholder(View itemview) {
            super(itemview);
            planIV = itemview.findViewById(R.id.idIVPlanImage);
            planName = itemview.findViewById(R.id.idTVPlanName);

        }
    }
}
