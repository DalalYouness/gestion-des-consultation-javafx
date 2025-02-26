package ma.enset.gestion_consultations.DAO;

import ma.enset.gestion_consultations.Entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements IPatientDAO{
    @Override
    public void Create(Patient patient) throws SQLException {
        Connection connection = DBcoonectionSettings.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO patients(Nom,Prénom,Tele) " +
                "VALUES (?,?,?)");
        preparedStatement.setString(1,patient.getNom());
        preparedStatement.setString(2,patient.getPrenom());
        preparedStatement.setString(3,patient.getTelephone());

        preparedStatement.executeUpdate();

    }

    @Override
    public void Update(Patient patient) throws SQLException {

        Connection connection = DBcoonectionSettings.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PATIENTS " +
                "SET NOM = ?,Prénom = ?,TELE = ? WHERE ID_Patients = ?");
        preparedStatement.setString(1,patient.getNom());
        preparedStatement.setString(2,patient.getPrenom());
        preparedStatement.setString(3,patient.getTelephone());
        preparedStatement.setLong(4,patient.getID_Patient());

        preparedStatement.executeUpdate();

    }

    @Override
    public void Delete(Patient patient) throws SQLException {
        Connection connection = DBcoonectionSettings.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PATIENTS WHERE ID_PATIENTS = ?");
        preparedStatement.setLong(1,patient.getID_Patient());
        preparedStatement.executeUpdate();
    }

    @Override
    public Patient FindByID(Long id) throws SQLException {

        Connection connection = DBcoonectionSettings.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Patients " +
                "WHERE ID_Patients = ?");

        preparedStatement.setLong(1,id);
        ResultSet resultset = preparedStatement.executeQuery();
        Patient patient = new Patient();

        if(resultset.next()){

            patient.setID_Patient(resultset.getLong("ID_Patients"));
            patient.setNom(resultset.getString("Nom"));
            patient.setPrenom(resultset.getString("Prénom"));
            patient.setTelephone(resultset.getString("Tele"));

        }
        return patient;
    }

    @Override
    public List<Patient> GetAll() throws SQLException {


        List<Patient> patients = new ArrayList<>();

        Connection connection = DBcoonectionSettings.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Patients");
        ResultSet resultset = preparedStatement.executeQuery();

        while(resultset.next()){
            Patient patient = new Patient();
            patient.setID_Patient(resultset.getLong("ID_Patients"));
            patient.setNom(resultset.getString("Nom"));
            patient.setPrenom(resultset.getString("Prénom"));
            patient.setTelephone(resultset.getString("Tele"));
            patients.add(patient);
        }
        return patients;
    }


}
