package com.sterlingryan.dental_care;

/**
 * Created by Gabriel on 10/05/2016.
 */
public class InformationPageHolder {

    //TYPE: NORMAL
    public boolean IsNormal;
    public int N_SectionId;
    public String N_Title;
    public String N_Description;
    public String N_ImageTop;
    public String N_FirstText;
    public String N_ImageMiddle;
    public String N_SecondText;
    public String N_ImageBottom;
    public String N_VideoLink;

    //TYPE: VIDEO
    public boolean IsVideo;
    public int V_SectionId;
    public String V_Title;
    public String V_VideoLink;
    public String V_Description;

    //TYPE: CHECKLIST
    public boolean IsChecklist;
    public int C_SectionId;
    public String C_Title;
    public String C_Desc;
    public String C_Step1;
    public String C_Step2;
    public String C_Step3;


    public InformationPageHolder(InformationPage source){
        IsNormal = true;
        N_SectionId = source.SectionId;
        N_Title = source.Title;
        N_Description = source.Description;
        N_ImageTop = source.ImageTop;
        N_FirstText = source.FirstText;
        N_ImageMiddle = source.ImageMiddle;
        N_SecondText = source.SecondText;
        N_ImageBottom = source.ImageBottom;
        N_VideoLink = source.VideoLink;
    }

    public InformationPageHolder(InformationPageVideo source){
        IsVideo = true;
        V_SectionId = source.SectionId;
        V_Title = source.Title;
        V_VideoLink = source.VideoLink;
        V_Description = source.Description;
    }

    public InformationPageHolder(InformationPageProcedure source){
        IsChecklist = true;
        C_SectionId = source.SectionId;
        C_Desc = source.Description;
        C_Title = source.Title;
        C_Step1 = source.Step1;
        C_Step2 = source.Step2;
        C_Step3 = source.Step3;
    }
}
