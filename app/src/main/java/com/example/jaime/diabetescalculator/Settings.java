package com.example.jaime.diabetescalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.jaime.diabetescalculator.com.example.jaime.diabetescalculator.domain.UserSettings;

import java.util.Locale;

public class Settings extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = this.getSharedPreferences("com.example.jaime.diabetescalculator", Context.MODE_PRIVATE);

        setContentView(R.layout.activity_settings);

        setSettingsValues();


    }

    private void setSettingsValues() {

        UserSettings userSettings = new UserSettings(sharedPreferences);

        Log.i("Info",Float.toString(userSettings.getBreakfastRatio()));

        EditText breakfastRatioText = findViewById(R.id.breakfastRatioId);

        Log.i("Info",breakfastRatioText.toString());
        breakfastRatioText.setText(Float.toString(userSettings.getBreakfastRatio()));

        EditText lunchRatioText = findViewById(R.id.lunchRatioId);
        lunchRatioText.setText(Float.toString(userSettings.getLunchRatio()));

        EditText dinnerRatioText = findViewById(R.id.dinnerRatioId);
        dinnerRatioText.setText(Float.toString(userSettings.getDinnerRatio()));


        EditText supperRatioText = findViewById(R.id.supperRatioId);
        supperRatioText.setText(Float.toString(userSettings.getSupperRatio()));

        EditText targetBloodLevelText = findViewById(R.id.targetBloodId);
        targetBloodLevelText.setText(Float.toString(userSettings.getTargetBloodLevel()));



        EditText correctionFactorText = findViewById(R.id.correctionFactorId);
        correctionFactorText.setText(Float.toString(userSettings.getCorrectionFactor()));


    }



    public void saveSettings(View view){

        UserSettings userSettings = new UserSettings(sharedPreferences);

        EditText breakfastRatioText = findViewById(R.id.breakfastRatioId);
        userSettings.setBreakfastRatio(Float.parseFloat(breakfastRatioText.getText().toString()));

        EditText lunchRatioText = findViewById(R.id.lunchRatioId);
        userSettings.setLunchRatio(Float.parseFloat(lunchRatioText.getText().toString()));

        EditText dinnerRatioText = findViewById(R.id.dinnerRatioId);
        userSettings.setDinnerRatio(Float.parseFloat(dinnerRatioText.getText().toString()));

        EditText supperRatioText = findViewById(R.id.supperRatioId);
        userSettings.setSupperRatio(Float.parseFloat(supperRatioText.getText().toString()));

        EditText targetBloodLevelText = findViewById(R.id.targetBloodId);
        userSettings.setTargetBloodLevel(Float.parseFloat(targetBloodLevelText.getText().toString()));

        EditText correctionFactorText = findViewById(R.id.correctionFactorId);
        userSettings.setCorrectionFactor(Float.parseFloat(correctionFactorText.getText().toString()));

        Intent intent = new Intent(this,MainCalculator.class);
        startActivity(intent);

    }

}
