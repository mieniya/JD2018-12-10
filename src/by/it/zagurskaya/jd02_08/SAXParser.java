package by.it.zagurskaya.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String xmlFile=System.getProperty("user.dir")+
                "/src/by/it/a_khmelev/jd02_07/users+att+xsd.xml";
        SAXHandler myHandler=new SAXHandler();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();
//        saxParser.parse(xmlFile,myHandler);
    }
}
