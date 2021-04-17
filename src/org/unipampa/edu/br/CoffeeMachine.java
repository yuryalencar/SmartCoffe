//package org.unipampa.edu.br;
//
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//public class CoffeMachine implements Initializable {
//
//    //labels da tela principal
//    @FXML
//    private Label labelStatusCoffe;
//
//    @FXML
//    private Label labelCashBack;
//
//    @FXML
//    private TextField textFieldCoin;
//
//    //label da tela de login
//    @FXML
//    private TextField textFieldEmail;
//
//    //labels da tela de manutenção
//    @FXML
//    private Label labelStatusMaintenance;
//
//    @FXML
//    private Label labelWater;
//
//    @FXML
//    private Label labelGrain;
//
//    @FXML
//    private Label labelMilk;
//
//    @FXML
//    private Label labelCinnamon;
//
//    @FXML
//    private Label labelChocolate;
//
//    @FXML
//    private Label labelSugar;
//
//    @FXML
//    private Label labelGlassP;
//
//    @FXML
//    private Label labelGlassM;
//
//    @FXML
//    private Label labelGlassG;
//
//    @FXML
//    private Label labelCoinFiveCents;
//
//    @FXML
//    private Label labelCoinTenCents;
//
//    @FXML
//    private Label labelCoinTwentyFiveCents;
//
//    @FXML
//    private Label labelCoinFiftyCents;
//
//    @FXML
//    private Label labelCoinOne;
//
//    private Stage dialogStage;
//
//    public class CoffeeMachine {
//        private ArrayList<Recipe> recipes;
//        private Compartment cupsCompartment;
//        private Compartment coinsCompartment;
//        private Compartment ingredientsCompartment;
//        private EmailCentral emailCentral;
//
//        @Override
//        public void initialize(URL location, ResourceBundle resources) {
//            recipes = new ArrayList();
//            cupsCompartment = new CupsCompartment();
//            coinsCompartment = new CoinsCompartment();
//            ingredientsCompartment = new IngredientsCompartment();
//            this.emailCentral = new EmailCentral();
//        }
//
//
//        //método que renderiza a tela de login
//        @FXML
//        public void loginMachineSettings() throws IOException {
//
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(CoffeMachine.class
//                    .getResource("/fxml/login.fxml"));
//            AnchorPane page = (AnchorPane) loader.load();
//
//            dialogStage = new Stage();
//            CoffeMachine controller = loader.getController();
//            controller.setDialogStage(dialogStage);
//            // Criando um Estágio de Diálogo (Stage Dialog)
//
//            dialogStage.setTitle("SmartCoffe");
//            dialogStage.setResizable(false);
//            Scene scene = new Scene(page);
//            dialogStage.setScene(scene);
//            dialogStage.show();
//        }
//
//        //Método que renderiza a tela de configurações da cafeteira
//        @FXML
//        public void machineSettings() throws IOException {
//
//            if (textFieldEmail.getText() != null && !textFieldEmail.getText().isEmpty()) {
//                if (emailCentral.getTechnicianEmail().equalsIgnoreCase(textFieldEmail.getText())) {
//                    //Fecha o dialog de login e abre a tela de configuracoes da maquina
//                    dialogStage.close();
//
//                    FXMLLoader loader = new FXMLLoader();
//                    loader.setLocation(CoffeMachine.class
//                            .getResource("/fxml/maintenance.fxml"));
//                    AnchorPane page = (AnchorPane) loader.load();
//
//                    dialogStage = new Stage();
//                    CoffeMachine controller = loader.getController();
//                    controller.setDialogStage(dialogStage);
//                    // Criando um Estágio de Diálogo (Stage Dialog)
//
//                    dialogStage.setTitle("SmartCoffe - Configurações da Cafeteira");
//                    dialogStage.setResizable(false);
//                    Scene scene = new Scene(page);
//                    dialogStage.setScene(scene);
//                    dialogStage.showAndWait();
//                } else {
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setTitle("Erro na autenticação");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Email incorreto");
//                    alert.showAndWait();
//                }
//            }
//        }
//
//        //método que fecha a tela de configurações da máquina
//        @FXML
//        public void close() throws IOException {
//            this.dialogStage.close();
//        }
//
//        public void setDialogStage(Stage dialogStage) {
//            this.dialogStage = dialogStage;
//        }
//    }
//}
