package com.example.doctorapp;

public class DoctorAvailable {
    // variables for storing our image and name.
    private String docName;
    private String imgUrl;
    private String docEmail;
    private String docSpecialities;
    private String docExperience;


    public DoctorAvailable() {
        // empty constructor required for firebase.
    }

    // constructor for our object class.
    public DoctorAvailable(String docName, String imgUrl, String docEmail, String docSpecialities,String docExperience) {
        this.docName = docName;
        this.imgUrl = imgUrl;
        this.docEmail = docEmail;
        this.docSpecialities = docSpecialities;
        this.docExperience = docExperience;
    }

    // getter and setter methods
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

    public String getImgUrl() {

        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {

        this.imgUrl = imgUrl;
    }
}
