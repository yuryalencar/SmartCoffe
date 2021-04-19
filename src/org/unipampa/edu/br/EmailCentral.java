package org.unipampa.edu.br;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


public class EmailCentral {

    private String technicianEmail;

    public EmailCentral() {
        this.technicianEmail = "suportsmartcoffe@gmail.com";
    }

    public String getTechnicianEmail() {
        return technicianEmail;
    }

    public boolean sendEmail(String content) throws MessagingException {

        //Define uma sessao para realizar o envio do e-mail000
        Session session = getSession();
        MimeMessage msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(technicianEmail));
        //verificar se precisa cadastrar um funcionario de suporte, ja que vai precisar de login e senha
        Address[] toUser = InternetAddress.parse("jonaschagas10@gmail.com");
        msg.setRecipients(Message.RecipientType.TO, toUser);
        //verificar o formato que vai ser a msg
        msg.setSubject("Assunto");
        msg.setContent(getTemplate(content), "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);
        return true;
    }

    private Session getSession() {

        //Configura as propriedades para envio do e-mail
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        //cria a sessao e realiza a autenticacao do remetente
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(technicianEmail, "a1e2i3o4u5");
            }
        });
        return session;
    }

    private String getTemplate(String content) {

        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>");
        html.append("<html lang=en>");
        html.append("<head style='width: auto'>");
        html.append(" <meta charset= 'utf-8' />");
        html.append("<h3 style='background-color: lightgrey; text-align: center'>Falta de Ingrendientes</h3>");
        html.append("</head>");
        html.append("<body>");
        html.append("<div style='background-color: whitesmoke; margin-top: -15px' >");
        html.append(" <p>");
        html.append(" " + content);
        html.append(" </p>");
        html.append("</div>");
        html.append("</body>");
        html.append("<footer style='font-weight: bold; font-family: Arial; font-size: small; margin-top: -10px; background-color: lightgrey;'>");
        html.append(" <p>");
        html.append("  Suporte - SmartCoffe");
        html.append("  <br/>");
        html.append("  Contato: 055 - 99999-9999");
        html.append("  <br/>");
        html.append("  Email: suportsmartcoffe@gmail.com");
        html.append(" </p>");
        html.append("</footer>");
        html.append("</html>");

        return html.toString();
    }


}
