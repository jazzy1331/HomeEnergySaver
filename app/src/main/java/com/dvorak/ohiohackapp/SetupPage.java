package com.dvorak.ohiohackapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class SetupPage extends AppCompatActivity {

    private String SP_NAME = "cbushackpref";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_page);

        sp = getSharedPreferences(SP_NAME, Context.MODE_APPEND);
    }

    public void onCheckboxClicked(View view) {

        int id = view.getId();
        String selected = "";

        switch (id){
            case R.id.B1:
                selected = "B1";
                break;
            case R.id.B2:
                selected = "B2";
                break;
            case R.id.B3:
                selected = "B3";
                break;
            case R.id.B4:
                selected = "B4";
                break;
            case R.id.BM:
                selected = "BM";
                break;
            case R.id.DR:
                selected = "DR";
                break;
            case R.id.K:
                selected = "K";
                break;
            case R.id.LR:
                selected = "LR";
                break;
        }

        CheckBox cb1 = (CheckBox) view;
        SharedPreferences.Editor editor = sp.edit();

        String checkBoxResult = "T";
        if (!cb1.isChecked()) {
            checkBoxResult = "F";
        }
        editor.putString(selected, checkBoxResult);
        editor.apply();
    }

    public void onNextPageClicked(View view) {

        Intent intent = new Intent(this, SetupPage2.class);
        startActivity(intent);

    }
}
