package com.example.doctorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeDashboard extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dashboard);
        //defining cards
        CardView consultationCard = (CardView) findViewById(R.id.consultation_id);
        CardView astrologyCard = (CardView) findViewById(R.id.astrology_id);
        CardView aboutUsCard = (CardView) findViewById(R.id.aboutus_id);
        CardView contactCard = (CardView) findViewById(R.id.contact_id);
        //Add Click listener to the cards
        consultationCard.setOnClickListener(this);
        astrologyCard.setOnClickListener(this);
        aboutUsCard.setOnClickListener(this);
        contactCard.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.consultation_id : i = new Intent(this, ConsultationPage.class);
            startActivity(i); break;
            case R.id.astrology_id : i = new Intent(this, AstrologyPage.class);
            startActivity(i); break;
            case R.id.aboutus_id : i = new Intent(this, AboutusPage.class);
            startActivity(i); break;
            case R.id.contact_id : i = new Intent(this, ContactPage.class);
            startActivity(i); break;
            default: break;
        }

    }
}