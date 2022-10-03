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

            for (int i = 0; i < listaLibros.size(); i++) {
                Element libros = listaLibros.get(i);
                System.out.println("\nLibros :"
                        + libros.getName());
                Attribute att1 =  libros.getAttribute("id");
                System.out.println(att1.getValue() );
                System.out.println("Título : " + libros.getChild("titulo").getText());
                System.out.println("Autor : " + libros.getChild("autor").getAttribute("nombre"));
                System.out.println("Fecha de publicación: " + libros.getChild("fechapubl").getText());
                List<Element> listAutores =libros.getChildren("autor");
                    for(int t=0; i<listAutores.size(); t++){
                        Element autores = listAutores.get(t);
                        System.out.println("Fecha de nacimiento : " + autores.getChild("fechanac").getText());
                        System.out.println("Lugar de nacimiento : " + autores.getChild("lugar").getText());
                    }


            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
