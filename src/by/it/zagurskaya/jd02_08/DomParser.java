package by.it.zagurskaya.jd02_08;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//
public class DomParser {

    private static final String OPEN_TAG = "<";
    private static final String CLOSE_TAG = ">";
    private static final String TAB = "    ";
    public static final String EMPTY_NODE = "#text";

    public static void main(String[] args) {
        //runner
        //возьмем пример из предыдущего занятия
//        String fileName = "src/by/it/_examples_/JD02_07/01+XSD.xml";
        String fileName = System.getProperty("user.dir") +
                "/src/by/it/zagurskaya/jd02_08/users+xsd.xml";
        //создадим фабрику и стандартный парсер
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            Element rootElement = doc.getDocumentElement();
//            NodeList nList = doc.getElementsByTagName(doc.getNodeName());
            printDom("", rootElement);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }

    //Демо. Рекурсивный обход DOM-дерева.
    //На уровень C самостоятельно разберитесь, как переделать вывод в формате обычного XML
    //а также как и где извлечь значение и аттрибуты узла
    private static void printDom(String prefix, Node node) {
        Map<String, String> attributeMap = getNodeListAsList(node.getAttributes());

        String attributeString = (attributeMap).entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(" "));
        String massage = prefix + OPEN_TAG + node.getNodeName() +
                (attributeString.isEmpty() ? "" : " " + attributeString) +
                CLOSE_TAG;

        System.out.println(massage);

        List<Node> nodeList = getNodeListAsList(node.getChildNodes());
        if (!nodeList.isEmpty()) {
            nodeList.forEach(n -> printDom(TAB + prefix, n));
        } else if (node.getTextContent().trim().length() != 0) {
            System.out.println(TAB + prefix + node.getTextContent());
        }

        System.out.println(prefix + OPEN_TAG + "/" + node.getNodeName() + CLOSE_TAG);
    }

    private static List<Node> getNodeListAsList(NodeList nodeList) {
        return IntStream.range(0, nodeList.getLength())
                .mapToObj(i -> nodeList.item(i))
                .filter(n -> !n.getNodeName().equals(EMPTY_NODE))
                .collect(Collectors.toList());
    }

    //    private static List<Node> getNodeListAsList(NodeList nodeList) {
//        final List<Node> nodes = new ArrayList<>();
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Node item = nodeList.item(i);
//            if (!item.getNodeName().equals("#text")) {
//                nodes.add(item);
//            }
//        }
//        return nodes;
//    }
//
//    private static List<Node> getNodeListAsList(NodeList nodeList) {
//        final List<Node> nodes = new ArrayList<>();
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            nodes.add(nodeList.item(i));
//        }
//        return nodes;
//    }
//
    private static Map<String, String> getNodeListAsList(NamedNodeMap namedNodeMap) {
        return Optional.ofNullable(namedNodeMap)
                .map(map -> IntStream.range(0, map.getLength())
                        .mapToObj(i -> map.item(i))
                        .collect(Collectors.toMap(n -> n.getNodeName(), n -> n.getNodeValue())))
                .orElse(Collections.emptyMap());
    }
//    private static Map<String, String> getNodeListAsList(NamedNodeMap namedNodeMap) {
//        if (namedNodeMap == null) {
//            return Collections.emptyMap();
//        }
//        return IntStream.range(0, namedNodeMap.getLength())
//                .mapToObj(i -> namedNodeMap.item(i))
//                .collect(Collectors.toMap(n -> n.getNodeName(), n -> n.getNodeValue()));
//    }
//    private static Map<String, String> getNodeListAsList(NamedNodeMap namedNodeMap) {
//        if (namedNodeMap == null) {
//            return Collections.emptyMap();
//        }
//        final Map<String, String> map = new LinkedHashMap<>();
//        for (int i = 0; i < namedNodeMap.getLength(); i++) {
//            map.put(namedNodeMap.item(i).getNodeName(), namedNodeMap.item(i).getNodeValue());
//        }
//        return map;
//    }
}

