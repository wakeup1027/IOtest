package com.io.test.upfile;

import java.io.*;

public class demo {
	private static final int FILE_SIZE = 16*1024;  // 16K
	
	/*上传文件的思路方法*/
	public static int upload(String localfile,String serfile){
		int res = 0; //结果提示
		
		FileInputStream finpt = null;
		InputStream in = null;
		OutputStream out = null;
		
		FileOutputStream fout = null;
		try {
			/*创建输入文件*/
			File file =  new File(localfile);
			finpt = new FileInputStream(file);
			System.out.println(finpt.available());
			in = new BufferedInputStream(finpt, FILE_SIZE); //指定缓冲区大小
			
			/*创建输出文件*/
			File files =  new File(serfile);
			fout = new FileOutputStream(files);
			out = new BufferedOutputStream(fout); //指定缓冲区大小
			
			/*开始写入文件*/
			byte[] buffer = new byte[FILE_SIZE];
			int length = 0;
			while((length = in.read(buffer))>0){
				out.write(buffer, 0, length);
			}
			res = 1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		//上传文件的路径
		String path = "C:/Users/solarpc1/Desktop/荣誉证书/未标题-1.psd";
		//要保存的路径
		String save = "C:/Users/solarpc1/Desktop/导入开发/未标题-1.psd";
		//开始上传
		int result = upload(path,save);
		if(result==1){
			System.out.println("上传成功");
		}
	}
}
