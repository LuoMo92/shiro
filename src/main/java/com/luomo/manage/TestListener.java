package com.luomo.manage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by LiuMei on 2017-08-18.
 */
public class TestListener implements ServletContextListener {

    private MyThread myThread;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String str = null;
        if (str == null && myThread == null) {
            myThread = new MyThread();
            myThread.start(); // servlet 上下文初始化时启动 socket
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}

class MyThread extends Thread {
    public void run() {
        while (!this.isInterrupted()) {// 线程未中断执行循环
            try {
                Thread.sleep(2000); //每隔2000ms执行一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("____TEST TIME:" + System.currentTimeMillis());
        }
    }
}
