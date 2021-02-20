package com.example.mydoc;



public class Patient {

    private String patientId ;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String email;
    private String sexe;
    private String age;
    private String cin ;

    public Patient() {
    }


    public Patient(String patientId, String nom, String prenom, String adress, String tel, String email, String age, String cin) {

        this.patientId = patientId ;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adress;
        this.tel = tel;
        this.email = email;
        this.age = age;
        this.cin = cin;

    }

    public String getPatientid() {
        return patientId;
    }

    public void setPatientid(String patientId) {
        this.patientId = patientId;
    }

    public String getNom() {
        return nom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
