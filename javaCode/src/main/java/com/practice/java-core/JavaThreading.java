/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathreading;
import java.lang.Thread;
/**
 *\
 * @author Utkarsh
 */
public class JavaThreading {

    int k = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Transaction t = new Transaction();
        MyThread t1 = new MyThread("t1", t);
        Thread t2 = new Thread(new ThreadJob(t));
        t2.setName("t2");
        t1.start();
        t2.start();
        try
        {
        t1.join();
        }
        catch(InterruptedException e)
        {
            
        }
        try
        {
        t2.join();
        }
        catch(InterruptedException e)
        {
        }
        System.out.println(t.get());
        
    }   
}

class Transaction{
    int amnt = 0;
    String t; 
    synchronized void update(String transaction, int amnt)
    {
        System.out.println("Starting: Transaction: "+transaction + "Updating amount :"+ amnt);
        t = transaction;
        try
        {
            if(transaction == "credit")
           Thread.sleep ((int) (10000));
            if(transaction == "debit")
            Thread.sleep ((int) (500));
        }
        catch (InterruptedException e)
        {
        }
        this.amnt = amnt;
        System.out.println("Transaction: "+t + "Updating amount :"+ amnt);
        
    }
    
    public int get(){
        return amnt;
    }
}

    class MyThread extends Thread{
        Transaction t;
        
    public MyThread(String name, Transaction t)
    {
        super(name);
        this.t = t;
    }
        
    @Override
    public void run(){
        for(int i =0;i<1;i++)
        {
            System.out.println(this.getName());
            t.update("credit", 1000);
        }
    }
}

class ThreadJob implements Runnable{
    Transaction t;
    
    public ThreadJob(Transaction t){
        this.t = t;
    }
    
    @Override
    public void run(){
        for(int i =0;i<3;i++)
        {
            System.out.println(Thread.currentThread().getName());
            t.update("debit", 500);
        }
    }
}