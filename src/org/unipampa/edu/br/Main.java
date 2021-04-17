package org.unipampa.edu.br;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("SmartCoffe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static void main(String[] args)  {

        launch(args);

        System.out.println("SmartCoffee - An intelligent coffee machine");

        // Coffe Machine
        CoffeMachine machine = new CoffeMachine();

        ArrayList<Integer> coins= new ArrayList();
        coins.add(5);
        coins.add(10);
        coins.add(25);
        coins.add(50);
        coins.add(100);

        System.out.println(machine.pay(coins, 1));

        /* Teste de e-mail */
        /*EmailCentral email = new EmailCentral();
        try{
            if(email.sendEmail("Teste")){
                System.out.println("Email enviado");
            }
        } catch(MessagingException me){
            System.out.println(me.getCause());
        }*/

        /* Compartimento de copos */
        /*CupsCompartment cups = new CupsCompartment();

        for(int i=0;i<30;i++) {
            cups.take("smallCup", 1);
        }

        //cups.fill("smallCup", 100);

        System.out.println("Small cups: " + cups.verifyAmount("smallCup"));
        System.out.println("Medium cups: " + cups.verifyAmount("mediumCup"));
        System.out.println("Big cups: " + cups.verifyAmount("bigCup"));*/

        /* Compartimento de moedas */
        /*CoinsCompartment coins = new CoinsCompartment();

        coins.take("oneBRL", 30);

        coins.fill("oneBRL", 30);

        System.out.println("5 centavos: " + coins.verifyAmount("fiveCents"));
        System.out.println("50 centavos: " + coins.verifyAmount("fiftyCents"));
        System.out.println("1 real: " + coins.verifyAmount("oneBRL"));*/

        /* Compartimento de ingredientes */
        /*IngredientsCompartment ingr = new IngredientsCompartment();

        ingr.take("water", 230);

        //ingr.fill("water", 30000);

        System.out.println("Water: " + ingr.verifyAmount("water"));
        System.out.println("Coffee: " + ingr.verifyAmount("coffee"));
        System.out.println("Sugar: " + ingr.verifyAmount("sugar"));*/

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
