package com.sterlingryan.dental_care;

/**
 * Created by Gabriel on 25/04/2016.
 */
public class InformationPage {
    public int SectionId;
    public String Title;
    public String Description;
    public String ImageTop;
    public String FirstText;
    public String ImageMiddle;
    public String SecondText;
    public String ImageBottom;
    public String VideoLink;
    public int id;


    public InformationPage(String name, String content){
        Title = name;
        FirstText = content;
    }
}


