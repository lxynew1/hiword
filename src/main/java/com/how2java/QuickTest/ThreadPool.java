package com.how2java.QuickTest;

import java.util.LinkedList;

/**
 	*1.准备一个任务容器tasks
	*2.一次性启动十个消费者线程
	*3.刚开始任务容器是空的，所有线程都是wait状态
	*4.直到一个外部线程将一个任务扔到这个容器里面，就会有一个消费者线程被唤醒notify
	*5.这个消费者线程取出任务，并执行这个任务，执行完毕后，继续等待下一个任务的到来
	*6.如果短时间内，有多个任务被扔到容器里，就会有多个线程被唤醒，去执行这些任务
*/
public class ThreadPool {
	//线程池大小
	int threadSize;
	//任务容器
	LinkedList<Runnable> tasks = new LinkedList<Runnable>();
	
	//试图消费任务的线程
	public ThreadPool(){
		threadSize=10;
		
		//启动十个消费者线程
		synchronized (tasks) {
			for(int i=0;i<threadSize;i++){
				new TaskConsumeThread("任务消费者线程 " + i).start();
			}
		}

	}
	public void add(Runnable r){
		synchronized (tasks) {
			tasks.add(r);
			//唤醒等待的消费者线程
			tasks.notifyAll();
		}
	}
	
	//自定义消费者线程
	class TaskConsumeThread extends Thread{
		public TaskConsumeThread(String name){
			super(name);
		}
		
		Runnable task;
		
		public void run(){
			//System.out.println("启动： " +this.getName());
			while(true){
				synchronized (tasks) {
					
					while(tasks.isEmpty()){
						try{
							//当线程
							tasks.wait();
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
					task = tasks.removeLast();
					// 允许添加任务的线程可以继续添加任务
					//tasks.notifyAll();
				}
				
				//System.out.println(this.getName() + " 获取到任务，并执行");
				task.run();
			}
			
		}	
	}
}
