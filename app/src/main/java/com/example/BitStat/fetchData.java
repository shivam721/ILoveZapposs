package com.example.BitStat;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.Gson;

public class fetchData extends AsyncTask<Void,Void,Void> {
String data = "";




    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url = new URL("https://www.bitstamp.net/api/v2/ticker_hour/btcusd/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String lines = "" ;

            //  lines = bufferedReader.readLine();
            while(lines!= null)
            {
                lines = bufferedReader.readLine();

                data = data + lines ;

            }
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        catch (java.io.IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.data);




    }
}
