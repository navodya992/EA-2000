/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreadapp;

/**
 *
 * @author USER
 */
public class SynchronizedExample extends Thread {
    private counter counter;
    
    public SynchronizedExample(counter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        counter counter = new counter();
        
        // Create and start multiple threads
        Thread thread1 = new SynchronizedExample(counter);
        Thread thread2 = new SynchronizedExample(counter);
        
        thread1.start();
        thread2.start();
        
        // Wait for threads to finish
        thread1.join();
        thread2.join();
        
        // Print the final counter value
        System.out.println("Final counter value: " + counter.getCount());
    }
}

    

