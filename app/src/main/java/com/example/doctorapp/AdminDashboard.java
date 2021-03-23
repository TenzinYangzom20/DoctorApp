package com.example.doctorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminDashboard extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        //defining cards
        CardView regdoctorCard = (CardView) findViewById(R.id.AdregDoc_id);
        CardView viewappointmentCard = (CardView) findViewById(R.id.AdviewAppoint_id);
        CardView viewpatientCard = (CardView) findViewById(R.id.AdviewPatient_id);
        CardView updatedoctorCard = (CardView) findViewById(R.id.AdupdateDoc_id);
        //Add Click listener to the cards
        regdoctorCard.setOnClickListener(this);
        viewappointmentCard.setOnClickListener(this);
        viewpatientCard.setOnClickListener(this);
        updatedoctorCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.AdregDoc_id:
                i = new Intent(this, ConsultationPage.class);
                startActivity(i);
                break;
            case R.id.AdviewAppoint_id:
                i = new Intent(this, AstrologyPage.class);
                startActivity(i);
                break;
            case R.id.AdviewPatient_id:
                i = new Intent(this, AboutusPage.class);
                startActivity(i);
                break;
            case R.id.AdupdateDoc_id:
                i = new Intent(this, ContactPage.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}