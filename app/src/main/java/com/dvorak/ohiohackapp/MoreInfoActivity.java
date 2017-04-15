package com.dvorak.ohiohackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.dvorak.ohiohackapp.R.id.textView;

public class MoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        TextView waterHeating = (TextView) (findViewById(R.id.textView17));
        TextView airCoolingHeating = (TextView)(findViewById(R.id.textView15));

        int rate = 0;
        waterHeating.setText("Water Heating: 14.46 kWh / $" + 14.46 * rate);
        airCoolingHeating.setText("Air Heating and Cooling: 7.75kWh / $" + 7.75 * rate);
    }
}
