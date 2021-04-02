package com.example.doctorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DoctorDashboard extends AppCompatActivity implements View.OnClickListener{

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dashboard);

        //defining cards
        CardView setScheduleCard = (CardView) findViewById(R.id.DocsetSchedule_id);
        CardView docviewappointmentCard = (CardView) findViewById(R.id.Docviewappoint_id);

        //Add Click listener to the cards
        setScheduleCard.setOnClickListener(this);
        docviewappointmentCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.DocsetSchedule_id:
                i = new Intent(this, RegisterDoctor.class);
                startActivity(i);
                break;
            case R.id.Docviewappoint_id:
                i = new Intent(this, AstrologyPage.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}