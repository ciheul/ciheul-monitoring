import axes.pgw.core.Axes_XMLHandler;

public class Run_Test {

	public static void main(String args[]){
		System.out.println("Testing Application");
		//define input test
		String inputFile = "sample-input/ceksaldo_request.xml";
		Axes_XMLHandler xml_handler = new Axes_XMLHandler(inputFile);
		
	}
}
