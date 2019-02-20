package by.it.moroz.jd02.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransformer {

    public static void main(String[] args) {

        String xmlFile = System.getProperty("user.dir") + "/src/by/it/moroz/jd02_08/restaurant_clients.xml";
        String htmlFile = System.getProperty("user.dir") + "/src/by/it/moroz/jd02_08/restaurant_clients.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(System.getProperty("user.dir")
                    + "/src/by/it/moroz/jd02_08/restaurant.xsl"));
            transformer.transform(new StreamSource(xmlFile), new StreamResult(htmlFile));
            System.out.println("Transform complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform. " + e);
        }

    }
}
