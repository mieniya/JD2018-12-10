package by.it.zagurskaya.jd02_09;

import by.it.zagurskaya.jd02_09.beans.User;
import by.it.zagurskaya.jd02_09.beans.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {

    public static void main(String[] args) {
        String xmlIn = System.getProperty("user.dir") +
                "/src/by/it/zagurskaya/jd02_09/users+xsd.xml";
        String xmlOut = System.getProperty("user.dir") +
                "/src/by/it/zagurskaya/jd02_09/users+xsd2.xml";

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(xmlIn));
            User vasya = users.getUser().get(0);
            vasya.setLogin("SuperVasyaP");
//            я закоментила
//            System.out.println(vasya.getAds().getAd().get(0).getDescription());

            //System.out.println(users);
            // jaxbContext - ok
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, new File(xmlOut));

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

}
