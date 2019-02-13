package by.it.migunko.jd02_08;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
public class RunnerReorganise {
    public static void main(String[] args) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            String xslFile = "src/by/it/migunko/jd02_08/travels.xsl";
            Source xsl = new StreamSource(new File(xslFile));
            String input = "src/by/it/migunko/jd02_08/travels.xml";
            Source xml = new StreamSource(new File(input));
            String output = "src/by/it/migunko/jd02_08/travel.html";
            Result html=new StreamResult(output);
            Transformer transformer = transformerFactory.newTransformer(xsl);
            transformer.transform(xml,html);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
