package com.example.jaime.diabetescalculator.com.example.jaime.diabetescalculator.domain;

/**
 * Created by Jaime on 27-Jan-18.
 */

public class InsulinCalculator {

    private UserSettings userSettings;

    private String mealTime;

    private float bloodGlucose;

    private float carbs;


    public InsulinCalculator(UserSettings userSettings, String mealTime, float bloodGlucose, float carbs) {
        this.userSettings = userSettings;
        this.mealTime = mealTime;
        this.bloodGlucose = bloodGlucose;
        this.carbs = carbs;
    }






    public float calculateUnitsOfInsulin() {

        float unitsOfInsulin = (float)0.0;

        float correctionDose = (float)0.0;

        float mealRatio;

        switch  (mealTime) {

            case "Breakfast":
                mealRatio = userSettings.getBreakfastRatio();
                break;
            case "Lunch" :
                mealRatio = userSettings.getLunchRatio();
                break;
            case "Dinner" :
                mealRatio = userSettings.getDinnerRatio();
                break;
            case "Supper" :
                mealRatio = userSettings.getSupperRatio();
                break;
            default:
                mealRatio = 0;
        }

        if(mealRatio == 0)
            return 0;

        unitsOfInsulin = carbs / mealRatio ;

        if(bloodGlucose > 8.0)
        {
            correctionDose = (bloodGlucose - userSettings.getTargetBloodLevel()) / userSettings.getCorrectionFactor();
        }

        unitsOfInsulin = unitsOfInsulin + correctionDose;

        return unitsOfInsulin;
    }





}
