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

//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
//        Scene scene = new Scene(root);
//        stage.setTitle("SmartCoffe");
//        stage.setResizable(false);
//        stage.setScene(scene);
//        stage.show();
//        setStage(stage);
    }

    public static void main(String[] args) {

        // launch(args);

        System.out.println("SmartCoffee - An intelligent coffee machine");

        // Drink Machine Sample :)
         DrinkMachine machine = new DrinkMachine();

         System.out.println(machine.makeRecipeByType("cappuccino", 3, 2));

        //
        // ArrayList<Integer> coins= new ArrayList();
        // coins.add(10);
        // coins.add(10);
        // coins.add(25);
        // coins.add(50);
        // coins.add(50);
        // coins.add(100);
        //
        // System.out.println(machine.pay(coins, 2));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
