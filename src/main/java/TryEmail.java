
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
public class TryEmail {
    public static void sendMail(String recepient){
        Properties properties=new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccount="nehoraii555@gmail.com";
        String password="nehoraii0556652485@gmail.com";
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount,password);
            }
        });
        try {
            Message message=prepareMessage(session,myAccount,recepient);
            Transport.send(message);
        } catch (Exception e) {
            System.out.println("ERROR!!!!");
            System.out.println(e);
        }
        System.out.println("GOOD!!!");
    }
    private static Message prepareMessage(Session session,String myAcount, String recepient){
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(myAcount));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Try!!!");
            message.setText("How are you today???");
            return message;
        } catch (MessagingException e) {
            System.out.println(e);
        }
        return null;
    }

}
//אמור לעבוד אבל גוגל שינתה כך שלא יהיה אפשרות לעשות זאת
//לא לשכוח להוסיף את התקייה שאומרים בתחילת הסרטון