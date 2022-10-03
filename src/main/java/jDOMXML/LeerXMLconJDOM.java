package jDOMXML;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class LeerXMLconJDOM {
    public static void main(String[] args) {

        try {
            File inputFile = new File("src/main/java/crisminu/es/catalogo.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElement = document.getRootElement();

            List<Element> listaLibros = classElement.getChildren();
            System.out.println("----------------------------");

            for (Element libro: listaLibros) {
                //Element libro = listaLibros.get(i);
                System.out.println("\nLibros :" + libro.getName());
                Attribute att1 =  libro.getAttribute("id");
                System.out.println(att1.getValue() );
                System.out.println("Título : " + libro.getChild("titulo").getText());
                //System.out.println("Autor : " + libro.getChild("autor").getAttribute("nombre"));
                System.out.println("Fecha de publicación: " + libro.getChild("fechapubl").getText());
                List<Element> listAutores =libro.getChildren("autor");
                    for(Element autor: listAutores){
                        System.out.println("Autor: ");

                        Attribute att2 = autor.getAttribute("nombre");
                        System.out.println("Nombre: " + att2.getValue());
                        System.out.println("Fecha de nacimiento : " + autor.getChild("fechanac").getText());
                        System.out.println("Lugar de nacimiento : " + autor.getChild("lugar").getText());
                    }


            }
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }
}
