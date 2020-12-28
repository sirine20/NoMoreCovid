package com.dsi31.g2.nomorecovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity
{

    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ratingBar = findViewById(R.id.ratingBar);

        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        String rate = prefs.getString("rateValue", null);
        if (rate != null)
        {
            ratingBar.setRating(Float.parseFloat(rate));
            Toast.makeText(RatingActivity.this,getString(R.string.message_getting_value) + " : " + rate, Toast.LENGTH_SHORT).show();
        }

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rate = String.valueOf(ratingBar.getRating());
                SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
                try
                {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("rateValue", rate);
                    editor.apply();
                    Toast.makeText(RatingActivity.this, getString(R.string.message_saving_value) + " : " + rate, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(RatingActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}