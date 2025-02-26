package ma.enset.gestion_consultations.Service;

import ma.enset.gestion_consultations.Entities.Consultation;
import ma.enset.gestion_consultations.Entities.Patient;

import java.util.List;

public interface ICabinetService {

    void AddPatient(Patient patient);
    void UpdatePatient(Patient patient);
    void DeletePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(long id);


    void AddConsultation(Consultation consultation);
    void UpdateConsultation(Consultation consultation);
    void DeleteConsultation(Consultation consultation);
    List<Consultation> getAllConsultations();
    Consultation getConsultationById(long id);
}
