package by.it.subach.jd02_08;

import com.sun.jmx.mbeanserver.NamedObject;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {
    public static void main(String[] args) {
        String fileName = "src/by/it/subach/jd02_08/Users.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            Element element = doc.getDocumentElement();
            printDom("", element);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDom(String prefix, Node node) {
        String tab = "";
        int type = node.getNodeType();
        String text = node.getNodeValue();
        if (type == Node.ELEMENT_NODE) {
            System.out.format(" %s<%s", prefix, node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attr = attributes.item(i);
                    System.out.format(" %s=%s", attr.getNodeName(), attr.getNodeValue());
                }
            }
            System.out.println(">");
        }

        prefix = prefix.concat("\t");
        if (text != null) {
            text = text.trim();
            if (text.length() > 0)
                System.out.println(prefix + text);
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix, children.item(i));
        }
        if (type == Node.ELEMENT_NODE) {
            System.out.printf("%s</%s>\n", prefix.substring(1), node.getNodeName());
        }
    }
}
