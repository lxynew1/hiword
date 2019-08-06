package com.how2java.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//创建callable接口的实现类
public class CallableThreadTest implements Callable<Integer> {
	
	public static void main(String[] args) {
		//创建callable接口实现类的实例
		CallableThreadTest ctt = new CallableThreadTest();
		
		//使用Future包装Callable对象,该FutrueTask对象封装了该Callable对象call()方法的
		//相当于新建线程
		FutureTask<Integer> ft = new FutureTask<>(ctt);  
		
		for (int i = 0; i < 100; i++) {
			//主线程执行状态
			System.out.println(Thread.currentThread().getName()+" 的循环变量的值："+i);
			//当i==20时，开启子线程
			//执行了start()方法，线程变为 就绪状态-运行状态
			if(i==20){
				new Thread(ft,"有返回值的线程").start();
			}
		}
		try {
			//返回call()方法的返回值
			System.out.println("子线程的返回值："+ft.get());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 线程执行体
	 * */
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int i=0;
		for(;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		return i;
	}

}
