/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibb.model;

/**
 *
 * @author trainer
 */
public class Adress {
    private int adressId;
    private String ort;
    private String vorname;
    private String nachname;
    private String email;

    public Adress() {
    }

    public Adress(String ort, String vorname, String nachname) {
        this.ort = ort;
        this.vorname = vorname;
        this.nachname = nachname;
    }
    
    
    
    

    public Adress(String ort, String vorname, String nachname, String email) {
        this.ort = ort;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
    }

    
    
    
    public int getAdressId() {
        return adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
}
