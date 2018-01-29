package com.example.jaime.diabetescalculator.com.example.jaime.diabetescalculator.domain;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jaime on 27-Jan-18.
 */

public class UserSettings {

     private SharedPreferences sharedPreferences;



    public UserSettings(SharedPreferences sharedPreferences) {

        this.sharedPreferences = sharedPreferences;


        }


    public float getCorrectionFactor() {
            return sharedPreferences.getFloat("correctionFactor",0.0f);
        }

    public void setCorrectionFactor(float correctionFactor) {
            sharedPreferences.edit().putFloat("correctionFactor",correctionFactor).apply();
        }


    public float getTargetBloodLevel() {
            return  sharedPreferences.getFloat("targetBloodLevel",0.0f);
        }

    public void setTargetBloodLevel(float targetBloodLevel) {
        sharedPreferences.edit().putFloat("targetBloodLevel",targetBloodLevel).apply();
    }



    public float getBreakfastRatio() {
        return  sharedPreferences.getFloat("breakfastRatio",0.0f);
    }

    public void setBreakfastRatio(float breakfastRatio) {
        sharedPreferences.edit().putFloat("breakfastRatio",breakfastRatio).apply();
    }


    public float getLunchRatio() {
        return  sharedPreferences.getFloat("lunchRatio",0.0f);
    }

    public void setLunchRatio(float lunchRatio) {
        sharedPreferences.edit().putFloat("lunchRatio",lunchRatio).apply();
    }


    public float getDinnerRatio() {
        return  sharedPreferences.getFloat("dinnerRatio",0.0f);
    }

    public void setDinnerRatio(float dinnerRatio) {
        sharedPreferences.edit().putFloat("dinnerRatio",dinnerRatio).apply();
    }


    public float getSupperRatio() {
        return  sharedPreferences.getFloat("supperRatio",0.0f);
    }

    public void setSupperRatio(float supperRatio) {
        sharedPreferences.edit().putFloat("supperRatio",supperRatio).apply();
    }


}





