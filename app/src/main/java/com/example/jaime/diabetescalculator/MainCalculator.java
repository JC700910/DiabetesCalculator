package com.example.jaime.diabetescalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jaime.diabetescalculator.com.example.jaime.diabetescalculator.domain.InsulinCalculator;
import com.example.jaime.diabetescalculator.com.example.jaime.diabetescalculator.domain.UserSettings;

public class MainCalculator extends AppCompatActivity {


    SharedPreferences sharedPreferences;



    public void calcInsulin (View view){

        UserSettings userSettings = new UserSettings(sharedPreferences);


        Spinner mealTimeSpinner = findViewById(R.id.mealTimeSpinnerId);

        EditText bloodGlucoseId = findViewById(R.id.bloodGlucoseId);

        EditText carbsId = findViewById(R.id.carbsId);


        String mealTime = String.valueOf(mealTimeSpinner.getSelectedItem());

        float bloodGlucose =  Float.parseFloat(bloodGlucoseId.getText().toString());

        float  carbs =  Float.parseFloat(carbsId.getText().toString());


        InsulinCalculator insulinCalculator = new InsulinCalculator(userSettings, mealTime, bloodGlucose, carbs);

        float unitsOfInsulin = insulinCalculator.calculateUnitsOfInsulin();

        TextView insulinDose = findViewById(R.id.insulinDoseId);

        insulinDose.setText(unitsOfInsulin + " units");
        //Log.i("Info","Number of Units is "+ unitsOfInsulin);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        sharedPreferences = this.getSharedPreferences("com.example.jaime.diabetescalculator", Context.MODE_PRIVATE);

        setContentView(R.layout.activity_main_calculator);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        Intent intent;

        switch (item.getItemId()) {
            case R.id.settings:

                 intent = new Intent(this,Settings.class);
                startActivity(intent);
                return true;
            case R.id.help:
                Log.i("Menu","Help");//need to go to page
                return true;
            case R.id.about:
                 intent = new Intent(this,About.class);
                startActivity(intent);
                return true;
                default:
                 return false;
        }
    }
}

