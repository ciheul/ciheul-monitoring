package axes.pgw.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSException;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
 
public class WriteXmlFileLSSerializerExample {
 
public static void main(String[] args) {
    FileOutputStream fos = null;
        try {
            Document doc = buildSampleDOM();
            //Begin write DOM to file
            File f = new File("output/justexample.xml");
            fos = new FileOutputStream(f);
            DOMImplementationRegistry reg = DOMImplementationRegistry.newInstance();
            DOMImplementationLS impl = (DOMImplementationLS) reg.getDOMImplementation("LS");
            LSSerializer serializer = impl.createLSSerializer();
            LSOutput lso = impl.createLSOutput();
            lso.setByteStream(fos);
            serializer.write(doc,lso);
            //return serializer.writeToString(doc);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (DOMException e) {
            e.printStackTrace();
        } catch (LSException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(fos!=null){
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
 
    }
 
    private static Document buildSampleDOM() throws ParserConfigurationException{
        //building DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        doc.setXmlStandalone(true);
 
        //append root
        Element eleRoot = doc.createElement("root");
        //append element 1 to root
        Element ele1 = doc.createElement("exampleElement");
        ele1.setAttribute("exampleAttribute","attrValue");
        Node node1 = doc.createTextNode("ExampleTextNode");
        ele1.appendChild(node1);
        eleRoot.appendChild(ele1);
        //append element 2 to root
        Element ele2 = doc.createElement("exampleElement");
        ele2.setAttribute("exampleAttribute","attrValue");
        Node node2 = doc.createTextNode("ExampleTextNode2");
        ele2.appendChild(node2);
        eleRoot.appendChild(ele2);
        doc.appendChild(eleRoot);
 
        return doc;
    }
 
}
