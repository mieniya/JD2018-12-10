package by.it.moroz.jd02.jd02_09;


import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

class ConverterXmlToJson<Bean> extends Converter {

    ConverterXmlToJson(Class<Bean> beanClass){
        super(beanClass);
    }


    void load(String text){
        String xmlIn = System.getProperty("user.dir") + "/src/by/it/moroz/jd02_09/users+xsd.xml";
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            bean = unmarshaller.unmarshal(new File(xmlIn));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    String getText(){
        return gson.toJson(bean);
    }

}
