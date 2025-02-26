package ma.enset.gestion_consultations.Controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.gestion_consultations.DAO.ConsultationDaoImpl;
import ma.enset.gestion_consultations.DAO.PatientDaoImpl;
import ma.enset.gestion_consultations.Entities.Consultation;
import ma.enset.gestion_consultations.Entities.Patient;
import ma.enset.gestion_consultations.Service.CabinetService;
import ma.enset.gestion_consultations.Service.ICabinetService;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ConsultationController implements Initializable {


    @FXML private TableColumn<Consultation,String> clmPatient;
    @FXML private TableColumn<Consultation,String> clmDescription;
    @FXML private TableColumn<Consultation, Date> clmDateConsultation;
    @FXML private TableColumn<Consultation,Long> clmIDConsultation;
    @FXML private TableView<Consultation> tvConsultation;
    @FXML private ComboBox<Patient> cmbPatient;
    @FXML private TextArea txtDescription;
    @FXML private DatePicker datepConsultation;

    private ICabinetService cabinetService;
    //module consultation
    private ObservableList<Consultation> consultations = FXCollections.observableArrayList();
    private ObservableList<Patient> patients = FXCollections.observableArrayList();


    private void LoadConsultations()
    {
        consultations.setAll(cabinetService.getAllConsultations());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService = new CabinetService(new PatientDaoImpl(), new ConsultationDaoImpl());
        patients.setAll(cabinetService.getAllPatients());
        cmbPatient.setItems(patients);

        clmIDConsultation.setCellValueFactory(new PropertyValueFactory<>("ID_Consultation"));
        clmDateConsultation.setCellValueFactory(new PropertyValueFactory<>("Date_Consultation"));
        clmDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));

        // Modifier la colonne patient pour afficher le nom et prénom du patient
        clmPatient.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPatient().toString()));

        tvConsultation.setItems(consultations);
        LoadConsultations();
    }




    public void AddConsultation ()
    {
        Consultation consultation = new Consultation();
        consultation.setDate_Consultation(Date.valueOf(datepConsultation.getValue()));
        consultation.setDescription(txtDescription.getText());
        consultation.setPatient(cmbPatient.getSelectionModel().getSelectedItem());

        cabinetService.AddConsultation(consultation);

        datepConsultation.setValue(null);
        txtDescription.setText("");
        cmbPatient.getSelectionModel().clearSelection();

        LoadConsultations();
    }

    public void deleteConsultation()
    {
        Consultation consultation = new Consultation();
        consultation = tvConsultation.getSelectionModel().getSelectedItem();
        cabinetService.DeleteConsultation(consultation);
        LoadConsultations();
    }

    public void RemplirFormulaire()
    {
        Consultation consultation = tvConsultation.getSelectionModel().getSelectedItem();
        //fill la partie date
        java.sql.Date sqlDate = consultation.getDate_Consultation();
        LocalDate localDate = sqlDate.toLocalDate();
        datepConsultation.setValue(localDate);

        txtDescription.setText(consultation.getDescription());
        cmbPatient.setValue(consultation.getPatient());
    }

    public void UpdateConsultation()
    {
        Consultation consultation = tvConsultation.getSelectionModel().getSelectedItem();

        consultation.setDate_Consultation(Date.valueOf(datepConsultation.getValue()));
        consultation.setDescription(txtDescription.getText());
        consultation.setPatient(cmbPatient.getSelectionModel().getSelectedItem());

        cabinetService.UpdateConsultation(consultation);
        datepConsultation.setValue(null);
        txtDescription.setText("");
        cmbPatient.getSelectionModel().clearSelection();
        LoadConsultations();

    }


}
