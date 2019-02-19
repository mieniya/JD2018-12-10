package by.it.yarmolenka.jd02_09;

import by.it.yarmolenka.MathCalc.GetPath;
import by.it.yarmolenka.jd02_07.UsersValidator;
import by.it.yarmolenka.jd02_09.beans.Gamblers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {

    public static void main(String[] args) {
        String xmlIn = GetPath.getPath(UsersValidator.class) + "gamblers+xsd.xml";
        String xmlOut = getPath() + "gamblers+xsd_out.xml";

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Gamblers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Gamblers gamblers = (Gamblers) unmarshaller.unmarshal(new File(xmlIn));
            System.out.println(gamblers);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(gamblers, new File(xmlOut));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static String getPath() {
        String path = TaskA.class.getName().replace(".", File.separator)
                .replace(TaskA.class.getSimpleName(), "");
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
    }
}
