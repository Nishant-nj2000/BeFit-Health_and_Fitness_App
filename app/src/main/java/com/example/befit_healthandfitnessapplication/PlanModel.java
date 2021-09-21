package com.example.befit_healthandfitnessapplication;

public class PlanModel {
    
    private String plan_name;
    private int plan_image;

    public PlanModel(String plan_name,int plan_image) {
        this.plan_name = plan_name;
        this.plan_image = plan_image;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public int getPlan_image() {
        return plan_image;
    }

    public void setPlan_image(int plan_image) {
        this.plan_image = plan_image;
    }
}
