package axes.pgw.sample;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;

public class MySecondDomApp {

	// constructor
	public MySecondDomApp (String xmlFile) 
	{
		//  create a Xerces DOM parser
		DOMParser parser = new DOMParser();
		//  parse the document and
		// access the root node with its children

		try {
			try {
				parser.parse(xmlFile);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Document document = parser.getDocument();
			NodeDetails(document);

		} catch 
		(IOException e) {
			System.err.println (e);
		}

	}


	// this function drills deeper into the DOM tree
	private void NodeDetails (Node node) {
		// get the node name
		System.out.println (node.getNodeName());
		// check if the node has children
		if(node.hasChildNodes()) {
			// get the child nodes, if they exist
			NodeList children = node.getChildNodes();
			if (children != null) {
				for (int i=0; i< children.getLength(); i++) {
					// repeat the process for each child node
					// get the node name
					System.out.println ("t" +children.item(i).getNodeName());
							// check if the node has children
							if(children.item(i).hasChildNodes()) 
							{
								// get the children, if they exist
								NodeList childrenOfchildren = children.item(i).getChildNodes();
								if (childrenOfchildren != null) {
									// get the node name
									for (int j=0; j< childrenOfchildren.getLength();
											j++) 
									{
										System.out.println ("tt" +childrenOfchildren.item(j).getNodeName());

									}
								}
							}

				}
			}
		}
	}

	// the main method to create an instance of our DOM application
	public static void main (String[] args) 
	{
		String inputFile = "sample-input/ceksaldo_request.xml";
		MySecondDomApp MySecondDomApp = new MySecondDomApp (inputFile);

	}
}
