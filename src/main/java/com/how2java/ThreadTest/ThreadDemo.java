package com.how2java.ThreadTest;

public class ThreadDemo extends Thread {
	//声明线程
	private Thread t;
	//线程命名
	private String threadName;
	
	//重写构造方法，线程新建
	ThreadDemo(String name){
		threadName = name;
		System.out.println("Creating Thread "+threadName);
	}
	
	//重写start()方法，线程就绪
	public void start(){
		System.out.println("Starting "+ threadName);
		if(t == null){
			t = new Thread(this,threadName);
			t.start();
		}
	}
	//重写run()方法，线程执行
	public void run(){
		System.out.println("Runing "+threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("让线程"+threadName+"睡一会！");
				Thread.sleep(5);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Thread "+threadName +"Interrupted!");
		}
		System.out.println("Thread "+threadName +" exiting");
	}
}
