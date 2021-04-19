package org.unipampa.edu.br;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MachineSettingsController implements Initializable {

    @FXML
    private Label labelStatusMaintenance;

    @FXML
    private Label labelWater;

    @FXML
    private Label labelGrain;

    @FXML
    private Label labelMilk;

    @FXML
    private Label labelCinnamon;

    @FXML
    private Label labelChocolate;

    @FXML
    private Label labelSugar;

    @FXML
    private Label labelCupP;

    @FXML
    private Label labelCupM;

    @FXML
    private Label labelCupG;

    @FXML
    private Label labelCoinFiveCentsAdd;

    @FXML
    private Label labelCoinTenCentsAdd;

    @FXML
    private Label labelCoinTwentyFiveCentsAdd;

    @FXML
    private Label labelCoinFiftyCentsAdd;

    @FXML
    private Label labelCoinOneAdd;

    @FXML
    private Label labelCoinFiveCents;

    @FXML
    private Label labelCoinTenCents;

    @FXML
    private Label labelCoinTwentyFiveCents;

    @FXML
    private Label labelCoinFiftyCents;

    @FXML
    private Label labelCoinOne;

    @FXML
    private TextField textFieldWater;

    @FXML
    private TextField textFieldCoffee;

    @FXML
    private TextField textFieldMilk;

    @FXML
    private TextField textFieldCinnamon;

    @FXML
    private TextField textFieldChocolate;

    @FXML
    private TextField textFieldSugar;

    @FXML
    private TextField textFieldCupP;

    @FXML
    private TextField textFieldCupM;

    @FXML
    private TextField textFieldCupG;

    @FXML
    private TextField textFieldCoinFiveCentsAdd;

    @FXML
    private TextField textFieldCoinTenCentsAdd;

    @FXML
    private TextField textFieldCoinTwentyFiveCentsAdd;

    @FXML
    private TextField textFieldCoinFiftyCentsAdd;

    @FXML
    private TextField textFieldCoinOneAdd;

    @FXML
    private TextField textFieldCoinFiveCentsGet;

    @FXML
    private TextField textFieldCoinTenCentsGet;

    @FXML
    private TextField textFieldCoinTwentyFiveCentsGet;

    @FXML
    private TextField textFieldCoinFiftyCentsGet;

    @FXML
    private TextField textFieldCoinOneGet;

    Stage dialogStage;

    DrinkMachine drinkMachine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drinkMachine = DrinkMachine.getInstance();
        labelStatusMaintenance.setText("Em manutenção");
        initDisplay();
    }

    //método que fecha a tela de configurações da máquina
    @FXML
    public void close() throws IOException {
        this.dialogStage.close();
    }

    @FXML
    public void addCoinFiveCents(){

        if(!textFieldCoinFiveCentsAdd.getText().isEmpty() && textFieldCoinFiveCentsAdd.getText() != null){
            if(drinkMachine.getCoinsCompartment().
                    fill("fiveCents", Integer.valueOf(textFieldCoinFiveCentsAdd.getText()))) {

                textFieldCoinFiveCentsAdd.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Moeda");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Moeda");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void addCoinTenCents(){

        if(!textFieldCoinTenCentsAdd.getText().isEmpty() && textFieldCoinTenCentsAdd.getText() != null){
            if(drinkMachine.getCoinsCompartment().
                    fill("tenCents", Integer.valueOf(textFieldCoinTenCentsAdd.getText()))) {

                textFieldCoinTenCentsAdd.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Moeda");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida!");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Moeda");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }
    }

    @FXML
    public void addCoinTwentyFiveCents(){

        if(!textFieldCoinTwentyFiveCentsAdd.getText().isEmpty() && textFieldCoinTwentyFiveCentsAdd.getText() != null){
            if(drinkMachine.getCoinsCompartment().
                    fill("twentyFiveCents", Integer.valueOf(textFieldCoinTwentyFiveCentsAdd.getText()))) {

                textFieldCoinTwentyFiveCentsAdd.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Moeda");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Moeda");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void addCoinFiftyCents(){

        if(!textFieldCoinFiftyCentsAdd.getText().isEmpty() && textFieldCoinFiftyCentsAdd.getText() != null){
            if(drinkMachine.getCoinsCompartment().
                    fill("fiftyCents", Integer.valueOf(textFieldCoinFiftyCentsAdd.getText()))) {

                textFieldCoinFiftyCentsAdd.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Moeda");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Moeda");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void addCoinOne(){

        if(!textFieldCoinOneAdd.getText().isEmpty() && textFieldCoinOneAdd.getText() != null){
            if(drinkMachine.getCoinsCompartment().
                    fill("oneBRL", Integer.valueOf(textFieldCoinOneAdd.getText()))){

                textFieldCoinOneAdd.setText("");
                initDisplay();
            } else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Moeda");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Moeda");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void getCoinFiveCents(){

        if(!textFieldCoinFiveCentsGet.getText().isEmpty() && textFieldCoinFiveCentsGet.getText() != null){
            if(drinkMachine.getCoinsCompartment().
                    take("fiveCents", Integer.valueOf(textFieldCoinFiveCentsGet.getText()))){

                textFieldCoinFiveCentsGet.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Moeda");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não possui a quantidade sollicitada");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Moeda");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }
    }

    @FXML
    public void getCoinTenCents(){

        if(!textFieldCoinTenCentsGet.getText().isEmpty() && textFieldCoinTenCentsGet.getText() != null){
            if(drinkMachine.getCoinsCompartment().
                    take("tenCents", Integer.valueOf(textFieldCoinTenCentsGet.getText()))){

                textFieldCoinTenCentsGet.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Moeda");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não possui a quantidade sollicitada");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Moeda");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void getCoinTwentyFiveCents(){

        if(!textFieldCoinTwentyFiveCentsGet.getText().isEmpty() && textFieldCoinTwentyFiveCentsGet.getText() != null){
            if(drinkMachine.getCoinsCompartment().
                    take("twentyFiveCents", Integer.valueOf(textFieldCoinTwentyFiveCentsGet.getText()))){

                textFieldCoinTwentyFiveCentsGet.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Moeda");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não possui a quantidade sollicitada");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Moeda");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void getCoinFiftyCents(){

        if(!textFieldCoinFiftyCentsGet.getText().isEmpty() && textFieldCoinFiftyCentsGet.getText() != null){
            if(drinkMachine.getCoinsCompartment().
                    take("fiftyCents", Integer.valueOf(textFieldCoinFiftyCentsGet.getText()))){

                textFieldCoinFiftyCentsGet.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Moeda");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não possui a quantidade sollicitada");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Moeda");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void getCoinOne(){

        if(!textFieldCoinOneGet.getText().isEmpty() && textFieldCoinOneGet.getText() != null){
            if(drinkMachine.getCoinsCompartment().
                    take("oneBRL", Integer.valueOf(textFieldCoinOneGet.getText()))){

                textFieldCoinOneGet.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Moeda");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não possui a quantidade sollicitada");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Moeda");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void addCupP(){

        if(!textFieldCupP.getText().isEmpty() && textFieldCupP.getText() != null){
            if(drinkMachine.getCupsCompartment().
                    fill("smallCup", Integer.valueOf(textFieldCupP.getText()))){

                textFieldCupP.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Copos");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Copos");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void addCupM(){

        if(!textFieldCupM.getText().isEmpty() && textFieldCupM.getText() != null){
            if(drinkMachine.getCupsCompartment().
                    fill("mediumCup", Integer.valueOf(textFieldCupM.getText()))){

                textFieldCupM.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Copos");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Copos");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }
    }

    @FXML
    public void addCupG(){

        if(!textFieldCupG.getText().isEmpty() && textFieldCupG.getText() != null){
            if(drinkMachine.getCupsCompartment().
                    fill("bigCup", Integer.valueOf(textFieldCupG.getText()))){

                textFieldCupG.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Copos");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Copos");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void addWater(){

        if(!textFieldWater.getText().isEmpty() && textFieldWater.getText() != null){
            if(drinkMachine.getIngredientsCompartment().
                    fill("water", Integer.valueOf(textFieldWater.getText()))){

                textFieldWater.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Ingredientes");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Ingredientes");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }

    }

    @FXML
    public void addCoffee(){

        if(!textFieldCoffee.getText().isEmpty() && textFieldCoffee.getText() != null){
            if(drinkMachine.getIngredientsCompartment().
                    fill("coffee", Integer.valueOf(textFieldCoffee.getText()))){

                textFieldCoffee.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Ingredientes");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Ingredientes");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }
    }

    @FXML
    public void addMilk(){

        if(!textFieldMilk.getText().isEmpty() && textFieldMilk.getText() != null){
            if(drinkMachine.getIngredientsCompartment().
                    fill("milk", Integer.valueOf(textFieldMilk.getText()))){

                textFieldMilk.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Ingredientes");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Ingredientes");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }
    }

    @FXML
    public void addCinnamon(){

        if(!textFieldCinnamon.getText().isEmpty() && textFieldCinnamon.getText() != null){
            if(drinkMachine.getIngredientsCompartment().
                    fill("cinnamon", Integer.valueOf(textFieldCinnamon.getText()))){

                textFieldCinnamon.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Ingredientes");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Ingredientes");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }
    }

    @FXML
    public void addChocolate(){

        if(!textFieldChocolate.getText().isEmpty() && textFieldChocolate.getText() != null){
            if(drinkMachine.getIngredientsCompartment().
                    fill("chocolate", Integer.valueOf(textFieldChocolate.getText()))){

                textFieldChocolate.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Ingredientes");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Ingredientes");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }
    }

    @FXML
    public void addSugar(){

        if(!textFieldSugar.getText().isEmpty() && textFieldSugar.getText() != null){
            if(drinkMachine.getIngredientsCompartment().
                    fill("sugar", Integer.valueOf(textFieldSugar.getText()))){

                textFieldSugar.setText("");
                initDisplay();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Compartimento de Ingredientes");
                alert.setHeaderText(null);
                alert.setContentText("O compartimento não suporta a quantidade inserida");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Compartimento de Ingredientes");
            alert.setHeaderText(null);
            alert.setContentText("Preencha o campo com a quantidade desejada");
            alert.showAndWait();
        }
    }

    private void initDisplay(){

        //Ingredients
        labelStatusMaintenance.setText("Em manutenção");
        labelWater.setText(String.valueOf(drinkMachine.getIngredientsCompartment().verifyAmount("water")));
        labelGrain.setText(String.valueOf(drinkMachine.getIngredientsCompartment().verifyAmount("coffee")));
        labelCinnamon.setText(String.valueOf(drinkMachine.getIngredientsCompartment().verifyAmount("cinnamon")));
        labelMilk.setText(String.valueOf(drinkMachine.getIngredientsCompartment().verifyAmount("milk")));
        labelChocolate.setText(String.valueOf(drinkMachine.getIngredientsCompartment().verifyAmount("chocolate")));
        labelSugar.setText(String.valueOf(drinkMachine.getIngredientsCompartment().verifyAmount("sugar")));

        //Cups
        labelCupP.setText(String.valueOf(drinkMachine.getCupsCompartment().verifyAmount("smallCup")));
        labelCupM.setText(String.valueOf(drinkMachine.getCupsCompartment().verifyAmount("mediumCup")));
        labelCupG.setText(String.valueOf(drinkMachine.getCupsCompartment().verifyAmount("bigCup")));

        //Coins ADD
        labelCoinFiveCentsAdd.setText(String.valueOf(drinkMachine.getCoinsCompartment().verifyAmount("fiveCents")));
        labelCoinTenCentsAdd.setText(String.valueOf(drinkMachine.getCoinsCompartment().verifyAmount("tenCents")));
        labelCoinTwentyFiveCentsAdd.setText(String.valueOf(drinkMachine.getCoinsCompartment().verifyAmount("twentyFiveCents")));
        labelCoinFiftyCentsAdd.setText(String.valueOf(drinkMachine.getCoinsCompartment().verifyAmount("fiftyCents")));
        labelCoinOneAdd.setText(String.valueOf(drinkMachine.getCoinsCompartment().verifyAmount("oneBRL")));

        //Coins Change Coin
        labelCoinFiveCents.setText(String.valueOf(drinkMachine.getCoinsCompartment().verifyAmount("fiveCents")));
        labelCoinTenCents.setText(String.valueOf(drinkMachine.getCoinsCompartment().verifyAmount("tenCents")));
        labelCoinTwentyFiveCents.setText(String.valueOf(drinkMachine.getCoinsCompartment().verifyAmount("twentyFiveCents")));
        labelCoinFiftyCents.setText(String.valueOf(drinkMachine.getCoinsCompartment().verifyAmount("fiftyCents")));
        labelCoinOne.setText(String.valueOf(drinkMachine.getCoinsCompartment().verifyAmount("oneBRL")));

    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
