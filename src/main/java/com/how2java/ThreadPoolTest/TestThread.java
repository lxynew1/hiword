package com.how2java.ThreadPoolTest;
import java.io.File;
   
public class TestThread {
   
    static ThreadPool pool= new ThreadPool();
    public static void search(File file, String search) {
         
        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
                SearchFileTask task = new SearchFileTask(file, search);
                pool.add(task);
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search);
            }
        }
    }
       
    public static void main(String[] args) {
        File folder =new File("D:\\公租房数据\\重庆公租房项目\\cqgzf");
        search(folder,"get");
    }
}