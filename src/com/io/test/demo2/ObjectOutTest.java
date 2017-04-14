package com.io.test.demo2;

import java.io.*;
import java.util.*;

/**
 * ѧϰ��  
 * 1�������������Զ������ʽд�뵽�ļ���
 * 2�������������Զ����������ʽд�����������Ϣ���ļ���
 * 3�����������������
 * 4���������ļ������ȫ��������Ϣһ���Զ�����
 * @author solarpc1
 *
 */
public class ObjectOutTest {
	/*������д���ļ�����*/
	public static void write(String path){
		/**
		 * ֻ���浥�������˼·
		 * ���������Ϣд���ļ����� writeObject(����)
		 */
		
		/**
		 * һ��д���������˼·
		 * 1�����������ŵ�������������
		 * 2��Ȼ���������д���ļ����� writeObject(��������)
		 */
		List<ioTest> ioList = new ArrayList<ioTest>();
		/*д�����*/
		ioList.add(new ioTest("����","��","1997-05-12"));
		ioList.add(new ioTest("����ǰ","��","1993-05-12"));
		ioList.add(new ioTest("������","Ů","1995-05-12"));
		ioList.add(new ioTest("������","Ů","1991-05-12"));
		try {
			/*������ȡ�ļ�*/
			FileOutputStream fileStream = new FileOutputStream(path); //�������false��ʱ��ͻḲ��ԭ�����ļ����ݣ�true��ʱ��Ͳ����ǡ�Ĭ��Ϊfalse
			/*����ȡ�ļ�д�����*/
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			/*д�����*/
			os.writeObject(ioList);
			//System.out.println("д�����ݳɹ�");
			/*�ر�ObjectOutputStream*/
			os.close();
		} catch (FileNotFoundException e) {
			/*�Ҳ����ļ����쳣*/
			e.printStackTrace();
		} catch (IOException e) {
			/*���ļ�д�뵽������쳣*/
			e.printStackTrace();
		}
	}
	
	/*��������Ϣ���ļ���ȡ����*/
	public static void read(String path){
		try {
			/*���ӵ�Ҫ��ȡ���ļ�*/
			FileInputStream fileStream = new FileInputStream(path);
			/*������ȡ���ӵ����ļ�*/
			ObjectInputStream os = new ObjectInputStream(fileStream);
			/*��ȡ����*/
			List<ioTest> iot = (List<ioTest>) os.readObject();
			for(ioTest iot1 : iot){
				System.out.println(iot1.getName()+" , "+iot1.getSex()+" , "+iot1.getBirthday());
			}
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/*ʹ�û�����д���ַ���*/
	public static void wirteString(String str, String path){
		try {
			/*����д�����*/
			FileWriter filew = new FileWriter(path);
			/*����������*/
			BufferedWriter writer = new BufferedWriter(filew);
			/*���ַ���д�뵽�ļ���*/
			writer.write(str);
			/*�رն���*/
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*�û�������ȡ�ⲿ�ļ�����*/
	public static void readString(String path){
		try {
			/*������ȡ����*/
			FileReader fread = new FileReader(path);
			/*����������*/
			BufferedReader reader = new BufferedReader(fread);
			char[] buf=new char[1024]; 
	        int len=0; 
			while((len=reader.read(buf))!=-1){ 
				  /*ÿ�ζ�ȡ1kb��С���ַ���ֱ������ĩβ-1Ϊֹ*/
				  System.out.println(new String(buf,0,len)); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		/*д�����*/
		//write("C:/Users/solarpc1/Desktop/���뿪��/cc.xq");
		
		/*��ȡ����*/
		//read("C:/Users/solarpc1/Desktop/���뿪��/cc.xq");
		
		/*�û�����д���ַ���*/
		wirteString("���˧�硣������","C:/Users/solarpc1/Desktop/���뿪��/cc.xq");
		
		/*�û�������ȡ�ַ���*/
		readString("C:/Users/solarpc1/Desktop/���뿪��/cc.xq");
	}

}
