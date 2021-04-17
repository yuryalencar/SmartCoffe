package org.unipampa.edu.br;


public class Main {

    public static void main(String[] args)  {

        System.out.println("SmartCoffee - An intelligent coffee machine");

        // Recipes
        Recipe expressCoffee = new Recipe(200, 75, 535, 100, 10,0,0,0);
        Recipe cappuccino = new Recipe(530, 310, 935, 100, 10,50,10,2);
        Recipe coffeeWithMilk = new Recipe(530, 310, 935, 75, 10,50,0,0);
        Recipe hotChocolate = new Recipe(600, 400, 910, 75, 0,50,50,0);

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

        for(int i=0;i<33;i++) {
            coins.take("oneBRL", 1);
        }

        coins.fill("oneBRL", 30);

        System.out.println("5 centavos: " + coins.verifyAmount("fiveCents"));
        System.out.println("50 centavos: " + coins.verifyAmount("fiftyCents"));
        System.out.println("1 real: " + coins.verifyAmount("oneBRL"));*/

    }
}
