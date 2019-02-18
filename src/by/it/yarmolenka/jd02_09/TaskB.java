package by.it.yarmolenka.jd02_09;

import by.it.yarmolenka.jd02_09.beans.Gamblers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private Gamblers gamblers;
    private JAXBContext jaxbContext;
    private Gson gson;

    public TaskB() {
        try {
            jaxbContext = JAXBContext.newInstance(Gamblers.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        gson = new GsonBuilder().serializeNulls().create();
    }

    private void readXml(){
        String xmlIn = getPath() + "gamblers+xsd_out.xml";
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            gamblers = (Gamblers) unmarshaller.unmarshal(new File(xmlIn));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private String getJson() {
        return gson.toJson(gamblers);
    }

    private void readJson(String json) {
        gamblers = gson.fromJson(json, Gamblers.class);
    }

    private void saveXml(){
        String xmlOut = getPath() + "resultTaskB.xml";
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(gamblers, new File(xmlOut));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private String getPath() {
        String path = TaskB.class.getName().replace(".", File.separator)
                .replace(TaskB.class.getSimpleName(), "");
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
    }

    public static void main(String[] args) {
        TaskB myTask = new TaskB();
        myTask.readXml();
        String json = myTask.getJson();
        System.out.println(json);
        myTask.readJson(json);
        myTask.saveXml();
    }
}
