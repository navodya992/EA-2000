/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreadapp;

/**
 *
 * @author USER
 */
public class SimpleThread extends Thread {
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " is executing the thread.");
    }

    public static void main(String[] args) {
        // Creating two threads
        SimpleThread thread1 = new SimpleThread();
        SimpleThread thread2 = new SimpleThread();

        // Starting the threads
        thread1.start();
        thread2.start();
    }

   
}

