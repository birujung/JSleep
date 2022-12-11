package com.amritaDeviayuTunjungbiruJSleepDN;

/**
 * The `ThreadingObject` class extends the `Thread` class and provides a simple implementation of a thread.
 *
 * @author  Amrita Deviayu Tunjungbiru
 * @version 1.0
 * @since 11 December 2022
 */
public class ThreadingObject extends Thread{
    /**
     * Constructs a new `ThreadingObject` instance with the specified name.
     *
     * @param name The name of the thread.
     */
    public ThreadingObject(String name){
        super(name);
        this.start();
    }

    /**
     * The `run` method is called when the thread is started and prints the name and ID of the thread.
     */
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("Id Thread " + Thread.currentThread().getId());
    }
}


