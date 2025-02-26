package ma.enset.gestion_consultations.Entities;

import java.util.List;

public class Patient {
    private long ID_Patient;
    private String Nom;
    private String Prenom;
    private String Telephone;
    private List<Consultation> consultations;

    public Patient() {
    }

    public Patient(String nom, String prenom, String telephone) {
        Nom = nom;
        Prenom = prenom;
        Telephone = telephone;
    }

    public long getID_Patient() {
        return ID_Patient;
    }

    public void setID_Patient(long ID_Patient) {
        this.ID_Patient = ID_Patient;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    @Override
    public String toString() {
        return Nom + ' ' + Prenom;
    }
}
