package com.io.test.setXML;

import java.io.File;  
import java.util.Iterator;  
import java.util.List;  
  
import org.dom4j.Attribute;  
import org.dom4j.Document;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;

public class Rreader_dom4j {
	public static void main(String[] args) throws Exception{  
        
        //1.获取SAM接口：  
        SAXReader saxReader = new SAXReader();  
        //2.获取XML文件：  
        Document doc = saxReader.read(new File("person.xml"));  
        //3.获取根节点：  
        Element root = doc.getRootElement();          
        System.out.println("根节点: " + root.getName());         
          
        System.out.println("----------------");  
          
        //获取子节点  
        Iterator<?> it = root.elementIterator();  
        while(it.hasNext()){  
            Element elem = (Element) it.next();
            System.out.println("第一子节点的名称："+elem.getName());
            //获取属性名属性值  
            List<Attribute> li = elem.attributes();  
            for (Attribute att : li ) {  
                System.out.println(att.getName() + "  " + att.getValue());  
            }  
                      
            //获取子节的子节点  
            Iterator<?> ite = elem.elementIterator();  
            while(ite.hasNext()){  
                Element child = (Element) ite.next();  
                System.out.println(child.getName() + "  " + child.getStringValue());  
            }  
              
            System.out.println("----------------");  
        }  
  
    }  
}
