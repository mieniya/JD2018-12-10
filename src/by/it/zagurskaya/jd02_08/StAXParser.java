package by.it.zagurskaya.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class StAXParser {
    private StringBuilder xmlTxt;
    private StringBuilder elementTxt;
    private String tab;

    public static void main(String[] args) {

        String xmlFile = System.getProperty("user.dir") + "src/by/it/zagurskaya/jd02_08/users+xsd.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try (
                Reader reader = new BufferedReader(new FileReader(xmlFile));

        ) {
            xmlInputFactory.createXMLStreamReader(reader);
//            proces();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();

        }
    }

    private StringBuilder process(XMLStreamReader xml) throws XMLStreamException {
        StringBuilder xmlTxt = new StringBuilder();
        StringBuilder elementTxt = new StringBuilder();
        String tab = "";
        while (xml.hasNext()) {
            int type = xml.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    xmlTxt.append(tab).append("<").append(xml.getLocalName());
                    int attCount = xml.getAttributeCount();
                    for (int i = 0; i < attCount; i++) {
                        String name = xml.getAttributeLocalName(i);
                        String value = xml.getAttributeValue(i);
                        String attText = String.format(" %s=\"%s\"", name, value);
                        xmlTxt.append(attText);
                    }
                    tab = tab.concat("\t");
                    xmlTxt.append(">\n");
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    String text = elementTxt.toString().trim();
                    if (!text.isEmpty()) {
                        xmlTxt.append(tab).append(text).append("\n");
                        elementTxt.setLength(0);
                    }
                    tab = tab.substring(1);
                    xmlTxt.append(tab).append("</").append(xml.getLocalName()).append(">\n");
                    break;
                case XMLStreamConstants.CHARACTERS:
                    elementTxt.append(xml.getText());
                    break;
            }

        }
        return xmlTxt;
    }
}
