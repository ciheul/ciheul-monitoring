package axes.pgw.sample;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;

public class MyFirstDomApp {

	// constructor
	public MyFirstDomApp (String xmlFile) throws SAXException {

		//  create a DOM parser
		DOMParser parser = new DOMParser();

		//  parse the document
		try {
			parser.parse(xmlFile);
			Document document = parser.getDocument();
			NodeDetails(document);

		}catch (IOException e) {
			System.err.println(e);
		}
	}


	// this function prints out information on a specific node
	// in this example, the "#document" node
	// it then goes to the next node
	// and does the same for that
	private void NodeDetails (Node node) {
		System.out.println ("Node Type:" + node.getNodeType() 
				+ "\nnNode Name:" + node.getNodeName());
		if(node.hasChildNodes()) {
			System.out.println 
			("Child Node Type:" + node.getFirstChild().getNodeType()+ "\nnNode Name:" + node.getFirstChild().getNodeName());
			Node nodechild = node.getFirstChild();
//			System.out.println(nodechild.getNodeValue());
			System.out.println("namechild: "+nodechild.getNodeName()+" type: "+nodechild.getNodeType());
			if(node.hasChildNodes()){
				Node secondChild = nodechild.getFirstChild();
				System.out.println("type: "+secondChild.getNodeType()+"; secondchild: "+secondChild.getNodeName());
//				System.out.println(secondChild.get);
				if(secondChild.hasChildNodes()){
					Node thirdChild = secondChild.getFirstChild();
					System.out.println("type: "+thirdChild.getNodeType()+"; secondchild: "+thirdChild.getNodeName());
				}else{
					System.out.println("end of child: "+secondChild.getNodeName());
				}
			}

		}
	}

	// the main method to create an instance of our DOM application

	public static void main (String[] args) throws SAXException {
		String xmlfile = "sample-input/sample1.xml";
		MyFirstDomApp MyFirstDomApp = new MyFirstDomApp (xmlfile);
	}
}

