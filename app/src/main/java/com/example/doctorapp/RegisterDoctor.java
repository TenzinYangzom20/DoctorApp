package com.example.doctorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class RegisterDoctor extends AppCompatActivity {

    // creating variables for our edit text
    private EditText docNameEdt, docEmailEdt, docSpecialitiesEdt, docExperienceEdt;

    // creating variable for button
    private Button submitDocBtn;

    // creating a strings for storing our values from edittext fields.
    private String docName, docEmail, docSpecialities, docExperience;

    // creating a variable for firebasefirestore.
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_doctor);

        // getting our instance from Firebase Firestore.
        db = FirebaseFirestore.getInstance();

        // initializing our edittext and buttons
        docNameEdt = findViewById(R.id.idEdtDocName);
        docEmailEdt = findViewById(R.id.idEdtDocEmail);
        docSpecialitiesEdt = findViewById(R.id.idEdtDocSpecialities);
        docExperienceEdt = findViewById(R.id.idEdtDocExperience);
        submitDocBtn = findViewById(R.id.idBtnRegisterDoc);

        // adding on click listener for button
        submitDocBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting data from edittext fields.
                docName = docNameEdt.getText().toString();
                docEmail = docEmailEdt.getText().toString();
                docSpecialities = docSpecialitiesEdt.getText().toString();
                docExperience = docExperienceEdt.getText().toString();

                // validating the text fields if empty or not.
                if (TextUtils.isEmpty(docName)) {
                    docNameEdt.setError("Please enter Doctor Name");
                } else if (TextUtils.isEmpty(docEmail)) {
                    docEmailEdt.setError("Please enter Doctor Email");
                } else if (TextUtils.isEmpty(docSpecialities)) {
                    docSpecialitiesEdt.setError("Please enter Doctor Specialities");
                } else if (TextUtils.isEmpty(docExperience)) {
                    docExperienceEdt.setError("Please enter Doctor Experience");
                }else {
                    // calling method to add data to Firebase Firestore.
                    addDataToFirestore(docName, docEmail, docSpecialities, docExperience);
                }
            }
        });
    }

    private void addDataToFirestore(String docName, String docEmail, String docSpecialities, String docExperience) {

        // creating a collection reference for our Firebase Firestore database.
        CollectionReference dbCourses;
        dbCourses = db.collection("DoctorDetails");

        // adding our data to our doctor detail object class.
        DoctorDetails doctorDetails = new DoctorDetails(docName, docEmail, docSpecialities, docExperience);

        // below method is use to add data to Firebase Firestore.
        dbCourses.add(doctorDetails).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful we are displaying a success toast message.
                Toast.makeText(RegisterDoctor.this, "Doctor Details has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(RegisterDoctor.this, "Fail to add doctor details \n" + e, Toast.LENGTH_SHORT).show();
            }
        });

    }
}