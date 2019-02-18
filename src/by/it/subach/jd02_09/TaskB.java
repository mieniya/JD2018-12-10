package by.it.subach.jd02_09;

import by.it.subach.jd02_09.beans.Users;
import com.google.gson.*;

import javax.xml.bind.*;
import java.io.File;

import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;


public class TaskB {

    private Users users;
    JAXBContext context;
    Gson gson;

    public TaskB() {
        try {
            context = JAXBContext.newInstance(Users.class);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        gson = new GsonBuilder().serializeNulls().create();
    }



    void readXml(){
        String xmlIn = System.getProperty("user.dir") + "/src/by/it/subach/jd02_09/users+xsd.xml";
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            users = (Users) unmarshaller.unmarshal(new File(xmlIn));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    String getJson(){
        return gson.toJson(users);
    }

    void readJson(String json){
        users = gson.fromJson(json, Users.class);
    }

    void saveXml(){
        String xmlOut = System.getProperty("user.dir") + "/src/by/it/subach/jd02_09/resultB.xml";

        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, new File(xmlOut));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    void printGson(){
        Gson gsonBuilder = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        System.out.println(gsonBuilder.toJson(users));
    }

    public static void main(String[] args) {
        TaskB instance = new TaskB();
        instance.readXml();
        String json = instance.getJson();
        instance.printGson();
        instance.readJson(json);
        instance.saveXml();
    }
}
