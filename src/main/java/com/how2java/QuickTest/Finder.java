package com.how2java.QuickTest;

import java.io.*;

import java.nio.charset.Charset;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	public static void main( String[] args ) throws IOException	{
    	String str= "D:\\公租房数据\\cqgzf";
    	findChar(str,"czrsj");
	}
	static String strr ="";
	//读出文件中的字符串
	/**
	 * @param file 文件路径
	 * @param str1 字符串
	 * @param str2 查找到的次数
	 * @return 文件路径
	 * */
	public static int getChar(String file,String str1,int str2)throws IOException{
		File f = new File(file);
		File f1 = new File(str1);
		try(FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis,Charset.forName("GBK"));
			BufferedReader bufferedReader = new BufferedReader(isr);	 
				){
			char[] cs = new char[(int)f.length()];
			String lineText;
			int i =0;
			while((lineText = bufferedReader.readLine())!=null){
				i++;
				if(lineText.contains(str1)){
					//System.out.println("===================");
					System.out.println("\""+str1+"\"所在位置:"+file.toString());
					//System.out.println(" 第"+i+"行");
					//System.out.println("内容:"+lineText.trim());
					//str2++;
					//System.out.println(str2);
				}
			}
			return str2;

			
		}
	} 
	//遍历文件夹
	/**
	 * @param fodler 需要遍历的文件夹  
	 * @param all 返回的有效文件路径集合
	 * @return 有效的文件路径
	 * */
	public static ArrayList listFile(String fodler,ArrayList<String> all){
		File file = new File(fodler);
		File[] fs = file.listFiles();
		if(fs!=null){
			for(File f : fs){
				if(f.isFile()){
					all.add(f.getAbsolutePath());
					//System.out.println(f);
				}
				else{
					listFile(f.getAbsolutePath(),all);
				}
				
			}
		}
		return all;
	}
	public  static void  findChar(String str,String finder) throws IOException{
		ArrayList all = new ArrayList<String>();
    	ArrayList all1 = listFile(str,all);
    	int bs=1;
		int str2=0;
    	for(int i = 0,j=0;i<all1.size();i++){
    		getChar(all1.get(i).toString(),finder,str2);
    	}
	}
}
