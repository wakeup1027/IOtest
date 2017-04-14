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
        
        //1.��ȡSAM�ӿڣ�  
        SAXReader saxReader = new SAXReader();  
        //2.��ȡXML�ļ���  
        Document doc = saxReader.read(new File("person.xml"));  
        //3.��ȡ���ڵ㣺  
        Element root = doc.getRootElement();          
        System.out.println("���ڵ�: " + root.getName());         
          
        System.out.println("----------------");  
          
        //��ȡ�ӽڵ�  
        Iterator<?> it = root.elementIterator();  
        while(it.hasNext()){  
            Element elem = (Element) it.next();
            System.out.println("��һ�ӽڵ�����ƣ�"+elem.getName());
            //��ȡ����������ֵ  
            List<Attribute> li = elem.attributes();  
            for (Attribute att : li ) {  
                System.out.println(att.getName() + "  " + att.getValue());  
            }  
                      
            //��ȡ�ӽڵ��ӽڵ�  
            Iterator<?> ite = elem.elementIterator();  
            while(ite.hasNext()){  
                Element child = (Element) ite.next();  
                System.out.println(child.getName() + "  " + child.getStringValue());  
            }  
              
            System.out.println("----------------");  
        }  
  
    }  
}
