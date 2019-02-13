package by.it.moroz.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {

    public static void main(String[] args) {

        DOMParser parser = new DOMParser();
        String xmlFile = System.getProperty("user.dir") + "/src/by/it/moroz/jd02_07/jd02_07_02/restaurant+xsd.xml";

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document parse = builder.parse(xmlFile);
            Element el = parse.getDocumentElement();
            parser.processDOM("", el);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private void processDOM(String text, Node node) {
        String txt = node.getNodeValue();
        if (txt != null) {
            System.out.println(text + txt.trim()+"</close>");
            NamedNodeMap attributes = node.getAttributes();
            if (attributes != null) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println(attributes.item(i));
                }
            }
        }
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            processDOM("<"+ node.getNodeName() + ">", nodes.item(i));
        }
    }
}
