package com.example.BitStat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class askToBid extends AppCompatActivity {




    String url = "https://api.myjson.com/bins/8uexe";
    bitToAskAdapter adapter ;
    ArrayList<BidtoAsk> bidtoAsks;
    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_to_bid);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new bitToAskAdapter();
        recyclerView.setAdapter(adapter);
        bidtoAsks = new ArrayList<>();

        getData();


    }

    private void getData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {


            @Override
            public void onResponse(JSONArray response) {

                try {
                    for (int i = 0 ; i<response.length();i++)
                    {


                        JSONObject jsonObject = response.getJSONObject(i);
                        BidtoAsk bidtoAsk = new BidtoAsk();
                        bidtoAsk.setTitle(jsonObject.getString("bids"));
                        bidtoAsk.setBody(jsonObject.getString("asks"));

                        bidtoAsks.add(bidtoAsk);


                    }
                }
                catch (JSONException e)
                {
                    Toast.makeText(askToBid.this, "JSON is not valid", Toast.LENGTH_SHORT).show();
                }

                adapter.setData(bidtoAsks);
                progressDialog.dismiss();


            }
        },


                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(askToBid.this,"Error Occured", Toast.LENGTH_SHORT);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }



}
