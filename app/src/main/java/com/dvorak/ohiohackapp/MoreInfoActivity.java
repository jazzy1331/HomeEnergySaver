package com.dvorak.ohiohackapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.dvorak.ohiohackapp.R.id.textView;

public class MoreInfoActivity extends AppCompatActivity {


    private String SP_NAME = "cbushackpref";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        changeStuff();

    }


    public void changeStuff() {

        sp = getSharedPreferences(SP_NAME, Context.MODE_APPEND);

        double rate = Double.parseDouble(sp.getString("price", "0"));

        double kwhUsageDub = 0.0;
        String kwhUsageStr = "";


        TextView waterHeating = (TextView) (findViewById(R.id.textView17));
        TextView airCoolingHeating = (TextView) (findViewById(R.id.textView15));
        TextView livingRoom = (TextView) (findViewById(R.id.textView9));
        TextView kitchen = (TextView) (findViewById(R.id.textView10));
        TextView diningRoom = (TextView) (findViewById(R.id.textView11));
        TextView masterBedroom = (TextView) (findViewById(R.id.textView12));
        TextView bedroom1 = (TextView) (findViewById(R.id.textView14));
        TextView bedroom2 = (TextView) (findViewById(R.id.textView19));
        TextView bedroom3 = (TextView) (findViewById(R.id.textView21));
        TextView bedroom4 = (TextView) (findViewById(R.id.textView13));


        DecimalFormat format = new DecimalFormat("#0.00");

        waterHeating.setText("Water Heating: 14.46 kWh | $" + String.format("%.2f", (14.46 * rate)));
        airCoolingHeating.setText("Air Heating and Cooling: 7.75kWh | $" + String.format("%.2f", (7.75 * rate)));


        kwhUsageStr = sp.getString("LRcurrent", "0");
        kwhUsageDub = Double.parseDouble(kwhUsageStr);
        livingRoom.setText("Living Room: " + kwhUsageStr + "kWh  | $" + String.format("%.2f", (kwhUsageDub * rate)));

        kwhUsageStr = sp.getString("Kcurrent", "0");
        kwhUsageDub = Double.parseDouble(kwhUsageStr);
        kitchen.setText("Kitchen: " + kwhUsageStr + "kWh  | $" + String.format("%.2f", (kwhUsageDub * rate)));

        kwhUsageStr = sp.getString("DRcurrent", "0");
        kwhUsageDub = Double.parseDouble(kwhUsageStr);
        diningRoom.setText("Dining Room: " + kwhUsageStr + "kWh  | $" + String.format("%.2f", (kwhUsageDub * rate)));

        kwhUsageStr = sp.getString("BMcurrent", "0");
        kwhUsageDub = Double.parseDouble(kwhUsageStr);
        masterBedroom.setText("Master Bedroom: " + kwhUsageStr + "kWh  | $" + String.format("%.2f", (kwhUsageDub * rate)));

        kwhUsageStr = sp.getString("B1current", "0");
        kwhUsageDub = Double.parseDouble(kwhUsageStr);
        bedroom1.setText("Bedroom 1: " + kwhUsageStr + "kWh  | $" + String.format("%.2f", (kwhUsageDub * rate)));

        kwhUsageStr = sp.getString("B2current", "0");
        kwhUsageDub = Double.parseDouble(kwhUsageStr);
        bedroom2.setText("Bedroom 2: " + kwhUsageStr + "kWh  | $" + String.format("%.2f", (kwhUsageDub * rate)));

        kwhUsageStr = sp.getString("B3current", "0");
        kwhUsageDub = Double.parseDouble(kwhUsageStr);
        bedroom3.setText("Bedroom 3: " + kwhUsageStr + "kWh  | $" + String.format("%.2f", (kwhUsageDub * rate)));

        kwhUsageStr = sp.getString("B4current", "0");
        kwhUsageDub = Double.parseDouble(kwhUsageStr);
        bedroom4.setText("Bedroom 4: " + kwhUsageStr + "kWh  | $" + String.format("%.2f", (kwhUsageDub * rate)));

    }


}
