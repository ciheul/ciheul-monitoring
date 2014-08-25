import axes.pgw.core.Axes_XMLBuilder;
import axes.pgw.core.Axes_XMLHandler;

public class Run_Test {

	public static void main(String args[]){
		System.out.println("Testing Application");
		//define input test
		String inputFile = "sample-input/ceksaldo_request.xml";
		Axes_XMLHandler xml_handler = new Axes_XMLHandler(inputFile);
		
		/**
		 * Testing construct XML File : 
		 * Options Parameters:
		 *    - value 0 : construct CEK SALDO RESPOND
		 *    - value 1 : construct POST-PAID INQUIRY RESPOND
		 *    - value 2 : construct POST-PAID PAYMENT RESPOND
		 *    - value 3 : construct PRE-PAID INQUIRY RESPOND
		 *    - value 4 : construct PRE-PAID PAYMENT RESPOND
		 *    
		 */
		
		Axes_XMLBuilder xml_builder = new Axes_XMLBuilder();
		xml_builder.ConstructXML(4);
		
		
	}
}
