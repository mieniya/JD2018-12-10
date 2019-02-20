package by.it.migunko.jd00_02;

import by.it.a_khmelev.jd02_09.beans.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private Users users;

    private JAXBContext jaxbContext;
    private Gson gson;

    public TaskB() {
        try {
            jaxbContext = JAXBContext.newInstance(Users.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        gson = new GsonBuilder()
                .serializeNulls()

                .create();
    }

    private void readXml() {
        String xmlIn = System.getProperty("user.dir") +
                "/src/by/it/a_khmelev/jd02_09/users+xsd.xml";
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            users = (Users) unmarshaller.unmarshal(new File(xmlIn));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private String getJson(){
        return  gson.toJson(users);
    }

    private void readJson(String json) {
        users = gson.fromJson(json, Users.class);
    }


    private void saveXml() {
        String xmlOut = System.getProperty("user.dir") +
                "/src/by/it/a_khmelev/jd02_09/users+xsd2.xml";

        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, new File(xmlOut));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        TaskB instance = new TaskB();

        instance.readXml();
        String json = instance.getJson();
        System.out.println(json);
        instance.readJson(json);
        instance.saveXml();

    }
}
