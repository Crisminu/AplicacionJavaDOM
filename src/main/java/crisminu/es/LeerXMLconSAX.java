package crisminu.es;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class LeerXMLconSAX extends DefaultHandler{

    boolean titulo = false;
    boolean autor = false;
    boolean fechanac = false;
    boolean lugar = false;
    boolean fechapubl = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if(qName.equalsIgnoreCase("libro")){
        }else if (qName.equalsIgnoreCase("titulo")) {
            titulo = true;
        }else if (qName.equalsIgnoreCase("autor")) {
            String nombre = attributes.getValue("nombre");
            System.out.println("Autor \n" + "Nombre : " + nombre);
             autor=true;
        }else if (qName.equalsIgnoreCase("fechanac")) {
            fechanac = true;
        }else if (qName.equalsIgnoreCase("lugar")) {
            lugar=true;
        }else if (qName.equalsIgnoreCase("fechapubl")) {
            fechapubl = true;
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("libro")){
            System.out.println(qName);
        }
    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (titulo) {
            System.out.println("Título: " + new String(ch, start, length));
            titulo = false;
        } else if (autor) {
            autor = false;
        } else if (fechanac) {
            System.out.println("Fecha de Nacimiento: " + new String(ch, start, length));
            fechanac = false;
        } else if (lugar) {
            System.out.println("Lugar: " + new String(ch, start, length));
            lugar = false;
        } else if (fechapubl) {
            System.out.println("Fecha de Publicación: " + new String(ch, start, length));
            fechapubl = false;
        }
    }
}
