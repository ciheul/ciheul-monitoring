package axes.pgw.core;

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

public class Axes_XMLBuilder {
	public void ConstructXML(int typeOfmessage){
		FileOutputStream fos = null;
		try {
			//Begin write DOM to file
			switch(typeOfmessage){
			case 0: // construct CEK SALDO RESPOND
			{
				Document doc = buildCekSaldoRspnd();
				File f = new File("output/ceksaldo_respond.xml");
				fos = new FileOutputStream(f);

				DOMImplementationRegistry reg = DOMImplementationRegistry.newInstance();
				DOMImplementationLS impl = (DOMImplementationLS) reg.getDOMImplementation("LS");
				LSSerializer serializer = impl.createLSSerializer();
				LSOutput lso = impl.createLSOutput();
				lso.setByteStream(fos);
				serializer.write(doc,lso);
				break;
			}
			case 1: // construct POST-PAID INQUIRY RESPOND
			{
				Document doc = buildPostpaidInquiryResp();
				File f = new File("output/postpaid_inquiry_respond.xml");
				fos = new FileOutputStream(f);

				DOMImplementationRegistry reg = DOMImplementationRegistry.newInstance();
				DOMImplementationLS impl = (DOMImplementationLS) reg.getDOMImplementation("LS");
				LSSerializer serializer = impl.createLSSerializer();
				LSOutput lso = impl.createLSOutput();
				lso.setByteStream(fos);
				serializer.write(doc,lso);
				break;
			}

			case 2: // construct POST-PAID PAYMENT RESPOND
			{
				Document doc = buildPostpaidPaymentResp();
				File f = new File("output/postpaid_payment_respond.xml");
				fos = new FileOutputStream(f);

				DOMImplementationRegistry reg = DOMImplementationRegistry.newInstance();
				DOMImplementationLS impl = (DOMImplementationLS) reg.getDOMImplementation("LS");
				LSSerializer serializer = impl.createLSSerializer();
				LSOutput lso = impl.createLSOutput();
				lso.setByteStream(fos);
				serializer.write(doc,lso);			
				break;
			}

			case 3: // construct PRE-PAID INQUIRY RESPOND
			{
				Document doc = buildPrepaidInquiryResp();
				File f = new File("output/prepaid_inquiry_respond.xml");
				fos = new FileOutputStream(f);

				DOMImplementationRegistry reg = DOMImplementationRegistry.newInstance();
				DOMImplementationLS impl = (DOMImplementationLS) reg.getDOMImplementation("LS");
				LSSerializer serializer = impl.createLSSerializer();
				LSOutput lso = impl.createLSOutput();
				lso.setByteStream(fos);
				serializer.write(doc,lso);		
				break;
			}

			case 4: // construct PRE-PAID PAYMENT RESPOND
			{
				Document doc = buildPrepaidPaymentResp();
				File f = new File("output/prepaid_payment_respond.xml");
				fos = new FileOutputStream(f);

				DOMImplementationRegistry reg = DOMImplementationRegistry.newInstance();
				DOMImplementationLS impl = (DOMImplementationLS) reg.getDOMImplementation("LS");
				LSSerializer serializer = impl.createLSSerializer();
				LSOutput lso = impl.createLSOutput();
				lso.setByteStream(fos);
				serializer.write(doc,lso);			
				break;
			}

			default: 
				break;

			}


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

	private static Document buildCekSaldoRspnd() throws ParserConfigurationException{
		//building DOM
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		doc.setXmlStandalone(true);

		//append root
		Element eleRoot = doc.createElement("root");
		//append element UID to root
		Element ele1 = doc.createElement("UID");
		Node node1 = doc.createTextNode("testing"); //TODO fill this with real value
		ele1.appendChild(node1);
		eleRoot.appendChild(ele1);

		//append element PWD to root
		Element ele2 = doc.createElement("PWD");
		Node node2 = doc.createTextNode("testing123");//TODO fill this with real value
		ele2.appendChild(node2);
		eleRoot.appendChild(ele2);

		//append element TRXTYPE to root
		Element ele3 = doc.createElement("TRXTYPE");
		Node node3 = doc.createTextNode("balanceinfo");//TODO fill this with real value
		ele3.appendChild(node3);
		eleRoot.appendChild(ele3);

		//append element BILLERCODE to root
		Element ele4 = doc.createElement("BILLERCODE");
		Node node4 = doc.createTextNode("1234");//TODO fill this with real value
		ele4.appendChild(node4);
		eleRoot.appendChild(ele4);

		//finish construct
		doc.appendChild(eleRoot);
		return doc;
	}

	private static Document buildPostpaidInquiryResp() throws ParserConfigurationException{
		//building DOM
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		doc.setXmlStandalone(true);

		//append root
		Element eleRoot = doc.createElement("root");
		//append element TRXTYPE to root
		Element ele1 = doc.createElement("TRXTYPE");
		Node node1 = doc.createTextNode("inqpostpaidresp"); //TODO fill this with real value
		ele1.appendChild(node1);
		eleRoot.appendChild(ele1);

		//append element ERRORCODE to root
		Element ele2 = doc.createElement("ERRORCODE");
		Node node2 = doc.createTextNode("00");//TODO fill this with real value
		ele2.appendChild(node2);
		eleRoot.appendChild(ele2);

		//append element BILLERCODE to root
		Element ele3 = doc.createElement("BILLERCODE");
		Node node3 = doc.createTextNode("000");//TODO fill this with real value
		ele3.appendChild(node3);
		eleRoot.appendChild(ele3);

		//append element UNIQUEID to root
		Element ele4 = doc.createElement("UNIQUEID");
		Node node4 = doc.createTextNode("53807123123");//TODO fill this with real value
		ele4.appendChild(node4);
		eleRoot.appendChild(ele4);

		//append element PRODUCTCODE to root
		Element ele5 = doc.createElement("PRODUCTCODE");
		Node node5 = doc.createTextNode("2112");//TODO fill this with real value
		ele5.appendChild(node5);
		eleRoot.appendChild(ele5);

		//append element TID to root
		Element ele6 = doc.createElement("TID");
		Node node6 = doc.createTextNode("1234567890123456");//TODO fill this with real value
		ele6.appendChild(node6);
		eleRoot.appendChild(ele6);

		//append element AMOUNT to root
		Element ele7 = doc.createElement("AMOUNT");
		Node node7 = doc.createTextNode("100000");//TODO fill this with real value
		ele7.appendChild(node7);
		eleRoot.appendChild(ele7);

		//append element MESSAGE to root
		Element ele8 = doc.createElement("MESSAGE");
		ele8.setAttribute("count","13");
		//adding sub element for DISPLAY1
		Element ele8_sub1 = doc.createElement("DISPLAY1");
		Node node8_sub1 = doc.createTextNode("PEMBAYARN TAGIHAN PLN");//TODO fill this with real value
		ele8_sub1.appendChild(node8_sub1);
		ele8.appendChild(ele8_sub1);
		//adding sub element for DISPLAY2
		Element ele8_sub2 = doc.createElement("DISPLAY2");
		Node node8_sub2 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub2.appendChild(node8_sub2);
		ele8.appendChild(ele8_sub2);
		//adding sub element for DISPLAY3
		Element ele8_sub3 = doc.createElement("DISPLAY3");
		Node node8_sub3 = doc.createTextNode("ID PELANGGAN : 123456789");//TODO fill this with real value
		ele8_sub3.appendChild(node8_sub3);
		ele8.appendChild(ele8_sub3);
		//adding sub element for DISPLAY4
		Element ele8_sub4 = doc.createElement("DISPLAY4");
		Node node8_sub4 = doc.createTextNode("NAME : FAHRURAZI");//TODO fill this with real value
		ele8_sub4.appendChild(node8_sub4);
		ele8.appendChild(ele8_sub4);
		//adding sub element for DISPLAY5
		Element ele8_sub5 = doc.createElement("DISPLAY5");
		Node node8_sub5 = doc.createTextNode("TARIF/DAYA : 1000/0001300");//TODO fill this with real value
		ele8_sub5.appendChild(node8_sub5);
		ele8.appendChild(ele8_sub5);
		//adding sub element for DISPLAY6
		Element ele8_sub6 = doc.createElement("DISPLAY6");
		Node node8_sub6 = doc.createTextNode("BLNTHN : 0107");//TODO fill this with real value
		ele8_sub6.appendChild(node8_sub6);
		ele8.appendChild(ele8_sub6);
		//adding sub element for DISPLAY7
		Element ele8_sub7 = doc.createElement("DISPLAY7");
		Node node8_sub7 = doc.createTextNode("STAND METER : 0000100 - 0000200");//TODO fill this with real value
		ele8_sub7.appendChild(node8_sub7);
		ele8.appendChild(ele8_sub7);
		//adding sub element for DISPLAY8
		Element ele8_sub8 = doc.createElement("DISPLAY8");
		Node node8_sub8 = doc.createTextNode("NON SUBSIDI : RP. 100.000");//TODO fill this with real value
		ele8_sub8.appendChild(node8_sub8);
		ele8.appendChild(ele8_sub8);
		//adding sub element for DISPLAY9
		Element ele8_sub9 = doc.createElement("DISPLAY9");
		Node node8_sub9 = doc.createTextNode("RP TAG PLN : Rp. 500.000 ");//TODO fill this with real value
		ele8_sub9.appendChild(node8_sub9);
		ele8.appendChild(ele8_sub9);
		//adding sub element for DISPLAY10
		Element ele8_sub10 = doc.createElement("DISPLAY10");
		Node node8_sub10 = doc.createTextNode("ADMIN BANK : Rp. 5000 </");//TODO fill this with real value
		ele8_sub10.appendChild(node8_sub10);
		ele8.appendChild(ele8_sub10);
		//adding sub element for DISPLAY11
		Element ele8_sub11 = doc.createElement("DISPLAY11");
		Node node8_sub11 = doc.createTextNode("TOTAL BARAR : Rp. 505.000");//TODO fill this with real value
		ele8_sub11.appendChild(node8_sub11);
		ele8.appendChild(ele8_sub11);
		//adding sub element for DISPLAY12
		Element ele8_sub12 = doc.createElement("DISPLAY12");
		Node node8_sub12 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub12.appendChild(node8_sub12);
		ele8.appendChild(ele8_sub12);
		//adding sub element for DISPLAY13
		Element ele8_sub13 = doc.createElement("DISPLAY13");
		Node node8_sub13 = doc.createTextNode("APAKAH ANDA AKAN MELAKUKAN PEMBAYARAN?");//TODO fill this with real value
		ele8_sub13.appendChild(node8_sub13);
		ele8.appendChild(ele8_sub13);
		eleRoot.appendChild(ele8);

		//finish construct
		doc.appendChild(eleRoot);
		return doc;
	}

	private static Document buildPrepaidInquiryResp() throws ParserConfigurationException{
		//building DOM
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		doc.setXmlStandalone(true);

		//append root
		Element eleRoot = doc.createElement("root");
		//append element TRXTYPE to root
		Element ele1 = doc.createElement("TRXTYPE");
		Node node1 = doc.createTextNode("inqpostpaidresp"); //TODO fill this with real value
		ele1.appendChild(node1);
		eleRoot.appendChild(ele1);

		//append element ERRORCODE to root
		Element ele2 = doc.createElement("ERRORCODE");
		Node node2 = doc.createTextNode("00");//TODO fill this with real value
		ele2.appendChild(node2);
		eleRoot.appendChild(ele2);

		//append element BILLERCODE to root
		Element ele3 = doc.createElement("BILLERCODE");
		Node node3 = doc.createTextNode("000");//TODO fill this with real value
		ele3.appendChild(node3);
		eleRoot.appendChild(ele3);

		//append element UNIQUEID to root
		Element ele4 = doc.createElement("UNIQUEID");
		Node node4 = doc.createTextNode("11111111111");//TODO fill this with real value
		ele4.appendChild(node4);
		eleRoot.appendChild(ele4);

		//append element PRODUCTCODE to root
		Element ele5 = doc.createElement("PRODUCTCODE");
		Node node5 = doc.createTextNode("2111");//TODO fill this with real value
		ele5.appendChild(node5);
		eleRoot.appendChild(ele5);

		//append element TID to root
		Element ele6 = doc.createElement("TID");
		Node node6 = doc.createTextNode("13443188358913632");//TODO fill this with real value
		ele6.appendChild(node6);
		eleRoot.appendChild(ele6);

		//append element AMOUNT to root
		Element ele7 = doc.createElement("AMOUNT");
		Node node7 = doc.createTextNode("0");//TODO fill this with real value
		ele7.appendChild(node7);
		eleRoot.appendChild(ele7);

		//append element OPTION to root
		Element ele8 = doc.createElement("OPTION");
		ele8.setAttribute("count","5");
		//adding sub element for OPT1
		Element ele8_sub1 = doc.createElement("OPT1");
		ele8_sub1.setAttribute("val", "20000");
		Node node8_sub1 = doc.createTextNode("20.000");//TODO fill this with real value
		ele8_sub1.appendChild(node8_sub1);
		ele8.appendChild(ele8_sub1);
		//adding sub element for OPT2
		Element ele8_sub2 = doc.createElement("OPT2");
		ele8_sub2.setAttribute("val", "50000");
		Node node8_sub2 = doc.createTextNode("50.000");//TODO fill this with real value
		ele8_sub2.appendChild(node8_sub2);
		ele8.appendChild(ele8_sub2);
		//adding sub element for OPT3
		Element ele8_sub3 = doc.createElement("OPT3");
		ele8_sub3.setAttribute("val", "100000");
		Node node8_sub3 = doc.createTextNode("100.000");//TODO fill this with real value
		ele8_sub3.appendChild(node8_sub3);
		ele8.appendChild(ele8_sub3);
		//adding sub element for OPT4
		Element ele8_sub4 = doc.createElement("OPT4");
		ele8_sub4.setAttribute("val", "250000");
		Node node8_sub4 = doc.createTextNode("250.000");//TODO fill this with real value
		ele8_sub4.appendChild(node8_sub4);
		ele8.appendChild(ele8_sub4);
		//adding sub element for OPT5
		Element ele8_sub5 = doc.createElement("OPT5");
		ele8_sub1.setAttribute("val", "500000");
		Node node8_sub5 = doc.createTextNode("500.000");//TODO fill this with real value
		ele8_sub5.appendChild(node8_sub5);
		ele8.appendChild(ele8_sub5);
		eleRoot.appendChild(ele8);

		//append element UNSOLD to root
		Element ele9 = doc.createElement("UNSOLD");
		ele9.setAttribute("count","3");
		//adding sub element for UNSOLD1
		Element ele9_sub1 = doc.createElement("UNSOLD1");
		ele9_sub1.setAttribute("val", "20000");
		Node node9_sub1 = doc.createTextNode("20.000");//TODO fill this with real value
		ele9_sub1.appendChild(node9_sub1);
		ele9.appendChild(ele9_sub1);
		//adding sub element for UNSOLD2
		Element ele9_sub2 = doc.createElement("UNSOLD2");
		ele9_sub2.setAttribute("val", "50000");
		Node node9_sub2 = doc.createTextNode("50.000");//TODO fill this with real value
		ele9_sub2.appendChild(node9_sub2);
		ele9.appendChild(ele9_sub2);
		//adding sub element for UNSOLD3
		Element ele9_sub3 = doc.createElement("UNSOLD3");
		Node node9_sub3 = doc.createTextNode("Token Baru");//TODO fill this with real value
		ele9_sub3.appendChild(node9_sub3);
		ele9.appendChild(ele9_sub3);
		eleRoot.appendChild(ele9);

		//append element MESSAGE to root
		Element ele10 = doc.createElement("MESSAGE");
		ele10.setAttribute("count","7");
		//adding sub element for DISPLAY1
		Element ele10_sub1 = doc.createElement("DISPLAY1");
		Node node10_sub1 = doc.createTextNode(" PEMBELIAN TOKEN PREPAID PLN");//TODO fill this with real value
		ele10_sub1.appendChild(node10_sub1);
		ele10.appendChild(ele10_sub1);
		//adding sub element for DISPLAY2
		Element ele10_sub2 = doc.createElement("DISPLAY2");
		Node node10_sub2 = doc.createTextNode("");//TODO fill this with real value
		ele10_sub2.appendChild(node10_sub2);
		ele10.appendChild(ele10_sub2);
		//adding sub element for DISPLAY3
		Element ele10_sub3 = doc.createElement("DISPLAY3");
		Node node10_sub3 = doc.createTextNode("NOMOR METER : 11111111111</");//TODO fill this with real value
		ele10_sub3.appendChild(node10_sub3);
		ele10.appendChild(ele10_sub3);
		//adding sub element for DISPLAY4
		Element ele10_sub4 = doc.createElement("DISPLAY4");
		Node node10_sub4 = doc.createTextNode("TARIF/DAYA : R1 /000000900 VA</");//TODO fill this with real value
		ele10_sub4.appendChild(node10_sub4);
		ele10.appendChild(ele10_sub4);
		//adding sub element for DISPLAY5
		Element ele10_sub5 = doc.createElement("DISPLAY5");
		Node node10_sub5 = doc.createTextNode("NAMA : H MAMAT ");//TODO fill this with real value
		ele10_sub5.appendChild(node10_sub5);
		ele10.appendChild(ele10_sub5);
		//adding sub element for DISPLAY6
		Element ele10_sub6 = doc.createElement("DISPLAY6");
		Node node10_sub6 = doc.createTextNode("");//TODO fill this with real value
		ele10_sub6.appendChild(node10_sub6);
		ele10.appendChild(ele10_sub6);
		//adding sub element for DISPLAY7
		Element ele10_sub7 = doc.createElement("DISPLAY7");
		Node node10_sub7 = doc.createTextNode("SILAHKAN MEMILIH NILAI PEMBELIAN</");//TODO fill this with real value
		ele10_sub7.appendChild(node10_sub7);
		ele10.appendChild(ele10_sub7);
		eleRoot.appendChild(ele10);

		//finish construct
		doc.appendChild(eleRoot);
		return doc;
	}

	private static Document buildPostpaidPaymentResp() throws ParserConfigurationException{
		//building DOM
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		doc.setXmlStandalone(true);

		//append root
		Element eleRoot = doc.createElement("root");
		//append element TRXTYPE to root
		Element ele1 = doc.createElement("TRXTYPE");
		Node node1 = doc.createTextNode("paypostpaidresp"); //TODO fill this with real value
		ele1.appendChild(node1);
		eleRoot.appendChild(ele1);

		//append element ERRORCODE to root
		Element ele2 = doc.createElement("ERRORCODE");
		Node node2 = doc.createTextNode("00");//TODO fill this with real value
		ele2.appendChild(node2);
		eleRoot.appendChild(ele2);

		//append element BILLERCODE to root
		Element ele3 = doc.createElement("BILLERCODE");
		Node node3 = doc.createTextNode("000");//TODO fill this with real value
		ele3.appendChild(node3);
		eleRoot.appendChild(ele3);

		//append element UNIQUEID to root
		Element ele4 = doc.createElement("UNIQUEID");
		Node node4 = doc.createTextNode("53807123123");//TODO fill this with real value
		ele4.appendChild(node4);
		eleRoot.appendChild(ele4);

		//append element PRODUCTCODE to root
		Element ele5 = doc.createElement("PRODUCTCODE");
		Node node5 = doc.createTextNode("2112");//TODO fill this with real value
		ele5.appendChild(node5);
		eleRoot.appendChild(ele5);

		//append element TID to root
		Element ele6 = doc.createElement("TID");
		Node node6 = doc.createTextNode("1234567890123456");//TODO fill this with real value
		ele6.appendChild(node6);
		eleRoot.appendChild(ele6);

		//append element AMOUNT to root
		Element ele7 = doc.createElement("AMOUNT");
		Node node7 = doc.createTextNode("100000");//TODO fill this with real value
		ele7.appendChild(node7);
		eleRoot.appendChild(ele7);

		//append element MESSAGE to root
		Element ele8 = doc.createElement("MESSAGE");
		ele8.setAttribute("count","13");
		//adding sub element for DISPLAY1
		Element ele8_sub1 = doc.createElement("DISPLAY1");
		Node node8_sub1 = doc.createTextNode(" BANK BII ");//TODO fill this with real value
		ele8_sub1.appendChild(node8_sub1);
		ele8.appendChild(ele8_sub1);
		//adding sub element for DISPLAY2
		Element ele8_sub2 = doc.createElement("DISPLAY2");
		Node node8_sub2 = doc.createTextNode("30/06/2011 18:00:00 123456 ");//TODO fill this with real value
		ele8_sub2.appendChild(node8_sub2);
		ele8.appendChild(ele8_sub2);
		//adding sub element for DISPLAY3
		Element ele8_sub3 = doc.createElement("DISPLAY3");
		Node node8_sub3 = doc.createTextNode("SARINAH THAMRIN JKT NO:123456 ");//TODO fill this with real value
		ele8_sub3.appendChild(node8_sub3);
		ele8.appendChild(ele8_sub3);
		//adding sub element for DISPLAY4
		Element ele8_sub4 = doc.createElement("DISPLAY4");
		Node node8_sub4 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub4.appendChild(node8_sub4);
		ele8.appendChild(ele8_sub4);
		//adding sub element for DISPLAY5
		Element ele8_sub5 = doc.createElement("DISPLAY5");
		Node node8_sub5 = doc.createTextNode("STRUK PEMBAYARAN TAGIHAN LISTRIK ");//TODO fill this with real value
		ele8_sub5.appendChild(node8_sub5);
		ele8.appendChild(ele8_sub5);
		//adding sub element for DISPLAY6
		Element ele8_sub6 = doc.createElement("DISPLAY6");
		Node node8_sub6 = doc.createTextNode("IDPELANGGAN : 1234567890 BLTHN : MEI,11 ");//TODO fill this with real value
		ele8_sub6.appendChild(node8_sub6);
		ele8.appendChild(ele8_sub6);
		//adding sub element for DISPLAY7
		Element ele8_sub7 = doc.createElement("DISPLAY7");
		Node node8_sub7 = doc.createTextNode("NAMA : FAHRURAZI STAND METER : 00001123-00001234");//TODO fill this with real value
		ele8_sub7.appendChild(node8_sub7);
		ele8.appendChild(ele8_sub7);
		//adding sub element for DISPLAY8
		Element ele8_sub8 = doc.createElement("DISPLAY8");
		Node node8_sub8 = doc.createTextNode("TARIF/DAYA : 1000/00001300 NON SUBSIDI : RP. 100.000");//TODO fill this with real value
		ele8_sub8.appendChild(node8_sub8);
		ele8.appendChild(ele8_sub8);
		//adding sub element for DISPLAY9
		Element ele8_sub9 = doc.createElement("DISPLAY9");
		Node node8_sub9 = doc.createTextNode("RP TAG PLN : 500.000  ");//TODO fill this with real value
		ele8_sub9.appendChild(node8_sub9);
		ele8.appendChild(ele8_sub9);
		//adding sub element for DISPLAY10
		Element ele8_sub10 = doc.createElement("DISPLAY10");
		Node node8_sub10 = doc.createTextNode("AJREF : 1214212121321312 </");//TODO fill this with real value
		ele8_sub10.appendChild(node8_sub10);
		ele8.appendChild(ele8_sub10);
		//adding sub element for DISPLAY11
		Element ele8_sub11 = doc.createElement("DISPLAY11");
		Node node8_sub11 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub11.appendChild(node8_sub11);
		ele8.appendChild(ele8_sub11);
		//adding sub element for DISPLAY12
		Element ele8_sub12 = doc.createElement("DISPLAY12");
		Node node8_sub12 = doc.createTextNode("PLN Menyatakan Struk Ini Sebagai Bukti Pembayaran Yg Sah");//TODO fill this with real value
		ele8_sub12.appendChild(node8_sub12);
		ele8.appendChild(ele8_sub12);
		//adding sub element for DISPLAY13
		Element ele8_sub13 = doc.createElement("DISPLAY13");
		Node node8_sub13 = doc.createTextNode("MOHON DISIMPAN");//TODO fill this with real value
		ele8_sub13.appendChild(node8_sub13);
		ele8.appendChild(ele8_sub13);
		//adding sub element for DISPLAY14
		Element ele8_sub14 = doc.createElement("DISPLAY14");
		Node node8_sub14 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub14.appendChild(node8_sub14);
		ele8.appendChild(ele8_sub14);
		//adding sub element for DISPLAY15
		Element ele8_sub15 = doc.createElement("DISPLAY15");
		Node node8_sub15 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub15.appendChild(node8_sub15);
		ele8.appendChild(ele8_sub15);
		//adding sub element for DISPLAY16
		Element ele8_sub16 = doc.createElement("DISPLAY16");
		Node node8_sub16 = doc.createTextNode("ADMIN BANK : RP. 5.000 </");//TODO fill this with real value
		ele8_sub16.appendChild(node8_sub16);
		ele8.appendChild(ele8_sub16);
		//adding sub element for DISPLAY17
		Element ele8_sub17 = doc.createElement("DISPLAY17");
		Node node8_sub17 = doc.createTextNode("ADMIN BANK : RP. 505.000 </");//TODO fill this with real value
		ele8_sub17.appendChild(node8_sub17);
		ele8.appendChild(ele8_sub17);
		//adding sub element for DISPLAY18
		Element ele8_sub18 = doc.createElement("DISPLAY18");
		Node node8_sub18 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub18.appendChild(node8_sub18);
		ele8.appendChild(ele8_sub18);
		//adding sub element for DISPLAY19
		Element ele8_sub19 = doc.createElement("DISPLAY19");
		Node node8_sub19 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub19.appendChild(node8_sub19);
		ele8.appendChild(ele8_sub19);
		//adding sub element for DISPLAY20
		Element ele8_sub20 = doc.createElement("DISPLAY20");
		Node node8_sub20 = doc.createTextNode("Anda memili sisa tunggakan 1 bulan");//TODO fill this with real value
		ele8_sub20.appendChild(node8_sub20);
		ele8.appendChild(ele8_sub20);
		//adding sub element for DISPLAY21
		Element ele8_sub21 = doc.createElement("DISPLAY21");
		Node node8_sub21 = doc.createTextNode("Info lebih lanjut silahkan akses </");//TODO fill this with real value
		ele8_sub21.appendChild(node8_sub21);
		ele8.appendChild(ele8_sub21);
		//adding sub element for DISPLAY22
		Element ele8_sub22 = doc.createElement("DISPLAY22");
		Node node8_sub22 = doc.createTextNode("www.pln.co.id atau kantor PLN");//TODO fill this with real value
		ele8_sub22.appendChild(node8_sub22);
		ele8.appendChild(ele8_sub22);
		//adding sub element for DISPLAY23
		Element ele8_sub23 = doc.createElement("DISPLAY23");
		Node node8_sub23 = doc.createTextNode("INFORMASI HUB: 123");//TODO fill this with real value
		ele8_sub23.appendChild(node8_sub23);
		ele8.appendChild(ele8_sub23);

		eleRoot.appendChild(ele8);

		//finish construct
		doc.appendChild(eleRoot);
		return doc;
	}
	
	private static Document buildPrepaidPaymentResp() throws ParserConfigurationException{
		//building DOM
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		doc.setXmlStandalone(true);

		//append root
		Element eleRoot = doc.createElement("root");
		//append element TRXTYPE to root
		Element ele1 = doc.createElement("TRXTYPE");
		Node node1 = doc.createTextNode("payprepaidresp"); //TODO fill this with real value
		ele1.appendChild(node1);
		eleRoot.appendChild(ele1);

		//append element ERRORCODE to root
		Element ele2 = doc.createElement("ERRORCODE");
		Node node2 = doc.createTextNode("00");//TODO fill this with real value
		ele2.appendChild(node2);
		eleRoot.appendChild(ele2);

		//append element BILLERCODE to root
		Element ele3 = doc.createElement("BILLERCODE");
		Node node3 = doc.createTextNode("000");//TODO fill this with real value
		ele3.appendChild(node3);
		eleRoot.appendChild(ele3);

		//append element UNIQUEID to root
		Element ele4 = doc.createElement("UNIQUEID");
		Node node4 = doc.createTextNode("11111111111");//TODO fill this with real value
		ele4.appendChild(node4);
		eleRoot.appendChild(ele4);

		//append element PRODUCTCODE to root
		Element ele5 = doc.createElement("PRODUCTCODE");
		Node node5 = doc.createTextNode("2111");//TODO fill this with real value
		ele5.appendChild(node5);
		eleRoot.appendChild(ele5);

		//append element TID to root
		Element ele6 = doc.createElement("TID");
		Node node6 = doc.createTextNode("13443188358913632");//TODO fill this with real value
		ele6.appendChild(node6);
		eleRoot.appendChild(ele6);
		
		//append element NoRef to root
		Element ele9 = doc.createElement("NoRef");
		Node node9 = doc.createTextNode("V00KF1234013709D87559V023401");//TODO fill this with real value
		ele9.appendChild(node9);
		eleRoot.appendChild(ele9);

		//append element AMOUNT to root
		Element ele7 = doc.createElement("AMOUNT");
		Node node7 = doc.createTextNode("100000");//TODO fill this with real value
		ele7.appendChild(node7);
		eleRoot.appendChild(ele7);

		//append element MESSAGE to root
		Element ele8 = doc.createElement("MESSAGE");
		ele8.setAttribute("count","18");
		//adding sub element for DISPLAY1
		Element ele8_sub1 = doc.createElement("DISPLAY1");
		Node node8_sub1 = doc.createTextNode("STRUK PEMBELIAN LISTRIK PRABAYAR");//TODO fill this with real value
		ele8_sub1.appendChild(node8_sub1);
		ele8.appendChild(ele8_sub1);
		//adding sub element for DISPLAY2
		Element ele8_sub2 = doc.createElement("DISPLAY2");
		Node node8_sub2 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub2.appendChild(node8_sub2);
		ele8.appendChild(ele8_sub2);
		//adding sub element for DISPLAY3
		Element ele8_sub3 = doc.createElement("DISPLAY3");
		Node node8_sub3 = doc.createTextNode("07/08/2012 12:53:57");//TODO fill this with real value
		ele8_sub3.appendChild(node8_sub3);
		ele8.appendChild(ele8_sub3);
		//adding sub element for DISPLAY4
		Element ele8_sub4 = doc.createElement("DISPLAY4");
		Node node8_sub4 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub4.appendChild(node8_sub4);
		ele8.appendChild(ele8_sub4);
		//adding sub element for DISPLAY5
		Element ele8_sub5 = doc.createElement("DISPLAY5");
		Node node8_sub5 = doc.createTextNode("NO METER : 11111111111 ADMIN BANK : RP. 1.600");//TODO fill this with real value
		ele8_sub5.appendChild(node8_sub5);
		ele8.appendChild(ele8_sub5);
		//adding sub element for DISPLAY6
		Element ele8_sub6 = doc.createElement("DISPLAY6");
		Node node8_sub6 = doc.createTextNode("NAMA : H MAMAT MATERAI: RP. 0,00</");//TODO fill this with real value
		ele8_sub6.appendChild(node8_sub6);
		ele8.appendChild(ele8_sub6);
		//adding sub element for DISPLAY7
		Element ele8_sub7 = doc.createElement("DISPLAY7");
		Node node8_sub7 = doc.createTextNode("TARIF/DAYA :R1/000000900 VA PPn : RP. 0,00</");//TODO fill this with real value
		ele8_sub7.appendChild(node8_sub7);
		ele8.appendChild(ele8_sub7);
		//adding sub element for DISPLAY8
		Element ele8_sub8 = doc.createElement("DISPLAY8");
		Node node8_sub8 = doc.createTextNode("AJREF : V00KF1234013709D87559V023401 PPj:RP.535,92");//TODO fill this with real value
		ele8_sub8.appendChild(node8_sub8);
		ele8.appendChild(ele8_sub8);
		//adding sub element for DISPLAY9
		Element ele8_sub9 = doc.createElement("DISPLAY9");
		Node node8_sub9 = doc.createTextNode("ANGSURAN : RP. 0,00");//TODO fill this with real value
		ele8_sub9.appendChild(node8_sub9);
		ele8.appendChild(ele8_sub9);
		//adding sub element for DISPLAY10
		Element ele8_sub10 = doc.createElement("DISPLAY10");
		Node node8_sub10 = doc.createTextNode("RP BAYAR : Rp. 20.000 RP TOKEN : Rp. 17.864,08");//TODO fill this with real value
		ele8_sub10.appendChild(node8_sub10);
		ele8.appendChild(ele8_sub10);
		//adding sub element for DISPLAY11
		Element ele8_sub11 = doc.createElement("DISPLAY11");
		Node node8_sub11 = doc.createTextNode("JML KWH : 29,60");//TODO fill this with real value
		ele8_sub11.appendChild(node8_sub11);
		ele8.appendChild(ele8_sub11);
		//adding sub element for DISPLAY12
		Element ele8_sub12 = doc.createElement("DISPLAY12");
		Node node8_sub12 = doc.createTextNode("TOKEN : 2876 6433 8981 4602 0504");//TODO fill this with real value
		ele8_sub12.appendChild(node8_sub12);
		ele8.appendChild(ele8_sub12);
		//adding sub element for DISPLAY13
		Element ele8_sub13 = doc.createElement("DISPLAY13");
		Node node8_sub13 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub13.appendChild(node8_sub13);
		ele8.appendChild(ele8_sub13);
		//adding sub element for DISPLAY14
		Element ele8_sub14 = doc.createElement("DISPLAY14");
		Node node8_sub14 = doc.createTextNode("");//TODO fill this with real value
		ele8_sub14.appendChild(node8_sub14);
		ele8.appendChild(ele8_sub14);
		//adding sub element for DISPLAY15
		Element ele8_sub15 = doc.createElement("DISPLAY15");
		Node node8_sub15 = doc.createTextNode("TERIMA KASIH");//TODO fill this with real value
		ele8_sub15.appendChild(node8_sub15);
		ele8.appendChild(ele8_sub15);
		//adding sub element for DISPLAY16
		Element ele8_sub16 = doc.createElement("DISPLAY16");
		Node node8_sub16 = doc.createTextNode("Harga Listrik Prabayar Anda Rp /kwh");//TODO fill this with real value
		ele8_sub16.appendChild(node8_sub16);
		ele8.appendChild(ele8_sub16);
		//adding sub element for DISPLAY17
		Element ele8_sub17 = doc.createElement("DISPLAY17");
		Node node8_sub17 = doc.createTextNode("Informasi Hubungi Call Center 123 Atau Hub PLN Terdekat ");//TODO fill this with real value
		ele8_sub17.appendChild(node8_sub17);
		ele8.appendChild(ele8_sub17);
		//adding sub element for DISPLAY18
		Element ele8_sub18 = doc.createElement("DISPLAY18");
		Node node8_sub18 = doc.createTextNode("INFORMASI HUB: 123  ");//TODO fill this with real value
		ele8_sub18.appendChild(node8_sub18);
		ele8.appendChild(ele8_sub18);

		eleRoot.appendChild(ele8);

		//finish construct
		doc.appendChild(eleRoot);
		return doc;
	}
}
