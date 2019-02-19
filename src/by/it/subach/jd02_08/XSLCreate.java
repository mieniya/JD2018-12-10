package by.it.subach.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLCreate {
    private final static String root = "src/by/it/subach/jd02_08/";

    public static void main(String[] args) {
        String fileName = root + "users.xml";
        String fileHTML = root + "users.html";

        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer(new StreamSource(root + "users.xsl"));
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + fileName + ": " + e);
        }
    }

}
