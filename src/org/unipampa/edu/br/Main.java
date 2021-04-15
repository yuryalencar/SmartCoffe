package org.unipampa.edu.br;

import javax.mail.MessagingException;

public class Main {

    public static void main(String[] args)  {

        System.out.println("SmartCoffee - An intelligent coffee machine");

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
        /*CupCompartment cups = new CupCompartment();

        for(int i=0;i<30;i++) {
            cups.take("smallCup", 1);
        }

        //cups.fill("smallCup", 100);

        System.out.println("Small cups: " + cups.verifyAmount("smallCup"));
        System.out.println("Medium cups: " + cups.verifyAmount("mediumCup"));
        System.out.println("Big cups: " + cups.verifyAmount("bigCup"));*/

    }
}
