package com.io.test.demo1;

import java.io.*;

public class IOtext {
	
	//清单1，将文本数据保存到文件中代码
	private static void test1(){ 
	    FileWriter fw=null; 
	    try { 
	        //初始化FileWriter对象，指定文件名已经存储路径 
	        fw=new FileWriter("D:/test.txt"); 
	        fw.write("我是李向前"); 
	        //将流中的数据刷新到目的地，流还在 
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
	
	//清单2，读取一个已有文本文件，并将文本内容打印出来代码 
	private static void test2(){ 
	    FileReader fr=null; 
	    try { 
	        //初始化FileReader对象，指定文件路径 
	        fr=new FileReader("D:/test.txt"); 
	        int ch=0; 
	        while((ch=fr.read())!=-1){ 
	            //每次读取一个字符，直到读到末尾-1为止 
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
	
	//清单3，读取一个已有文本文件，读完1kb再将其读到的内容打印出来代码
	private static void test3(){ 
	    FileReader fr=null; 
	    try { 
	        //初始化FileReader对象，指定文件路径 
	        fr=new FileReader("D:/a.txt"); 
	        char[] buf=new char[1024]; 
	        int len=0; 
	        while((len=fr.read(buf))!=-1){ 
	            //每次读取1kb大小的字符，直到读到末尾-1为止 
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
	
	//清单4，使用缓冲区对文本文件进行拷贝代码
	private static void test4(){ 
	    BufferedReader bufr=null; 
	    BufferedWriter bufw=null; 
	    try { 
	         
	        bufr=new BufferedReader(new FileReader("D:/a.txt")); 
	        bufw=new BufferedWriter(new FileWriter("D:/b.txt")); 
	        String line=null; 
	        while((line=bufr.readLine())!=null){ 
	            bufw.write(line);//每次将一行写入缓冲区 
	            bufw.flush();//刷新到目的地 
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
