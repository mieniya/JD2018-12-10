package by.it.lyakhova.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {

    public static void main(String[] args) {
        String xmlFile = System.getProperty("user.dir")+
                "/src/by/it/a_khmelev/jd02_07/users+att+xsd.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            Element element = doc.getDocumentElement();
            printDom("", element);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDom(String prefix, Node node) {

        if (node.getNodeType()==node.ELEMENT_NODE) {
            System.out.print(prefix + "<" + node.getNodeName());
            NamedNodeMap att = node.getAttributes();
            for (int i = 0; i < att.getLength(); i++) {
                Node attr = att.item(i);
                System.out.print(" " + attr.getNodeName() + "=\"" + attr.getNodeValue() + "\"");
            }
            System.out.println(">");
        }

        String text=node.getNodeValue();
        if (text!=null) {
            String txt = text.trim();
            if (txt.length()>0) System.out.println(prefix + txt);
        }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix + "\t", children.item(i));
        }

        if (node.getNodeType()==node.ELEMENT_NODE) {
            System.out.println(prefix + "</" + node.getNodeName() + ">");
        }
    }
}
