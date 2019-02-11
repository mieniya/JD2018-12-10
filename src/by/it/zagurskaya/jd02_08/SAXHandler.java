package by.it.zagurskaya.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler {
    private StringBuilder xmlTxt;
    private StringBuilder elementTxt;
    private String tab;

    public class SAXParserHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("startDocument");
            xmlTxt = new StringBuilder();
            elementTxt = new StringBuilder();
            tab = "";

        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println(xmlTxt);
            System.out.println("endDocument");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//            System.out.println("startElement"+qName);
            //выводим атрибуты тэга
            int attCount = attributes.getLength();
            for (int i = 0; i <attCount ; i++) {
                String name = attributes.getLocalName(i);
                String value = attributes.getValue(i);
                String attText = String.format("%s=\"%s",name,value);
                xmlTxt.append(attText);

            }
            xmlTxt.append(tab).append("<").append(qName);
            tab = tab.concat("\t");
            xmlTxt.append(">\n");


        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
//            System.out.println("endtElement"+qName);
            String text = elementTxt.toString().trim();
            if (!text.isEmpty()){
                xmlTxt.append(tab).append(text).append("\n");
                //очистили elementTxt
                elementTxt.setLength(0);
            }

            tab = tab.substring(1);
            xmlTxt.append(tab).append("</").append(qName).append(">\n");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String part =new String(ch,start,length);
            elementTxt.append(part);
        }
    }
}
