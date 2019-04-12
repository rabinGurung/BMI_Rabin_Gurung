package com.example.body_mass_index_rabin_gurung.Presenter;

import android.view.View;

import com.example.body_mass_index_rabin_gurung.MainActivity;

import java.util.Calendar;

public class Presenter {
    private MainActivity mainActivity;

    public Presenter(final MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        mainActivity.btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.CheckForInput();
                float value = Calcualate(mainActivity.getHeight(),mainActivity.getWeight());
                mainActivity.setResult(Float.toString(value));
                mainActivity.setToast(Status(value));
            }
        });
    }


    public float Calcualate( float height, float weight){
        height = height / 100; // coverting into meters
        float base = height * height;
        return weight / base;
    }


    public String Status(Float value) {

        if (value < 18.5) {
            return "Underweight";
        } else if (value > 18.5 && value < 24.5) {
            return "Normal Weight";
        } else if (value > 24.54 && value < 29.9) {
            return "Overweight";
        }else
        return "Obsesity";
    }
}
