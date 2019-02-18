package by.it.subach.jd02_09.TaskC;


import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;

public class ConvertXmlToJson extends Converter {


    ConvertXmlToJson(Object beanClass) {
        super((Class) beanClass);
    }

    @Override
    public String getText() {
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(bean);
    }

    @Override
    public void load(String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            bean = unmarshaller.unmarshal(new ByteArrayInputStream(fileName.getBytes()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
