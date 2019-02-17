package by.it.moroz.jd02.jd02_09;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


class ConverterJsonToXml<Bean> extends Converter {

    ConverterJsonToXml(Class<Bean> beanClass){
        super(beanClass);
    }

    String getText(){
        return gson.toJson(beanClass);
    }

    void load (String text){
        String xmlOut = System.getProperty("user.dir") + "/src/by/it/moroz/jd02_09/users+xsd2.xml";
        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(beanClass, new File(xmlOut));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
