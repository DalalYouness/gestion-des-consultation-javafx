package ma.enset.gestion_consultations.Service;

import ma.enset.gestion_consultations.DAO.ConsultationDaoImpl;
import ma.enset.gestion_consultations.DAO.IConsultationDAO;
import ma.enset.gestion_consultations.DAO.IPatientDAO;
import ma.enset.gestion_consultations.Entities.Consultation;
import ma.enset.gestion_consultations.Entities.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CabinetService implements ICabinetService{

    private IPatientDAO patientDAO;
    private IConsultationDAO consultationDAO;

    public CabinetService(IPatientDAO patientDAO, IConsultationDAO consultationDAO) {
        this.patientDAO = patientDAO;
        this.consultationDAO = consultationDAO;
    }

    @Override
    public void AddPatient(Patient patient) {
        try {
            patientDAO.Create(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdatePatient(Patient patient) {
        try {
            patientDAO.Update(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeletePatient(Patient patient) {
        try {
            patientDAO.Delete(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = null;
        try {
            patients =  patientDAO.GetAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;

    }

    @Override
    public Patient getPatientById(long id) {

       Patient patient = null;
        try {
            patient =  patientDAO.FindByID(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patient;
    }

    @Override
    public void AddConsultation(Consultation consultation) {

        try {
            consultationDAO.Create(consultation);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void UpdateConsultation(Consultation consultation) {

        try {
            consultationDAO.Update(consultation);
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void DeleteConsultation(Consultation consultation) {
        try {
            consultationDAO.Delete(consultation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Consultation> getAllConsultations() {
        List<Consultation> consultations = new ArrayList<>();
        try {
            consultations = consultationDAO.GetAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultations;
    }

    @Override
    public Consultation getConsultationById(long id) {
        return null;
    }
}
