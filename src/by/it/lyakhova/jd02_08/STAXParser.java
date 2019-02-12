package by.it.lyakhova.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class STAXParser {

    public static void main(String[] args) {
        STAXParser parser = new STAXParser();
        String xmlFile = System.getProperty("user.dir")+
                "/src/by/it/a_khmelev/jd02_07/users+att+xsd.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try(Reader reader =
                    new BufferedReader(
                            new FileReader(xmlFile))) {

            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
            StringBuilder xml = parser.process(xmlStreamReader);
            System.out.println(xml);
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }

    }

    private StringBuilder process(XMLStreamReader xml) throws XMLStreamException {

        StringBuilder elementTxt = new StringBuilder();
        StringBuilder xmlText = new StringBuilder();
        String tab = "";

        while (xml.hasNext()) {
            int type = xml.next();
            switch (type){
                /*case XMLStreamConstants
                        .START_DOCUMENT:
                    System.out.println("START_DOCUMENT");
                case XMLStreamConstants
                        .END_DOCUMENT:
                    System.out.println("END_DOCUMENT");*/ // don't work correctly
                case XMLStreamConstants
                        .START_ELEMENT:
                    xmlText.append(tab).append("<").append(xml.getLocalName());
                    int attCount = xml.getAttributeCount();
                    for (int i = 0; i < attCount; i++) {
                        String name = xml.getAttributeLocalName(i);
                        String value = xml.getAttributeValue(i);
                        String attText = String.format(" %s=\"%s\"", name, value);
                        xmlText.append(attText);
                    }
                    tab = tab.concat("\t");
                    xmlText.append(">\n");
                    //System.out.println("START_ELEMENT");
                    break;
                case XMLStreamConstants
                        .END_ELEMENT:
                    String text = elementTxt.toString().trim();
                    if (!text.isEmpty()){
                        xmlText.append(tab).append(text).append("\n");
                        elementTxt.setLength(0);
                    }
                    tab = tab.substring(1);
                    xmlText.append(tab).append("</").append(xml.getLocalName()).append(">\n");
                    //System.out.println("END_ELEMENT");
                    break;
                case XMLStreamConstants
                        .CHARACTERS:
                    elementTxt.append(xml.getText());
                    //System.out.println("CHARACTERS");
                    break;
            }
        }
        return xmlText;
    }
}
