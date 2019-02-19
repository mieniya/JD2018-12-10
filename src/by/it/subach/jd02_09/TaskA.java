package by.it.subach.jd02_09;

import by.it.subach.jd02_09.beans.User;
import by.it.subach.jd02_09.beans.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        String xmlIn = System.getProperty("user.dir") + "/src/by/it/subach/jd02_09/users+xsd.xml";
        String xmlOut = System.getProperty("user.dir") + "/src/by/it/subach/jd02_09/users+xsdOut.xml";

        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(xmlIn));
            User user = users.getUser().get(0);
            user.setLogin("NowImUSER");
            System.out.println(user.getAds().getAd().get(0).getDescription());
            System.out.println(user.getLogin());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, new File(xmlOut));


        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
