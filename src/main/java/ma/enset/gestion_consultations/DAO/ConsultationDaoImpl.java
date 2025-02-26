package ma.enset.gestion_consultations.DAO;

import ma.enset.gestion_consultations.Entities.Consultation;
import ma.enset.gestion_consultations.Entities.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDaoImpl implements IConsultationDAO{

    IPatientDAO patientDao = new PatientDaoImpl();

    @Override
    public void Create(Consultation consultation) throws SQLException {

        Connection connection = DBcoonectionSettings.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CONSULTATIONS (Date_Consultation,Description,PatientID)" +
                "VALUES (?,?,?)");
        preparedStatement.setDate(1,consultation.getDate_Consultation());
        preparedStatement.setString(2,consultation.getDescription());
        preparedStatement.setLong(3,consultation.getPatient().getID_Patient());

        preparedStatement.executeUpdate();
    }

    @Override
    public void Update(Consultation consultation) throws SQLException {

        Connection connection = DBcoonectionSettings.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Consultations " +
                "SET Date_Consultation = ?,Description = ?,PatientID = ? WHERE ID_Consultation = ?");


        preparedStatement.setDate(1,consultation.getDate_Consultation());
        preparedStatement.setString(2,consultation.getDescription());
        preparedStatement.setLong(3,consultation.getPatient().getID_Patient());
        preparedStatement.setLong(4,consultation.getID_Consultation());

        preparedStatement.executeUpdate();
    }

    @Override
    public void Delete(Consultation consultation) throws SQLException {
        Connection connection = DBcoonectionSettings.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Consultations WHERE ID_Consultation = ?");
        preparedStatement.setLong(1,consultation.getID_Consultation());
        preparedStatement.executeUpdate();

    }

    @Override
    public Consultation FindByID(Long id) {



     return null;
    }

    @Override
    public List<Consultation> GetAll() throws SQLException {

        List<Consultation> consultations = new ArrayList<>();

        Connection connection = DBcoonectionSettings.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Consultations");
        ResultSet resultset = preparedStatement.executeQuery();

        while(resultset.next()){
            Consultation consultation = new Consultation();

            consultation.setID_Consultation(resultset.getLong(1));
            consultation.setDate_Consultation(resultset.getDate(2));
            consultation.setDescription(resultset.getString(3));
            consultation.setPatient(patientDao.FindByID(resultset.getLong(4)));
            consultations.add(consultation);


        }
        return consultations;
    }
}
