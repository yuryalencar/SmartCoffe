package org.unipampa.edu.br;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CoffeMachine implements Initializable {

    //labels da tela principal
    @FXML
    private Label labelStatusCoffe;

    @FXML
    private Label labelCashBack;

    @FXML
    private TextField textFieldCoin;

    //label da tela de login
    @FXML
    private TextField textFieldEmail;

    //labels da tela de manutenção
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
    private Label labelGlassP;

    @FXML
    private Label labelGlassM;

    @FXML
    private Label labelGlassG;

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

    private Stage dialogStage;

    private ArrayList<Recipe> recipes;
    private Compartment cupsCompartment;
    private Compartment coinsCompartment;
    private Compartment ingredientsCompartment;
    private EmailCentral emailCentral;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        recipes = new ArrayList();
        cupsCompartment = new CupsCompartment();
        coinsCompartment = new CoinsCompartment();
        ingredientsCompartment = new IngredientsCompartment();
        this.emailCentral = new EmailCentral();

        this.loadRecipes();
        this.loadCompartments();
    }

    /**
     * Method to register coffee machine recipes
     */
    private void loadRecipes() {
        Recipe expressCoffee = new Recipe(200, 75, 535, 100, 10, 0, 0, 0);
        Recipe cappuccino = new Recipe(530, 310, 935, 100, 10, 50, 10, 2);
        Recipe coffeeWithMilk = new Recipe(530, 310, 935, 75, 10, 50, 0, 0);
        Recipe hotChocolate = new Recipe(600, 400, 910, 75, 0, 50, 50, 0);

        recipes.add(expressCoffee);
        recipes.add(cappuccino);
        recipes.add(coffeeWithMilk);
        recipes.add(hotChocolate);
    }

    /**
     * Method to load compartments in
     * coffee machine create.
     */
    private void loadCompartments() {
        cupsCompartment.fill("smallCup", 100);
        cupsCompartment.fill("mediumCup", 100);
        cupsCompartment.fill("bigCup", 100);

        coinsCompartment.fill("fiveCents", 30);
        coinsCompartment.fill("tenCents", 30);
        coinsCompartment.fill("twentyFiveCents", 30);
        coinsCompartment.fill("fiftyCents", 30);
        coinsCompartment.fill("oneBRL", 30);

        ingredientsCompartment.fill("water", 30000);
        ingredientsCompartment.fill("coffee", 3000);
        ingredientsCompartment.fill("milk", 15000);
        ingredientsCompartment.fill("cinnamon", 600);
        ingredientsCompartment.fill("chocolate", 15000);
        ingredientsCompartment.fill("sugar", 3600);
    }

    /**
     * Method to auth in coffee machine
     *
     * @param email present in email central
     * @return true if is authenticated
     */
    public Boolean auth(String email) {
        return email.equals(this.emailCentral.getTechnicianEmail());
    }

    /**
     * Method to take coins by type
     *
     * @param type coin type
     * @param amount amount coins to take
     * @return true if can take coins, and false if not
     */
    public Boolean takeCoins(String type, int amount) {
        return coinsCompartment.take(type, amount);
    }

    /**
     * Method to fill coins by type
     *
     * @param type coin type
     * @param amount amount coins to fill
     * @return true if can fill coins, and false if not
     */
    public Boolean fillCoins(String type, int amount) {
        return coinsCompartment.fill(type, amount);
    }

    /**
     * Method to fill cups by type
     *
     * @param type cup type
     * @param amount amount cups to fill
     * @return true if can fill cups, and false if not
     */
    public Boolean fillCups(String type, int amount) {
        return cupsCompartment.fill(type, amount);
    }

    /**
     * Method to fill ingredients by type
     *
     * @param type ingredient type
     * @param amount amount ingredients to fill
     * @return true if can fill ingredients, and false if not
     */
    public Boolean fillIngredients(String type, int amount) {
        return ingredientsCompartment.fill(type, amount);
    }

    /**
     * Method to get amount coins by type
     *
     * @param type coin type
     * @return return integer with amount coins
     */
    public Integer getAmountCoins(String type) {
        return coinsCompartment.verifyAmount(type);
    }

    /**
     * Method to get amount ingredients by type
     *
     * @param type ingredient type
     * @return return integer with amount ingredient
     */
    public Integer getAmountIngredients(String type) {
        return ingredientsCompartment.verifyAmount(type);
    }

    /**
     * Method to pay and calculate return change money.
     *
     * @param coins coins used to pay
     * @param price drink price
     * @return return change money coins in ArrayList
     */
    public ArrayList<Integer> pay(ArrayList<Integer> coins, double price) {
        int changeMoney = this.getChangeMoney(coins, price);

        if(this.hasChangeMoney(changeMoney)) {
            ;
        }

        // doing..
        return new ArrayList<Integer>();
    }

    /**
     * Method to return change money in cents format
     * for example: 2.5 BRL change money is 250 cents
     *
     * @param coins coins useds to pay
     * @param price drink price
     * @return return change money in cents
     */
    public Integer getChangeMoney(ArrayList<Integer> coins, double price){
        if(!this.canPay(coins, price))
            return -1;

        return this.getSumCoins(coins) - this.formatPrice(price);
    }

    /**
     * Method to verify if price can pay an drink
     *
     * @param coins coins useds to pay
     * @param price drink price
     * @return true if money can pay drink, and false if not
     */
    public Boolean canPay(ArrayList<Integer> coins, double price) {
        if(!this.validateCoins(coins) || !this.validatePrice(price))
            return false;

        int change = this.getSumCoins(coins) - this.formatPrice(price);
        return change > 0;
    }

    /**
     * Method to verify if has change money in
     * coins compartment.
     *
     * @param changeMoney - change money in cents
     * @return true if we has change money, and false if not
     */
    public Boolean hasChangeMoney(int changeMoney) {
        int amountMoney = 0;

        amountMoney += this.getAmountCoins("fiveCents") * 5;
        amountMoney += this.getAmountCoins("tenCents") * 10;
        amountMoney += this.getAmountCoins("twentyFiveCents") * 25;
        amountMoney += this.getAmountCoins("fiftyCents") * 50;
        amountMoney += this.getAmountCoins("oneBRL") * 100;

        return amountMoney >= changeMoney;
    }

    /**
     * Method to sum coins value
     *
     * @param coins array with coins
     * @return return coins sum
     */
    private Integer getSumCoins(ArrayList<Integer> coins) {
        int sumCoins = 0;
        for (int coin : coins) {
            sumCoins += coin;
        }
        return sumCoins;
    }

    /**
     * Method to format BRL price to BRL cent price
     *
     * @param price BRL price
     * @return BRL cent price
     */
    public Integer formatPrice(double price) {
        return (int) (price * 100);
    }

    /**
     * Method to validate amount price
     *
     * @param price BRL amount price
     * @return true if is an valid price and false if not
     */
    private Boolean validatePrice(double price) {
        int formattedPrice = this.formatPrice(price);
        return formattedPrice % 5 == 0;
    }

    /**
     * Method to validate inserted coins.
     *
     * @param coins array of the coins to validate
     * @return return true if is valid, and false if not
     */
    public Boolean validateCoins(ArrayList<Integer> coins) {
        boolean valid = true;
        for (int coin : coins) {
            if (coin != 5 && coin != 10 && coin != 25 && coin != 50 && coin != 100) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    //método que renderiza a tela de login
    @FXML
    public void loginMachineSettings() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CoffeMachine.class
                .getResource("/fxml/login.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        dialogStage = new Stage();
        CoffeMachine controller = loader.getController();
        controller.setDialogStage(dialogStage);
        // Criando um Estágio de Diálogo (Stage Dialog)

        dialogStage.setTitle("SmartCoffe");
        dialogStage.setResizable(false);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    //Método que renderiza a tela de configurações da cafeteira
    @FXML
    public void machineSettings() throws IOException{

        if(textFieldEmail.getText() != null && !textFieldEmail.getText().isEmpty()){
            if(emailCentral.getTechnicianEmail().equalsIgnoreCase(textFieldEmail.getText())){
                //Fecha o dialog de login e abre a tela de configuracoes da maquina
                dialogStage.close();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(CoffeMachine.class
                        .getResource("/fxml/maintenance.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                dialogStage = new Stage();
                CoffeMachine controller = loader.getController();
                controller.setDialogStage(dialogStage);
                // Criando um Estágio de Diálogo (Stage Dialog)

                dialogStage.setTitle("SmartCoffe - Configurações da Cafeteira");
                dialogStage.setResizable(false);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                dialogStage.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erro na autenticação");
                alert.setHeaderText(null);
                alert.setContentText("Email incorreto");
                alert.showAndWait();
            }
        }
    }

    //método que fecha a tela de configurações da máquina
    @FXML
    public void close() throws IOException{
        this.dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
