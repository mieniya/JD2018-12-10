package by.it.titkovskaya.jd02_09.converter;

import by.it.titkovskaya.jd02_09.beans.Clients;
import java.io.File;

public class Runner {

    public static void main(String[] args) {
        ConverterFactory factory = new ConverterFactory<>();
        File source = new File((new Path()).getPath(Converter.class, "clients+xsd.xml"));
        File output = new File((new Path()).getPath(Converter.class, "outputXML.xml"));

        Converter converter = factory.getConverter(Direction.XML_TO_JSON, Clients.class);
        converter.load(source);
        String json = converter.getText();
        converter.load(json);

        converter = factory.getConverter(Direction.JSON_TO_XML, Clients.class);
        converter.load(json);
        converter.save(output,converter.getText());
    }

}
