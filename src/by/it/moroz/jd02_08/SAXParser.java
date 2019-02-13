package by.it.moroz.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

class SAXParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        String xmlFile = System.getProperty("user.dir") + "/src/by/it/moroz/jd02_07/jd02_07_02/restaurant+xsd.xml";
        SAXHandler handler = new SAXHandler();
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = parserFactory.newSAXParser();
        saxParser.parse(xmlFile, handler);
    }
}
