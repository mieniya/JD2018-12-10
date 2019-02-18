package by.it.dziomin.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParcer {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String xmlFile=System.getProperty("user.dir")+"/src/by/it/dziomin/jd02_08/CarRent.xml";
//        System.out.println(xmlFile);
        SAXHadler saxHadler = new SAXHadler();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(xmlFile,saxHadler);
    }


}
