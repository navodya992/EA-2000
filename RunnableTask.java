/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreadapp;

/**
 *
 * @author USER
 */
public class RunnableTask implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getId() + " is executing the runnable task.");
    }

    public static void main(String[] args) {
        // Creating instances of RunnableTask
        RunnableTask task1 = new RunnableTask();
        RunnableTask task2 = new RunnableTask();
        
        Thread thread1 = new Thread((java.lang.Runnable) task1); 
         Thread thread2 = new Thread((java.lang.Runnable) task2); 
         
         
thread1.start();  // Starts thread1 
thread2.start();  // Starts thread2 

     
    }
}
