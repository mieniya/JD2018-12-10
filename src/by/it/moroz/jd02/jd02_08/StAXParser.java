package by.it.moroz.jd02.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class StAXParser {

    public static void main(String[] args) {
        StAXParser parser = new StAXParser();
        String xmlFile = System.getProperty("user.dir") + "/src/by/it/moroz/jd02_07/jd02_07_02/restaurant+xsd.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (Reader reader = new BufferedReader(new FileReader(xmlFile))) {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
            System.out.println(parser.process(xmlStreamReader));
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }

    }

    private StringBuilder process(XMLStreamReader xml) throws XMLStreamException {
        StringBuilder xmlTxt = new StringBuilder();
        StringBuilder elementTxt = new StringBuilder();
        String tab = "";
        while (xml.hasNext()){
            int next = xml.next();
            switch (next){
                case XMLStreamConstants.START_ELEMENT:
                    xmlTxt.append(tab).append("<").append(xml.getLocalName());
                    int attCount = xml.getAttributeCount();
                    for (int i = 0; i < attCount; i++) {
                        String name = xml.getAttributeLocalName(i);
                        String value = xml.getAttributeValue(i);
                        String attr = String.format(" %s=\"%s\"", name, value);
                        xmlTxt.append(attr);
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
