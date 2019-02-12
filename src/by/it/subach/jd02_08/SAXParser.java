package by.it.subach.jd02_08;

import javax.xml.parsers.SAXParserFactory;

public class SAXParser {

    public static void main(String[] args) throws Exception {
        String path = System.getProperty("user.dir") + "/src/by/it/subach/jd02_07/Users.xml";

        SAXHandler myHandler = new SAXHandler();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();
//        saxParser.parse(path);




    }
}
