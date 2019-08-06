package com.how2java.QuickTest;
import java.io.*;
import java.nio.charset.Charset;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException	{
    	String file ="D:\\公租房数据\\2019年上半年\\2019年上半年";
    	String finder ="2014CNJY11043";
    	long startTime=System.currentTimeMillis();   //获取开始时间
    	Finder.findChar(file,finder);
    	long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }


    
}