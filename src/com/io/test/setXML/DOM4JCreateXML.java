package com.io.test.setXML;

import java.io.FileOutputStream;  
import org.dom4j.Document;  
import org.dom4j.DocumentHelper;  
import org.dom4j.Element;  
import org.dom4j.io.OutputFormat;  
import org.dom4j.io.XMLWriter; 

public class DOM4JCreateXML {
	public static void main(String[] args) throws Exception {  
        
        //1.第一种 创建文档及设置根元素节点的方式  
          
        //创建文档的根节点  
        //Document document = DocumentHelper.createDocument();  
        //创建文档的 根元素节点  
        //Element root = DocumentHelper.createElement("Person");  
        //document.setRootElement(root);  
          
        //2.第二种 创建文档及设置根元素节点的方式  
        Element root = DocumentHelper.createElement("person");  
        Document document = DocumentHelper.createDocument(root);  
        //给根节点添加属性  
        root.addAttribute("shool", "nanda").addAttribute("location", "jianxi");  
          
        //给根节点添加孩子节点  
        Element element1 = root.addElement("stud").addAttribute("name", "student");  
        element1.addElement("name").addAttribute("marry", "sign").addText("Mr.Li");  
        element1.addElement("age").addText("Twenty_one");  
          
        Element element2 = root.addElement("stud").addAttribute("name", "student");  
        element2.addElement("name").addAttribute("marry", "sign").addText("Miss.Fu");  
        element2.addElement("age").addText("Twenty_two");  
                  
          
        //把生成的xml文档存放在硬盘上  true代表是否换行  
        OutputFormat format = new OutputFormat("    ",true);  
        format.setEncoding("UTF-8");//设置编码格式  
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("person.xml"),format);  
      
        xmlWriter.write(document);  
        xmlWriter.close();  
    }
}
