package com.how2java.ThreadPoolTest;
import java.util.LinkedList;
  
public class ThreadPool {
    // 线程池大小
    int threadPoolSize;
  
    // 任务容器
    LinkedList<Runnable> tasks = new LinkedList<Runnable>();
  
    // 试图消费任务的线程
  
    public ThreadPool() {
        threadPoolSize = 10;
  
        // 启动10个任务消费者线程
        synchronized (tasks) {
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumeThread("任务消费者线程 " + i).start();
            }
        }
    }
  
    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
            // 唤醒等待的任务消费者线程
            tasks.notifyAll();
        }
    }
  
    class TaskConsumeThread extends Thread {
        public TaskConsumeThread(String name) {
            super(name);
        }
  
        Runnable task;
  
        public void run() {
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    // 允许添加任务的线程可以继续添加任务
                    tasks.notifyAll();
  
                }
                task.run();
            }
        }
    }
  
}