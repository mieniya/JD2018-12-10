package by.it.lyakhova.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class SAXHandler extends DefaultHandler {

    private StringBuilder xmlText;
    private StringBuilder elementTxt;
    private String tab;

    @Override
    public void startDocument() {
        elementTxt = new StringBuilder();
        xmlText = new StringBuilder();
        tab = "";
        //System.out.println("startDocument");
    }

    @Override
    public void endDocument() {
        System.out.println(xmlText);
        //System.out.println("endDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        xmlText.append(tab).append("<").append(qName);
        int attCount = attributes.getLength();
        for (int i = 0; i < attCount; i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            String attText = String.format(" %s=\"%s\"", name, value);
            xmlText.append(attText);
        }
        tab=tab.concat("\t");
        xmlText.append(">\n");
        //System.out.println("startElement: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String text = elementTxt.toString().trim();
        if (!text.isEmpty()){
            xmlText.append(tab).append(text).append("\n");
            elementTxt.setLength(0);
        }
        tab=tab.substring(1);
        xmlText.append(tab).append("</").append(qName).append(">\n");
        //System.out.println("endElement: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String part = new String(ch, start, length);
        elementTxt.append(part);

    }
}
