package by.it.lyakhova.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransformer {

    private static String root = System.getProperty("user.dir")+
            "/src/by/it/lyakhova/jd02_08/";

    public static void main(String[] args) {
        String xmlFile = root + "users.xml";
        String htmlFile = root + "users.html";

        try {
            TransformerFactory transform = TransformerFactory.newInstance();
            Transformer transformer = transform.newTransformer(new StreamSource(root + "users.xsl"));
            transformer.transform(new StreamSource(xmlFile), new StreamResult(htmlFile));
            System.out.println("Transform " + xmlFile + " to " + htmlFile + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + xmlFile + " : " + e);
        }

    }
}
