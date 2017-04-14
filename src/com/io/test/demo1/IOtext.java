package com.io.test.demo1;

import java.io.*;

public class IOtext {
	
	//�嵥1�����ı����ݱ��浽�ļ��д���
	private static void test1(){ 
	    FileWriter fw=null; 
	    try { 
	        //��ʼ��FileWriter����ָ���ļ����Ѿ��洢·�� 
	        fw=new FileWriter("D:/test.txt"); 
	        fw.write("��������ǰ"); 
	        //�����е�����ˢ�µ�Ŀ�ĵأ������� 
	        fw.flush(); 
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    }finally{ 
	        if(fw!=null){ 
	            try { 
	                fw.close(); 
	            } catch (IOException e1) { 
	                e1.printStackTrace(); 
	            } 
	             
	        } 
	    } 
	}
	
	//�嵥2����ȡһ�������ı��ļ��������ı����ݴ�ӡ�������� 
	private static void test2(){ 
	    FileReader fr=null; 
	    try { 
	        //��ʼ��FileReader����ָ���ļ�·�� 
	        fr=new FileReader("D:/test.txt"); 
	        int ch=0; 
	        while((ch=fr.read())!=-1){ 
	            //ÿ�ζ�ȡһ���ַ���ֱ������ĩβ-1Ϊֹ 
	            System.out.print((char)ch); 
	        } 
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    }finally{ 
	        if(fr!=null){ 
	            try { 
	                fr.close(); 
	            } catch (IOException e1) { 
	                e1.printStackTrace(); 
	            } 
	             
	        } 
	    } 
	}
	
	//�嵥3����ȡһ�������ı��ļ�������1kb�ٽ�����������ݴ�ӡ��������
	private static void test3(){ 
	    FileReader fr=null; 
	    try { 
	        //��ʼ��FileReader����ָ���ļ�·�� 
	        fr=new FileReader("D:/a.txt"); 
	        char[] buf=new char[1024]; 
	        int len=0; 
	        while((len=fr.read(buf))!=-1){ 
	            //ÿ�ζ�ȡ1kb��С���ַ���ֱ������ĩβ-1Ϊֹ 
	            System.out.println(new String(buf,0,len)); 
	        } 
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    }finally{ 
	        if(fr!=null){ 
	            try { 
	                fr.close(); 
	            } catch (IOException e1) { 
	                e1.printStackTrace(); 
	            } 
	             
	        } 
	    } 
	}
	
	//�嵥4��ʹ�û��������ı��ļ����п�������
	private static void test4(){ 
	    BufferedReader bufr=null; 
	    BufferedWriter bufw=null; 
	    try { 
	         
	        bufr=new BufferedReader(new FileReader("D:/a.txt")); 
	        bufw=new BufferedWriter(new FileWriter("D:/b.txt")); 
	        String line=null; 
	        while((line=bufr.readLine())!=null){ 
	            bufw.write(line);//ÿ�ν�һ��д�뻺���� 
	            bufw.flush();//ˢ�µ�Ŀ�ĵ� 
	        } 
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    }finally{ 
	        try { 
	            if(bufw!=null){ 
	                bufw.close(); 
	            } 
	            if(bufr!=null){ 
	                bufr.close(); 
	            } 
	        } catch (IOException e1) { 
	            e1.printStackTrace(); 
	        } 
	    } 
	}
	
	public static void main(String[] args) { 
		//test1();
		//test2();
		test3();
		//test4();
	}
}
