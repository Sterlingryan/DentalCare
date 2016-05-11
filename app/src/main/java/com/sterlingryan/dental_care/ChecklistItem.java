package com.sterlingryan.dental_care;

/**
 * Created by Gabriel on 11/05/2016.
 */
public class ChecklistItem {
    public boolean IsChecked;
    public String Text;

    public ChecklistItem(String text){
        IsChecked = false;
        Text = text;
    }
}
