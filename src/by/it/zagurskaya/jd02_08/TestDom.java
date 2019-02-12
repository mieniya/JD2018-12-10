package by.it.zagurskaya.jd02_08;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//
public class TestDom {
    public static void main(String[] args) {
        //runner
        //возьмем пример из предыдущего занятия
//        String fileName = "src/by/it/_examples_/JD02_07/01+XSD.xml";
        String fileName=System.getProperty("user.dir")+
                "/src/by/it/zagurskaya/jd02_08/users+xsd.xml";
        //создадим фабрику и стандартный парсер
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc=builder.parse(fileName);
            Element el=doc.getDocumentElement();
//            NodeList nList = doc.getElementsByTagName(doc.getNodeName());
            printDom("<", el);
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }

    //Демо. Рекурсивный обход DOM-дерева.
    //На уровень C самостоятельно разберитесь, как переделать вывод в формате обычного XML
    //а также как и где извлечь значение и аттрибуты узла
    private static void printDom(String prefix, Node node) {
        String text=node.getNodeValue();
        System.out.println("text" + text );
        if (text!=null) {
//            System.out.println( "prefix" + prefix);
//            System.out.println( prefix + text.trim());
        }
//        NamedNodeMap attrs = node.getAttributes();
//        Element eElemen = (Element) node;
//        for (int i = 0; i < attrs.getLength(); i++) {
//            Node attr = attrs.item(i);
////            eElemen.setAttribute(attr.getNodeName(), attr.getNodeValue());
//            System.out.println(eElemen.getElementsByTagName(attr.getNodeName()));
//            System.out.println(eElemen.getElementsByTagName(attr.getNodeValue()));
//        }




        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node nNode = children.item(i);
            System.out.println("111   " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                NamedNodeMap m = eElement.getAttributes();
                for (int j = 0; i < m.getLength(); ++i)
                {
                    Node attr = m.item(j);
                    System.out.println("5555" + attr.getNodeName() + " = \"" + attr.getNodeValue() + "\"");
                }

//                String valueString = m.getNamedItem(children.item(i).getNodeName()).getNodeName();
//                System.out.println("444444 " + valueString);
                System.out.println("22222222 user: "
                        + eElement.getAttribute("user"));
                System.out.println("3333332 nickname: "
                        + eElement.getAttribute("nickname"));
            }







//            Element eElement = (Element) children.item(i);
            System.out.println("children.getLength() =" +children.getLength());
//            System.out.println(" eElement.getTagName() =" +eElement.getTagName());
            System.out.println("node.getNodeName() =" + node.getNodeName());
//            System.out.println("node.getTextContent() =" + node.getTextContent());
            System.out.println("node.getChildNodes() =" + node.getChildNodes());
            System.out.println("node.getNodeValue() =" + node.getNodeValue());
//            System.out.println("children.item(i).getTextContent "+i + "  " + children.item(i).getTextContent());
            System.out.println("children.item(i).getNodeName() "+i + "  " + children.item(i).getNodeName());
            System.out.println("children.item(i).getNodeValue() "+i + "  " + children.item(i).getNodeValue());
            System.out.println("children.item(i) "+i + "  " + children.item(i).getPrefix());
            System.out.println("=============================");
//            printDom(prefix+node.getNodeName() + " > ", children.item(i));
        }
    }
}

