package crisminu.es;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainSAX {
    public static void main(String[] args) {

        try {
            File inputFile = new File("src/main/java/crisminu/es/catalogo.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            LeerXMLconSAX leer = new LeerXMLconSAX();
            saxParser.parse(inputFile, leer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
