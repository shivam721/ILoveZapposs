package com.example.BitStat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.my_image_view);
        imageView.setImageResource(R.drawable.bitcoin);
//-------------------Showthe statistics start here....

        Button   Showthestatistics = (Button) findViewById(R.id.Showthestatistics);
        Showthestatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
OpenStatScreen();
            }


        });

//-------------------Showthe statistics ends here.....

        Button   BidvsAsk = (Button) findViewById(R.id.BidvsAsk);
        BidvsAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenBidVsAsk();
            }


        });







    }
    public void OpenStatScreen() {



        Intent intent;
        intent = new Intent(this,Statistics.class);

        startActivity(intent);
    }



//-------------------Showthe statistics ends here.....





    public void OpenBidVsAsk() {

System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        Intent intent;
        intent = new Intent(this,askToBid.class);

        startActivity(intent);
    }



}












