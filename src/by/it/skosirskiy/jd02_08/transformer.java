package by.it.skosirskiy.jd02_08;

import org.xml.sax.InputSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

public class transformer {
    final static String root="src\\by\\it\\skosirskiy\\jd02_08\\";
    public static void main(String[] args) {
        String filename=root+"jku.xml";
        TransformerFactory tf= TransformerFactory.newInstance();
        try {
            Transformer transformer = tf.newTransformer(new StreamSource(root+"xpath.xsl"));
            transformer.transform(new StreamSource(filename), new StreamResult(root+"xpath.html"));
            System.out.println("Transform"+filename+" complete");
        } catch (TransformerException e) {
            e.printStackTrace();
            System.out.println("Impossible transform ");
        }
    }
}
