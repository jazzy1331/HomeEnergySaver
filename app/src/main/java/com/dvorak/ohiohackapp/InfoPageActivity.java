package com.dvorak.ohiohackapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoPageActivity extends AppCompatActivity {

    private String SP_NAME = "cbushackpref";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        TextView daily = (TextView) (findViewById(R.id.textView3));
        TextView avg = (TextView) (findViewById(R.id.textView2));

        sp = getSharedPreferences(SP_NAME, Context.MODE_APPEND);
        double rate = Double.parseDouble(sp.getString("price", "0"));

        String kwhUsageStr = sp.getString("daily", "0");
        double kwhUsageDub = Double.parseDouble(kwhUsageStr);

        daily.setText("Today's Usage: " + kwhUsageStr + "  |  $" + String.format("%.2f", (kwhUsageDub * rate)));
        avg.setText("Daily Average: " + kwhUsageStr + "  |  $" + String.format("%.2f", (kwhUsageDub * rate)));



    }

    public void moreInfoClicked(View view) {
        Intent intent = new Intent(this, MoreInfoActivity.class);
        startActivity(intent);
    }
}
