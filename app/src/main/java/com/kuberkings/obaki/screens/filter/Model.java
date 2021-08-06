package com.kuberkings.obaki.screens.filter;

public class Model {
    private String text;
    private int icon;
    private boolean isSelected = false;



    public Model(String text,int icon) {
        this.text = text;
        this.icon=icon;
    }

    public int getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public boolean isSelected() {
        return isSelected;
    }
}
