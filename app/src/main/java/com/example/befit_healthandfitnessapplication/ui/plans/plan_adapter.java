package com.example.befit_healthandfitnessapplication.ui.plans;

import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.arch.core.executor.TaskExecutor;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class plan_adapter extends RecyclerView.Adapter<plan_adapter.ViewHolder> {
   private Context context;
   private List<plans> myplans;

   static class ViewHolder extends RecyclerView.ViewHolder{
       CardView cardView;
       ImageView planImage;
       TextView nameofplan;

       ViewHolder(View itemView) {
           super(itemView);
           cardView = (CardView) itemView;

       }
   }
    public plan_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull plan_adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
