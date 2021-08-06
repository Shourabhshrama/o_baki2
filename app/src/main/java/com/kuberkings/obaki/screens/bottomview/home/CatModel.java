package com.kuberkings.obaki.screens.bottomview.home;

public class CatModel {
    String name;
    int icon;

    public CatModel(String name,int icon) {
        this.name = name;
        this.icon=icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
