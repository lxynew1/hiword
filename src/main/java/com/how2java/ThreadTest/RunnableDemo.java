package com.how2java.ThreadTest;
public class RunnableDemo implements Runnable{
	private Thread t;
	private String threadName;
	
	//重写构造方法,新建状态的线程
	RunnableDemo(String name){
		threadName = name;
		System.out.println("Creating " + threadName);
	}
	
	//重写run()方法,运行状态的线程
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running "+ threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: "+threadName+","+i);
				//让线程睡一会
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Thread "+threadName +" interrupted.");
		}
		System.out.println("Thread "+threadName+" exiting!");
	}
	
	//重写start()方法,就绪状态的线程
	public void start(){
		System.out.println("Starting "+threadName);
		if(t==null){
			t=new Thread(this,threadName);
			t.start();
		}
	}

}

