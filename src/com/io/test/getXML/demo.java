package com.io.test.getXML;

import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class demo {
	
	public static void readXML(){
		try {
			String path = demo.class.getClassLoader().getResource("test.xml").getPath();
			//String relativelyPath = System.getProperty("test.xml");
			File f=new File(path);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName("value");
			for (int i=0; i<nl.getLength(); i++){
				System.out.print("车牌号："+doc.getElementsByTagName("no").item(i).getFirstChild().getNodeValue());
				System.out.print(" ");
				System.out.print("车主地址:"+doc.getElementsByTagName("addr").item(i).getFirstChild().getNodeValue());
				System.out.println("");
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] arge){
		readXML();
	}
}
