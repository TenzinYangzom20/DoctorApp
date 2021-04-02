package com.example.doctorapp;

public class DoctorDetails {
    // variables for storing our data.
    private String docName, docEmail, docSpecialities, docExperience;

    public DoctorDetails() {
        // empty constructor
        // required for Firebase.
    }

    // Constructor for all variables.


    public DoctorDetails(String docName, String docEmail, String docSpecialities, String docExperience) {
        this.docName = docName;
        this.docEmail = docEmail;
        this.docSpecialities = docSpecialities;
        this.docExperience = docExperience;
    }

    // getter methods for all variables.
    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocEmail() {
        return docEmail;
    }
    public void setDocEmail(String docEmail) {
        this.docEmail = docEmail;
    }

    public String getDocSpecialities() {
        return docSpecialities;
    }
    public void setDocSpecialities(String docSpecialities) {
        this.docSpecialities = docSpecialities;
    }

    public String getDocExperience() {
        return docExperience;
    }
    public void setDocExperience(String docExperience) {
        this.docExperience = docExperience;
    }
}
