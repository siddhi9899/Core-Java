package com.executers;

import java.util.concurrent.Callable; 
import java.util.concurrent.ExecutionException; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.Future; 
 
/** * Java program to show how to use Future in Java. Future allows to write * asynchronous code in Java, where Future promises result to be available in * future * * @author Javin */ 
public class FutureDemo { 
private static final ExecutorService threadpool = Executors.newFixedThreadPool(3); 
 public static void main(String args[]) throws InterruptedException, ExecutionException { 
  int x = 5;
  FactorialCalculator task = new FactorialCalculator(x); 
  System.out.println("Submitting Task ..."); 
  @SuppressWarnings("unchecked")
  Future future = threadpool.submit(task); 
  System.out.println("Task is submitted"); 
   while (!future.isDone()) { 
     System.out.println("Task is not completed yet...."); 
     Thread.sleep(1); //sleep for 1 millisecond before checking again 
   } 
  System.out.println("Task is completed, let's check result"); 
  long factorial = (long) future.get(); 
  System.out.println("Factorial of "+x+" is : " + factorial); 
  threadpool.shutdown(); 
 } 

private static class FactorialCalculator implements Callable 
{ 
  private final int number; 
  public FactorialCalculator(int number) { 
   this.number = number; 
  } 
  @Override 
  public Long call() throws Exception 
  { 
    long output = 0; 
    try { 
     output = factorial(number); 
    } 
    catch (IllegalArgumentException ex) { 
      System.out.println("Callable Call method throw exception: "+ex.getMessage());
      throw ex;
    }
    catch (Exception ex) { 
        System.out.println("Callable Call method throw exception: "+ex.getMessage());
        throw ex;
    } 
    return output; 
   } 
  private long factorial(int number) throws Exception { 
    if (number < 0) { 
      throw new IllegalArgumentException("Number must be greater than zero"); 
    } 
    long result = 1; 
    while (number > 0) { 
      Thread.sleep(1); // adding delay for example 
      result = result * number; 
      number--; 
    }  
    return result; 
  } 
 } 
}

//Read more: https://javarevisited.blogspot.com/2015/01/how-to-use-future-and-futuretask-in-Java.html#ixzz5KjpqnBel
