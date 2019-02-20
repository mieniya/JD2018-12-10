package by.it.dziomin.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHadler extends DefaultHandler {

    private StringBuilder xmlText;
    private String tab;
    private StringBuilder elementTxt;


    @Override
    public void startDocument() throws SAXException {
        xmlText = new StringBuilder();
        tab = "";
        elementTxt = new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(xmlText);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        int attCount = attributes.getLength();
        xmlText.append(tab).append("<").append(qName);
        for (int i = 0; i < attCount; i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            String attr = String.format(" %s=\"%s\"", name, value);
            xmlText.append(attr);
        }
//        xmlText.append(tab).append("<").append(qName).append(">");
        tab = tab.concat("\t");
        xmlText.append(">\n");

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String text = elementTxt.toString().trim();
        if (!text.isEmpty()) {
            xmlText.append(tab).append(text).append("\n");
            elementTxt.setLength(0);
        }
        tab = tab.substring(1);
        xmlText.append(tab).append("</").append(qName).append(">\n");


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part=new String(ch,start,length);
        elementTxt.append(part);
    }
}
