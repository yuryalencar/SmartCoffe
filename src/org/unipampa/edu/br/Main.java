package org.unipampa.edu.br;

import javax.mail.MessagingException;

public class Main {

    public static void main(String[] args)  {

        System.out.println("SmartCoffe - An inteligent coffe machine");
        EmailCentral email = new EmailCentral();

        try{
            if(email.sendEmail("Teste")){
                System.out.println("Email enviado");
            }
        } catch(MessagingException me){
            System.out.println(me.getCause());
        }


    }
}
