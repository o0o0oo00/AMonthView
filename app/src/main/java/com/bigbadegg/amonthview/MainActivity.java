package com.bigbadegg.amonthview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.ll_root);
        for (int i = 0; i <= 11; i++) {
            CalendarMonthView calendarMonthView = new CalendarMonthView(this);
            calendarMonthView.updateData(2017, i);

            linearLayout.addView(calendarMonthView);
        }
    }
}
