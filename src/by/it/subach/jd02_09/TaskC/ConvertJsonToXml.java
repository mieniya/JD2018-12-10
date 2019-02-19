package by.it.subach.jd02_09.TaskC;

import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

public class ConvertJsonToXml  extends Converter{

    ConvertJsonToXml(Class beanClass) {
        super(beanClass);
    }

    @Override
    public String getText() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
            StringWriter writer = new StringWriter();
            marshaller.marshal(bean, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void load(String fileName) {
       bean = new GsonBuilder().create().fromJson(fileName, beanClass);

    }
}
