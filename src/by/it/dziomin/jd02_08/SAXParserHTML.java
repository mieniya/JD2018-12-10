package by.it.dziomin.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class SAXParserHTML {

    private final static String root = System.getProperty("user.dir")+"/src/by/it/dziomin/jd02_08/";

    public static void main(String[] args) {
        String fileName = root + "CarRent.xml";
        System.out.println(fileName);
        String fileHTML = root + "CarRent.html";
        System.out.println(fileHTML);

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(root + "СarRent.xsl"));
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }
}
