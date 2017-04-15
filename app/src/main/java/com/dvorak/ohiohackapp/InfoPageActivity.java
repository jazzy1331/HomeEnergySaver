package com.dvorak.ohiohackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InfoPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
    }

    public void moreInfoClicked(View view){
        Intent intent = new Intent(this, MoreInfoActivity.class);
        startActivity(intent);
    }
}
