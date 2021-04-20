package org.unipampa.edu.br;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class CoffeeMachine implements Initializable {

    @FXML
    private Label labelStatusCoffe;

    @FXML
    private Label labelStatusCoins;

    @FXML
    private Label labelCashBack;

    @FXML
    private Label labelChangeCoin;

    @FXML
    private ComboBox<String> comboCoins;

    @FXML
    private Button buttonWithDraw;

    @FXML
    private Button buttonInit;

    @FXML
    private Button buttonCoffeeBig;

    @FXML
    private Button buttonChocolateBig;

    @FXML
    private Button buttonCappuccinoBig;

    @FXML
    private Button buttonMilkBig;

    Stage dialogStage;

    private EmailCentral emailCentral;

    private DrinkMachine drinkMachine;

    private Order order;

    public ArrayList<Integer> coins;

    FeedBackController controller;

    public CoffeeMachine() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailCentral = new EmailCentral();
        drinkMachine = DrinkMachine.getInstance();
        order = new Order();
        coins = new ArrayList<Integer>();
        loadComboCoins();
        buttonWithDraw.setDisable(true);
        labelStatusCoffe.setText("Disponível");
    }

    //método que renderiza a tela de login
    @FXML
    public void loginMachineSettings() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginController.class
            .getResource("/fxml/login.fxml"));
        AnchorPane page2 = (AnchorPane) loader.load();

        dialogStage = new Stage();
        LoginController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        // Criando um Estágio de Diálogo (Stage Dialog)

        dialogStage.setTitle("SmartCoffe");
        dialogStage.setResizable(false);
        Scene scene = new Scene(page2);
        dialogStage.setScene(scene);
        dialogStage.show();

    }

    @FXML
    public void withDraw(){
        coins.clear();
        atualizaLabelCoins();
        buttonWithDraw.setDisable(true);
        labelStatusCoffe.setText("Disponível");
        labelChangeCoin.setText("Troco");
    }

    @FXML
    public void insertCoin(){

        if(comboCoins.getValue() != null){
            addCoin(comboCoins.getValue());
            comboCoins.getSelectionModel().clearSelection();
            atualizaLabelCoins();
        }
    }

    @FXML
    public void onClickInit() {

        if(order.getCoffe() != null && order.getSugar() != null){
            labelStatusCoffe.setText("Sua bebida está sendo preparada");
            buttonInit.setDisable(true);
        }
    }

    @FXML
    public void makeDrink() throws InterruptedException {

        boolean madeCoffee = false;
        ArrayList changeCoins = new ArrayList<Integer>();
        String titleError = "";
        String msgError = "";

        if(order.getCoffe() != null && order.getSugar() != null){
            if(drinkMachine.canPay(coins, order.getCoffe().price)){
                if(drinkMachine.hasChangeCoins()){
                    makesDrink();
                }
                else{
                    titleError = "Troco";
                    msgError = "A máquina está com nivel baixo de moedas, possivelmente afete no troco. Deseja prosseguir?";
                    if(confirmDrink(titleError, msgError)){
                        makesDrink();
                    } else{
                        labelStatusCoffe.setText("Pedido cancelado");
                        buttonInit.setDisable(false);
                        cancelDrink();

                    }
                }
            }
            else{
                titleError = "Pagamento";
                msgError = "O valor inserido é menor que o valor da bebida";
                errorMessage(titleError, msgError);
                buttonInit.setDisable(false);
                labelStatusCoffe.setText("Disponível");
            }
        } else{
            titleError = "Pedido";
            msgError = "Selecione uma bebida e um nivel de açucar";
            errorMessage(titleError, msgError);
            buttonInit.setDisable(false);
            labelStatusCoffe.setText("Disponível");
        }
    }

    @FXML
    public void cancelDrink(){

        if(!coins.isEmpty() && coins != null){
            buttonWithDraw.setDisable(false);
        }
        order.setSugar(null);
        order.setCoffe(null);
    }

    @FXML
    public void expressCoffeeP(){
        order.setCoffe(EnumInterfaceCoffe.EXPRESS_COFFEE_P);
        atualizaLabelStatus(order);
    }

    @FXML
    public void expressCoffeeM(){
        order.setCoffe(EnumInterfaceCoffe.EXPRESS_COFFEE_M);
        System.out.println("Expresso M " + order.getCoffe().drink);
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }
    @FXML
    public void expressCoffeeG(){
        order.setCoffe(EnumInterfaceCoffe.EXPRESS_COFFEE_G);
        System.out.println("Expresso G " + order.getCoffe().drink);
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }

    @FXML
    public void chocolateCoffeeP(){
        order.setCoffe(EnumInterfaceCoffe.CHOCOLATE_COFFEE_P);
        System.out.println("Chocolate P " + order.getCoffe().drink);
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }

    @FXML
    public void chocolateCoffeeM(){
        order.setCoffe(EnumInterfaceCoffe.CHOCOLATE_COFFEE_M);
        System.out.println("Chocolate M " + order.getCoffe().drink);
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }
    @FXML
    public void chocolateCoffeeG(){
        order.setCoffe(EnumInterfaceCoffe.CHOCOLATE_COFFEE_G);
        System.out.println("Chocolate G " + order.getCoffe().drink);
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }

    @FXML
    public void cappuccinoCoffeeP(){
        order.setCoffe(EnumInterfaceCoffe.CAPPUCCINO_COFFEE_P);
        System.out.println("Cappuccino P " + order.getCoffe().drink);
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }

    @FXML
    public void cappuccinoCoffeeM(){
        order.setCoffe(EnumInterfaceCoffe.CAPPUCCINO_COFFEE_M);
        System.out.println("Cappuccino M " + order.getCoffe().drink);
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }
    @FXML
    public void cappuccinoCoffeeG(){
        order.setCoffe(EnumInterfaceCoffe.CAPPUCCINO_COFFEE_G);
        System.out.println("Cappuccino G " + order.getCoffe().drink);
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }

    @FXML
    public void milkCoffeeP(){
        order.setCoffe(EnumInterfaceCoffe.MILK_COFFEE_P);
        System.out.println("Leite P" + order.getCoffe().drink);
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }

    @FXML
    public void milkCoffeeM(){
        order.setCoffe(EnumInterfaceCoffe.MILK_COFFEE_M);
        System.out.println("Leite M" + order.getCoffe());
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }
    @FXML
    public void milkCoffeeG(){
        order.setCoffe(EnumInterfaceCoffe.MILK_COFFEE_G);
        System.out.println("Leite G" + order.getCoffe());
        System.out.println("Preço " + EnumInterfaceCoffe.getPrice(order.getCoffe().id));
        atualizaLabelStatus(order);
    }

    @FXML
    public void sugarS(){
        order.setSugar(EnumInterfaceCoffe.getSizeSugar(EnumInterfaceCoffe.SUGAR_S.size));
        System.out.println("Acucar S " + order.getSugar());
        atualizaLabelStatus(order);
    }
    @FXML
    public void sugarP(){
        order.setSugar(EnumInterfaceCoffe.getSizeSugar(EnumInterfaceCoffe.SUGAR_P.size));
        System.out.println("Acucar P" + order.getSugar());
        atualizaLabelStatus(order);
    }

    @FXML
    public void sugarM(){
        order.setSugar(EnumInterfaceCoffe.getSizeSugar(EnumInterfaceCoffe.SUGAR_M.size));
        System.out.println("Acucar M" + order.getSugar());
        atualizaLabelStatus(order);
    }
    @FXML
    public void sugarG(){
        order.setSugar(EnumInterfaceCoffe.getSizeSugar(EnumInterfaceCoffe.SUGAR_G.size));
        System.out.println("Acucar G" + order.getSugar());
        atualizaLabelStatus(order);
    }

    private void makesDrink() throws InterruptedException {

        boolean madeCoffee = false;
        ArrayList changeCoins = new ArrayList<Integer>();
        String titleError = "";
        String msgError = "";

        madeCoffee = drinkMachine.makeRecipeByType(order.getCoffe().drink, order.getCoffe().size,
                EnumInterfaceCoffe.getSizeSugarInt(order.getSugar()));

        changeCoins = drinkMachine.pay(coins, order.getCoffe().price);

        if(madeCoffee) {
            Thread.sleep(5000);
            coins.clear();

            if (!changeCoins.isEmpty() && changeCoins != null) {
                buttonWithDraw.setDisable(false);
                buttonInit.setDisable(false);
                labelStatusCoffe.setText("Sua bebida está pronta, retire seu troco");
                labelChangeCoin.setText(setChagenCoin(changeCoins));
                coins.addAll(changeCoins);
                //controller.getDialogStage().close();
            } else {
                buttonInit.setDisable(false);
                labelStatusCoffe.setText("Sua bebida esta pronta");
                //controller.getDialogStage().close();
            }
            atualizaLabelCoins();
            order.setCoffe(null);
            order.setSugar(null);
        }

    }

    private boolean confirmDrink(String title, String msg){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            return true;
        } else {
            return false;
        }
    }

    private void errorMessage(String title, String msg){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private String setChagenCoin(ArrayList<Integer> listCoin){

        String str = "";
        String format;
        double result = 0;
        for(Integer item: listCoin){
            if(str.isEmpty()){
                result = (double) item/100;
                format = String.format("%.2f", result);
                str = String.format("Troco: R$ %s", format);
            }else{
                result = (double) item/100;
                format = String.format("%.2f", result);
                str += (String.format(", R$ %s", format));
            }
        }
        return str;
    }

    private void addCoin(String value){

        if(value.equalsIgnoreCase("R$ 1,00")){
            coins.add(100);

        }
        else if(value.equalsIgnoreCase("R$ 0,50")){
            coins.add(50);

        }
        else if(value.equalsIgnoreCase("R$ 0,25")){
            coins.add(25);

        }
        else if(value.equalsIgnoreCase("R$ 0,10")){
            coins.add(10);

        }
        else{
            coins.add(5);

        }
    }

    private void atualizaLabelStatus(Order order){

        if(order.getCoffe() != null && order.getSugar() != null){
            labelStatusCoffe.setText("Bebida: " + EnumInterfaceCoffe.getDrink(order.getCoffe().drink) +
                    " Tamanho: " + EnumInterfaceCoffe.getSizeDrink(order.getCoffe().size) +
                    " Açucar: " + order.getSugar());
        }
    }


    private void atualizaLabelCoins(){

        double total = 0;
        String format;

        for(Integer i : coins){
            total += i;
        }
        if(!coins.isEmpty() && coins != null){
            total = total/100;
            format = String.format("%.2f", total);
            labelStatusCoins.setText("R$: " + format);
        }
        else{
            labelStatusCoins.setText("");
        }
    }

    private void loadComboCoins(){
        comboCoins.getItems().add("R$ 1,00");
        comboCoins.getItems().add("R$ 0,50");
        comboCoins.getItems().add("R$ 0,25");
        comboCoins.getItems().add("R$ 0,10");
        comboCoins.getItems().add("R$ 0,05");
    }

    public FeedBackController getController() {
        return controller;
    }

    public void setController(FeedBackController controller) {
        this.controller = controller;
    }

    public void setDialogStage(Stage dialogStage) {

        this.dialogStage = dialogStage;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }
}



