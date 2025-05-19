/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreadapp;

/**
 *
 * @author USER
 */
public class ThreadLifecycleExample extends Thread {
     @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - State: " + Thread.currentThread().getState());
        try {
            Thread.sleep(2000); // Simulate waiting state
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - State after sleep: " + Thread.currentThread().getState());
    }

    public static void main(String[] args) {
        ThreadLifecycleExample thread = new ThreadLifecycleExample();
        System.out.println(thread.getName() + " - State before start: " + thread.getState());
        thread.start(); // Start the thread
        System.out.println(thread.getName() + " - State after start: " + thread.getState());
    }
}
    

