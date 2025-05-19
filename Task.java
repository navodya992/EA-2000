/*import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors;
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreadapp;

/**
 *
 * @author USER
 */
public class Task implements Runnable {

   private final int taskId; 
public Task(int taskId) { 
this.taskId = taskId; 

    }
@Override 
public void run() { 
System.out.println("Task " + taskId + " is being processed by " + 
Thread.currentThread().getName()); 
} 
} 
    

