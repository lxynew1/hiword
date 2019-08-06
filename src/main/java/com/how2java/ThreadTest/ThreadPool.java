package com.how2java.ThreadTest;

import java.util.LinkedList;

public class ThreadPool {
	//线程池大小
	int threadPoolSize;
	
	//任务容器
	LinkedList<Runnable> tasks = new LinkedList<Runnable>();
	
	//试图消费任务的线程
	public ThreadPool(){
		threadPoolSize = 10;
		
		//启动10个消费者线程
		synchronized (tasks) {
			for(int i=0;i<threadPoolSize;i++){
				
			}
		}
	}
	
	public void add(Runnable r){
		synchronized (r) {
			tasks.add(r);
			//唤醒等待的消费者线程
			tasks.notifyAll();
		}
	}
	
	//class
}
