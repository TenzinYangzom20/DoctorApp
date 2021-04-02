package com.example.doctorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ConsultationPage extends AppCompatActivity {

    // creating a variable for our list view,
    // arraylist and firebase Firestore.
    ListView doctorsLV;
    ArrayList<DoctorAvailable> doctorAvailableArrayList;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation_page);

        // below line is use to initialize our variables
        doctorsLV = findViewById(R.id.idLVCourses);
        doctorAvailableArrayList = new ArrayList<>();

        // initializing our variable for firebase firestore and getting its instance.
        db = FirebaseFirestore.getInstance();

        // here we are calling a method
        // to load data in our list view.
        loadDatainListview();
    }

    private void loadDatainListview() {
        // below line is use to get data from Firebase
        // firestore using collection in android.
        db.collection("DoctorDetails").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        // after getting the data we are calling on success method
                        // and inside this method we are checking if the received
                        // query snapshot is empty or not.
                        if (!queryDocumentSnapshots.isEmpty()) {
                            // if the snapshot is not empty we are hiding
                            // our progress bar and adding our data in a list.
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                // after getting this list we are passing
                                // that list to our object class.
                                DoctorAvailable doctorAvailable = d.toObject(DoctorAvailable.class);

                                // after getting data from Firebase we are
                                // storing that data in our array list
                                doctorAvailableArrayList.add(doctorAvailable);
                            }
                            // after that we are passing our array list to our adapter class.
                            DoctorsLVAdapter adapter = new DoctorsLVAdapter(ConsultationPage.this, doctorAvailableArrayList);

                            // after passing this array list to our adapter
                            // class we are setting our adapter to our list view.
                            doctorsLV.setAdapter(adapter);
                        } else {
                            // if the snapshot is empty we are displaying a toast message.
                            Toast.makeText(ConsultationPage.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // we are displaying a toast message
                // when we get any error from Firebase.
                Toast.makeText(ConsultationPage.this, "Fail to load data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}