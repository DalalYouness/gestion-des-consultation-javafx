# Gestion des Consultations Médicales

## 📌 Description  
Ce projet est une application de gestion des consultations médicales, permettant la gestion des patients et des consultations via une interface utilisateur. L’application suit l'architecture **MVC** et utilise **Java** avec **JavaFX** pour l’interface graphique.

---

## 📂 Structure du Projet  

### 📁 `Controllers`  
Gère la logique des interactions entre l’interface utilisateur et la couche de service.  
- **`ConsultationController.java`** : Gestion des consultations.  
- **`PatientController.java`** : Gestion des patients.  

### 📁 `DAO (Data Access Object)`  
Gère l'accès aux données et interagit avec la base de données.  
- **`ConsultationDaoImpl.java`** : Implémentation de la gestion des consultations.  
- **`PatientDaoImpl.java`** : Implémentation de la gestion des patients.  
- **`DBConnectionSettings.java`** : Configuration de la connexion à la base de données.  
- **`IConsultationDAO.java`** & **`IPatientDAO.java`** : Interfaces définissant les méthodes DAO.  
- **`IDAO.java`** : Interface générique pour les opérations CRUD.  

### 📁 `Entities`  
Représente les entités principales du projet.  
- **`Consultation.java`** : Modèle d'une consultation.  
- **`Patient.java`** : Modèle d'un patient.  

### 📁 `Service`  
- **`Main.java`** : Point d’entrée principal de l’application.  

### 📁 `resources (Views)`  
Contient les fichiers **FXML** pour l’interface utilisateur.  
- **`consultation-view.fxml`** : Interface pour gérer les consultations.  
- **`patients-view.fxml`** : Interface pour gérer les patients.  
- **`main-view.fxml`** : Interface principale de l'application.


![Ajout consultation1](https://github.com/user-attachments/assets/ad614267-8da7-4602-9629-7dc2d8715ebf)
![Suppression consultation](https://github.com/user-attachments/assets/0400dc46-ffe9-4092-894f-ceaf16fcb846)
![Modification1](https://github.com/user-attachments/assets/c83970cf-9ddb-4cf6-bdd8-40bc2384c741)
![Modification](https://github.com/user-attachments/assets/06da48da-7c4d-443a-9502-fdfb4d60f815)
![Mcd](https://github.com/user-attachments/assets/15921e73-3ea0-46cb-b6c4-e48b358228cd)
![AjoutConsultation2](https://github.com/user-attachments/assets/782681a2-d053-4fe7-96f4-db0904c9c330)
![Ajout2](https://github.com/user-attachments/assets/e8b77162-72de-4190-b9ae-62f95ff8b9c2)
![Ajout](https://github.com/user-attachments/assets/d1ea0fd6-9b9d-4b61-9ab7-868f24b1fa3f)
![Suppression2](https://github.com/user-attachments/assets/29ade6fb-d09a-47cb-941e-cf3b8620863b)
![Suppression1](https://github.com/user-attachments/assets/a1fbe4ec-9977-4562-b621-35aad70e291f)
