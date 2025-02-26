package ma.enset.gestion_consultations.Entities;

import java.sql.Date;

public class Consultation {
    private long ID_Consultation;
    private Date Date_Consultation;
    private String Description;
    private Patient patient;

    public Consultation() {
    }

    public Consultation(Date date_Consultation, String description, Patient patient) {
        Date_Consultation = date_Consultation;
        Description = description;
        this.patient = patient;
    }

    public long getID_Consultation() {
        return ID_Consultation;
    }

    public void setID_Consultation(long ID_Consultation) {
        this.ID_Consultation = ID_Consultation;
    }

    public Date getDate_Consultation() {
        return Date_Consultation;
    }

    public void setDate_Consultation(Date date_Consultation) {
        Date_Consultation = date_Consultation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
