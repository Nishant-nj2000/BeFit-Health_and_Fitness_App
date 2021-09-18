package com.example.befit_healthandfitnessapplication.ui.plans;

public class plans {
    private String nameofplan;
    private int imageId;

    public plans (String nameofplan, int imageId){
        this.nameofplan = nameofplan;
        this.imageId = imageId;
    }
    public String getPlanName() {
        return nameofplan;
    }

    int getImageId() {
        return imageId;
    }

}
