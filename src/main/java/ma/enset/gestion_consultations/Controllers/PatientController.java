package ma.enset.gestion_consultations.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.gestion_consultations.DAO.ConsultationDaoImpl;
import ma.enset.gestion_consultations.DAO.PatientDaoImpl;
import ma.enset.gestion_consultations.Entities.Patient;
import ma.enset.gestion_consultations.Service.CabinetService;
import ma.enset.gestion_consultations.Service.ICabinetService;

import java.net.URL;
import java.sql.Struct;
import java.util.ResourceBundle;

public class PatientController implements Initializable {


    @FXML private TableColumn<Patient,String> clmTele;
    @FXML private TableColumn<Patient,String> clmPrenom;
    @FXML private TableColumn<Patient,String> clmNom;
    @FXML private TableColumn<Patient,Long> clmID;
    @FXML private TableView<Patient> tbvPatients;
    @FXML private TextField txtSearch;
    @FXML private TextField txtNom;
    @FXML private TextField txtPrenom;
    @FXML private TextField txtTele;
    private ICabinetService cabinetService;
    // c'est ca le modele ou on va stocker les donnée dans le table vue
    private ObservableList<Patient> patients = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cabinetService = new CabinetService(new PatientDaoImpl(),new ConsultationDaoImpl());

        // je vais assigner à chaque column l'attribut
        clmID.setCellValueFactory(new PropertyValueFactory<>("ID_Patient"));
        clmNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        clmPrenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        clmTele.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        // je vais charger tous les ligne depuis DB et afficher dans le table vue

        // j'ai associé le modele au tableVue
        tbvPatients.setItems(patients);
        LoadPatient();

    }



    public void AddPatient()
    {
        Patient patient = new Patient();

        patient.setNom(txtNom.getText().trim());
        patient.setPrenom(txtPrenom.getText().trim());
        patient.setTelephone(txtTele.getText().trim());
        cabinetService.AddPatient(patient);

        txtNom.setText("");
        txtPrenom.setText("");
        txtTele.setText("");
        txtNom.requestFocus();
        LoadPatient();

    }

    public void UpdatePatient()
    {

        Patient patient = tbvPatients.getSelectionModel().getSelectedItem();

        patient.setNom(txtNom.getText().trim());
        patient.setPrenom(txtPrenom.getText().trim());
        patient.setTelephone(txtTele.getText().trim());

        cabinetService.UpdatePatient(patient);

        txtNom.setText("");
        txtPrenom.setText("");
        txtTele.setText("");
        txtNom.requestFocus();
        LoadPatient();



    }

    public void RemplirFormulaire()
    {
        Patient patient = tbvPatients.getSelectionModel().getSelectedItem();
        txtNom.setText(patient.getNom());
        txtPrenom.setText(patient.getPrenom());
        txtTele.setText(patient.getTelephone());
    }

    public void DeletePatient()
    {
           Patient patient = tbvPatients.getSelectionModel().getSelectedItem();
           cabinetService.DeletePatient(patient);
           LoadPatient();
    }

    private void LoadPatient()
    {
        patients.setAll(cabinetService.getAllPatients());
    }

}
