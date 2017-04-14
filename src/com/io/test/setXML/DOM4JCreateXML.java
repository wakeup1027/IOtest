package com.io.test.setXML;

import java.io.FileOutputStream;  
import org.dom4j.Document;  
import org.dom4j.DocumentHelper;  
import org.dom4j.Element;  
import org.dom4j.io.OutputFormat;  
import org.dom4j.io.XMLWriter; 

public class DOM4JCreateXML {
	public static void main(String[] args) throws Exception {  
        
        //1.��һ�� �����ĵ������ø�Ԫ�ؽڵ�ķ�ʽ  
          
        //�����ĵ��ĸ��ڵ�  
        //Document document = DocumentHelper.createDocument();  
        //�����ĵ��� ��Ԫ�ؽڵ�  
        //Element root = DocumentHelper.createElement("Person");  
        //document.setRootElement(root);  
          
        //2.�ڶ��� �����ĵ������ø�Ԫ�ؽڵ�ķ�ʽ  
        Element root = DocumentHelper.createElement("person");  
        Document document = DocumentHelper.createDocument(root);  
        //�����ڵ��������  
        root.addAttribute("shool", "nanda").addAttribute("location", "jianxi");  
          
        //�����ڵ���Ӻ��ӽڵ�  
        Element element1 = root.addElement("stud").addAttribute("name", "student");  
        element1.addElement("name").addAttribute("marry", "sign").addText("Mr.Li");  
        element1.addElement("age").addText("Twenty_one");  
          
        Element element2 = root.addElement("stud").addAttribute("name", "student");  
        element2.addElement("name").addAttribute("marry", "sign").addText("Miss.Fu");  
        element2.addElement("age").addText("Twenty_two");  
                  
          
        //�����ɵ�xml�ĵ������Ӳ����  true�����Ƿ���  
        OutputFormat format = new OutputFormat("    ",true);  
        format.setEncoding("UTF-8");//���ñ����ʽ  
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("person.xml"),format);  
      
        xmlWriter.write(document);  
        xmlWriter.close();  
    }
}
