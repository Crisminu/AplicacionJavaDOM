package crisminu.es;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("src/main/java/crisminu/es/catalogo.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("libro");
        System.out.println("Número de libros: " + nList.getLength());

        for(int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                    System.out.println("\nLibro id: " + eElement.getAttribute("id"));
                    System.out.println("Título: "
                            + eElement.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Autor: " + eElement.getElementsByTagName("autor").item(0).getAttributes().getNamedItem("nombre").getTextContent());
                    System.out.println("Fecha de Publicación: "
                            + eElement.getElementsByTagName("fechapubl").item(0).getTextContent());

            }
        }
    }
}