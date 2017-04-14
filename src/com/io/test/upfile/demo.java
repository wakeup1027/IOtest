package com.io.test.upfile;

import java.io.*;

public class demo {
	private static final int FILE_SIZE = 16*1024;  // 16K
	
	/*�ϴ��ļ���˼·����*/
	public static int upload(String localfile,String serfile){
		int res = 0; //�����ʾ
		
		FileInputStream finpt = null;
		InputStream in = null;
		OutputStream out = null;
		
		FileOutputStream fout = null;
		try {
			/*���������ļ�*/
			File file =  new File(localfile);
			finpt = new FileInputStream(file);
			System.out.println(finpt.available());
			in = new BufferedInputStream(finpt, FILE_SIZE); //ָ����������С
			
			/*��������ļ�*/
			File files =  new File(serfile);
			fout = new FileOutputStream(files);
			out = new BufferedOutputStream(fout); //ָ����������С
			
			/*��ʼд���ļ�*/
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
		//�ϴ��ļ���·��
		String path = "C:/Users/solarpc1/Desktop/����֤��/δ����-1.psd";
		//Ҫ�����·��
		String save = "C:/Users/solarpc1/Desktop/���뿪��/δ����-1.psd";
		//��ʼ�ϴ�
		int result = upload(path,save);
		if(result==1){
			System.out.println("�ϴ��ɹ�");
		}
	}
}
