package by.it.yarmolenka.jd02_08;

import by.it.yarmolenka.MathCalc.GetPath;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLtoHTML {
    public static void main(String[] args) {
        String path = GetPath.getPath(XMLtoHTML.class);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(path + "gamblers.xsl"));
            transformer.transform(new StreamSource(path + "gamblers.xml"), new StreamResult(path + "gamblers.html"));
            System.out.println("Transformation of " + path + "gamblers.xml is complete");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
