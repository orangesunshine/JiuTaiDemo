package com.jiutai.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.jiutai.demo.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRegisterLink(View view) {
        startActivity(new Intent(this, RegisterLinkActivity.class));
    }

    public void onReport(View view) {
        startActivity(new Intent(this, TeamProfitLossReportActivity.class));
    }
    public void onVipManager(View view) {
        startActivity(new Intent(this, VipManagerActivity.class));
    }

    public void onDaylyReport(View view) {
        startActivity(new Intent(this, DaylyReportActivity.class));
    }
}
