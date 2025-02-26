package ma.enset.gestion_consultations.Service;

import ma.enset.gestion_consultations.DAO.ConsultationDaoImpl;
import ma.enset.gestion_consultations.DAO.PatientDaoImpl;
import ma.enset.gestion_consultations.Entities.Patient;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        ICabinetService service = new CabinetService(new PatientDaoImpl(),new ConsultationDaoImpl());
        List<Patient>patients = service.getAllPatients();

        patients.forEach(patient -> System.out.println(patient.toString()));
    }
}
