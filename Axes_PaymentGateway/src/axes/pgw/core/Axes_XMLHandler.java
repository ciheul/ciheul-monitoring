package axes.pgw.core;

import java.io.IOException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Axes_XMLHandler {
	private Document document_result;
	private NodeList childrenOfchildren;
	
	//Parse input File into XML DOM
	public Axes_XMLHandler(String inputFile){
		DOMParser parser = new DOMParser();
		try {
			try {
				parser.parse(inputFile);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			document_result = parser.getDocument();
			NodeDetails(document_result);
			HandlerLogical(childrenOfchildren);
		}catch (IOException e) {
			System.err.println(e);
		}
	}

	/* Extract information from Axes XML format. Then save it into list of nodes.
	 * This function will suitable only with REQUEST message 
	 */
	private void NodeDetails (Node node) {
		if(node.hasChildNodes()) {
			NodeList children = node.getChildNodes();
			if (children != null) {
				for (int i=0; i< children.getLength(); i++) {
					if(children.item(i).hasChildNodes()) 
					{
						childrenOfchildren = children.item(i).getChildNodes();
					}

				}
			}
		}
	}
	
	private void HandlerLogical(NodeList listofnodes){
		//get tag TRXTYPE
		Node trx_type = childrenOfchildren.item(5);
		String val_trx_type = trx_type.getTextContent();
		System.out.println ("TRXTYPE: "+val_trx_type);
		
		//do handler for each TRXTYPE
		if(val_trx_type.equals("balanceinfo")){
			System.out.println("Doing Handler for \"balanceinfo\"");
			//TODO create ceksaldo_respond.xml
			
		}else if(val_trx_type.equals("inqpostpaid")){
			System.out.println("Doing Handler for \"inqpostpaid\"");
			//TODO create ceksaldo_respond.xml
			
		}else if(val_trx_type.equals("paypostpaid")){
			System.out.println("Doing Handler for \"paypostpaid\"");
			//TODO create ceksaldo_respond.xml
			
		}else{
			System.out.println("TRXTYPE is not recognize");
		}
		
	}

}
