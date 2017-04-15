package com.dvorak.ohiohackapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;

public class SetupPage2 extends AppCompatActivity {

    private String SP_NAME = "cbushackpref";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_page2);

        sp = getSharedPreferences(SP_NAME, Context.MODE_APPEND);

    }

    public void goToMainPage(View view) {

        SharedPreferences.Editor editor = sp.edit();

        EditText et = (EditText) findViewById(R.id.enteredPrice);
        String text = et.getText().toString();

        if (((RadioButton) findViewById(R.id.enteredPriceOption)).isChecked()) {
            editor.putString("price", text);
            editor.apply();
        } else {
            editor.putString("price", ".12");
            editor.apply();
        }

        EditText goal = (EditText) findViewById(R.id.goalEnter);
        String goalText = goal.getText().toString();

        editor.putString("goal", goalText);
        editor.apply();

        if (((RadioButton) findViewById(R.id.yesSolar)).isChecked()) {
            editor.putString("solar", "T");
            editor.apply();
        } else {
            editor.putString("solar", "F");
            editor.apply();
        }


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
