package axes.pgw.sample;

import java.io.File;
import java.io.FileOutputStream;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.apache.xml.serialize.*;

public class XMLTestImpl {

     /**
     * @param args
     */
     public static void main(String[] args) {
          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          Element el;
          DocumentBuilder db = null;
          Document doc = null;
          Element root = null;
          XMLSerializer xmlSer;
          OutputFormat out;
          
          //Try to create the document builder 
          try
          {
               db = dbf.newDocumentBuilder();
               doc = db.newDocument();
          }
          catch (Exception e)
          {
               e.printStackTrace();
               System.exit(1);
          }
          
          //Creat the root class, called TEst
          root = doc.createElement("Test");
          doc.appendChild(root);
          
          //Create child node to root
          el = doc.createElement("child1");
          root.appendChild(el);
          
          //Set some arbitrary attribute
          root.setAttribute("String1", "root_node");
          el.setAttribute("String2", "child_node");
          
          //Write out to file using the serializer
          try
          {
               out = new OutputFormat(doc);
               out.setIndenting(true);
               
               xmlSer = new XMLSerializer(
               new FileOutputStream(new File("output/test.xml")), out);
               xmlSer.serialize(doc);
          }
          catch(Exception e)
          {
               e.printStackTrace();
          }
     }
}
