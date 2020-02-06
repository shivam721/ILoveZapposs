package com.example.BitStat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Statistics extends AppCompatActivity {
    BarChart barChart;

    Price p;
    private LineChart mchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);




        barChart = (BarChart) findViewById(R.id.barchart);
barChart.setDrawBarShadow(false);
barChart.setDrawValueAboveBar(true);
barChart.setMaxVisibleValueCount(10000);
barChart.setPinchZoom(false);
barChart.setDrawGridBackground(true);

        ArrayList<BarEntry> barEntries = new ArrayList<>();



        barEntries.add(new BarEntry(63,9227f));

        barEntries.add(new BarEntry(47,9240f));

        barEntries.add(new BarEntry(76,9227f));

        barEntries.add(new BarEntry(19,9225f));
        barEntries.add(new BarEntry(94,9222f));

        barEntries.add(new BarEntry(44,9213f));
        barEntries.add(new BarEntry(44,9239f));

        barEntries.add(new BarEntry(72,9240f));
        barEntries.add(new BarEntry(79,9226f));

        barEntries.add(new BarEntry(76,9230f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Data Set1");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(barDataSet);
        data.setBarWidth(4f);
        barChart.setData(data);

     //   barChart.setTouchEnabled(true);
      //  barChart.setDragEnabled(true);
     //   barChart.setScaleEnabled(true);















        Button Showthedistribution = (Button) findViewById(R.id.Showthedistribution);
        Showthedistribution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpendistributionScreen();
            }


        });




    }

    public void OpendistributionScreen()
    {



        Intent intent;
        intent = new Intent(this,distribution.class);

        startActivity(intent);
    }



    }


