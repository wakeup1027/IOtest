package com.io.test.demo2;

import java.io.*;
import java.util.*;

/**
 * 学习了  
 * 1、怎样将数据以对象的形式写入到文件中
 * 2、怎样将数据以对象链表的形式写入多个对象的信息到文件中
 * 3、怎样将对象读出来
 * 4、怎样将文件里面的全部对象信息一次性读出来
 * @author solarpc1
 *
 */
public class ObjectOutTest {
	/*将对象写入文件方法*/
	public static void write(String path){
		/**
		 * 只保存单个对象的思路
		 * 将对象的信息写到文件里面 writeObject(对象)
		 */
		
		/**
		 * 一次写入多个对象的思路
		 * 1、将多个对象放到链表数组里面
		 * 2、然后将这个链表写到文件里面 writeObject(链表数组)
		 */
		List<ioTest> ioList = new ArrayList<ioTest>();
		/*写入对象*/
		ioList.add(new ioTest("李向春","男","1997-05-12"));
		ioList.add(new ioTest("李向前","男","1993-05-12"));
		ioList.add(new ioTest("李向妹","女","1995-05-12"));
		ioList.add(new ioTest("李向林","女","1991-05-12"));
		try {
			/*创建存取文件*/
			FileOutputStream fileStream = new FileOutputStream(path); //这个加上false的时候就会覆盖原来的文件内容，true的时候就不覆盖。默认为false
			/*将存取文件写入对象*/
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			/*写入对象*/
			os.writeObject(ioList);
			//System.out.println("写入数据成功");
			/*关闭ObjectOutputStream*/
			os.close();
		} catch (FileNotFoundException e) {
			/*找不到文件的异常*/
			e.printStackTrace();
		} catch (IOException e) {
			/*将文件写入到对象的异常*/
			e.printStackTrace();
		}
	}
	
	/*将对象信息从文件读取出来*/
	public static void read(String path){
		try {
			/*连接到要读取的文件*/
			FileInputStream fileStream = new FileInputStream(path);
			/*怎样读取连接到的文件*/
			ObjectInputStream os = new ObjectInputStream(fileStream);
			/*读取对象*/
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
	
	/*使用缓冲区写入字符串*/
	public static void wirteString(String str, String path){
		try {
			/*创建写入对象*/
			FileWriter filew = new FileWriter(path);
			/*创建缓冲区*/
			BufferedWriter writer = new BufferedWriter(filew);
			/*将字符串写入到文件中*/
			writer.write(str);
			/*关闭对象*/
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*用缓冲区读取外部文件内容*/
	public static void readString(String path){
		try {
			/*创建读取对象*/
			FileReader fread = new FileReader(path);
			/*创建缓冲区*/
			BufferedReader reader = new BufferedReader(fread);
			char[] buf=new char[1024]; 
	        int len=0; 
			while((len=reader.read(buf))!=-1){ 
				  /*每次读取1kb大小的字符，直到读到末尾-1为止*/
				  System.out.println(new String(buf,0,len)); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		/*写入对象*/
		//write("C:/Users/solarpc1/Desktop/导入开发/cc.xq");
		
		/*读取对象*/
		//read("C:/Users/solarpc1/Desktop/导入开发/cc.xq");
		
		/*用缓冲区写入字符串*/
		wirteString("你好帅哥。。。。","C:/Users/solarpc1/Desktop/导入开发/cc.xq");
		
		/*用缓冲区读取字符串*/
		readString("C:/Users/solarpc1/Desktop/导入开发/cc.xq");
	}

}
