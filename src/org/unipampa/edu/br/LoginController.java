package org.unipampa.edu.br;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField textFieldEmail;

    Stage dialogStage;

    EmailCentral emailCentral;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailCentral = new EmailCentral();
    }

    @FXML
    public void machineSettings() throws IOException {

        if (textFieldEmail.getText() != null && !textFieldEmail.getText().isEmpty()) {
            if (emailCentral.getTechnicianEmail().equalsIgnoreCase(textFieldEmail.getText())) {
                //Fecha o dialog de login e abre a tela de configuracoes da maquina
                dialogStage.close();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MachineSettingsController.class
                        .getResource("/fxml/maintenance.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                Stage stage = new Stage();
                MachineSettingsController controller = loader.getController();
                controller.setDialogStage(stage);
                // Criando um Estágio de Diálogo (Stage Dialog)

                stage.setTitle("SmartCoffe - Configurações da Cafeteira");
                stage.setResizable(false);
                Scene scene = new Scene(page);
                stage.setScene(scene);
                stage.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erro na autenticação");
                alert.setHeaderText(null);
                alert.setContentText("Email incorreto");
                alert.showAndWait();
            }
        }
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
