package com.how2java.QuickTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ThreadTest {
	public static int count = 0;
	public static void main(String[] args) throws InterruptedException {
		Finder f = new Finder();
		ArrayList all1 = new ArrayList<String>();

		final ArrayList all = f.listFile("D:\\公租房数据\\2019年上半年\\2019年上半年",all1);
		final String finder = "JZ_ZLHT";
		//实例化线程池
		ThreadPool pool = new ThreadPool();
		long startTime=System.currentTimeMillis();   //获取开始时间
		for (int i = 0; i < all.size(); i++) {
			//实例化一个线程任务
			final int j= i;
			Runnable task = new Runnable() {
				String file ="";
				public void run() {
					// TODO Auto-generated method stub
					//System.out.println("执行任务");
                    //任务可能是打印一句话
                    //可能是访问文件
                    //可能是做排序
					try {
						int str2=Finder.getChar(all.get(j).toString(),finder,0);
						//System.out.println(count);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			};
			pool.add(task);
		}

		//System.out.println(count);
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}
}
