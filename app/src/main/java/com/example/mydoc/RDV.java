package com.example.mydoc;


public class RDV {

    private String appointmentId ;
    private String nom;
    private String prenom;
    private String dateRDV ;
    private String heurRDV;
    private String remarque;
    private String email ;
    private String tel ;

    public RDV() {
    }


    public RDV(String appointmentId, String nom, String prenom, String dateRDV, String heurRDV, String email, String tel) {

        this.appointmentId = appointmentId;
        this.nom = nom;
        this.prenom = prenom;
        this.dateRDV = dateRDV;
        this.heurRDV = heurRDV;
        this.email = email;
        this.tel = tel;


    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getNom() {
        return nom;
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

    public String getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(String dateRDV) {
        this.dateRDV = dateRDV;
    }

    public String getHeurRDV() {
        return heurRDV;
    }

    public void setHeurRDV(String heurRDV) {
        this.heurRDV = heurRDV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
