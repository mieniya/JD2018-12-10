package by.it.moroz.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class StAXParser {

    public static void main(String[] args) {
        String xmlFile = System.getProperty("user.dir") + "/src/by/it/moroz/jd02_07/jd02_07_02/restaurant+xsd.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (Reader reader = new BufferedReader(new FileReader(xmlFile))) {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
            process(xmlStreamReader);
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }

    }

    private static void process(XMLStreamReader xmlStreamReader) throws XMLStreamException {
        while (xmlStreamReader.hasNext()){
            int next = xmlStreamReader.next();
            switch (next){
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("Start element");
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End element");
                case XMLStreamConstants.CHARACTERS:
                    System.out.println("characters");
            }
        }
    }
}
