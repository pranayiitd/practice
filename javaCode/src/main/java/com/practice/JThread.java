import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class JThread{

  ClassOne c1;
  ClassTwo c2;

  class ClassOne implements Runnable{
    int count = 0;
    Lock lock = new ReentrantLock();

    // Infinite loop to increment instance variable and sleep
    public void run(){
      System.out.println("Thread is starting...");
      try{
        while(true){
          System.out.printf("thread: %s, count: %s\n",Thread.currentThread().getName() , count);
          increament();
          increase();
          increaseAtomic();
          
          System.out.printf("thread: %s going to sleep\n",Thread.currentThread().getName());
          Thread.sleep(3000);
        }
      }
      catch(InterruptedException ex){
      }
    }

    // The lock is per object, so if t1 is running below fun
    // it has the lock this object and hence thread t2 can not even run
    // other method, which may not be synchronized.k
    public synchronized void increament(){
      count++;
    }

    public void increase(){
      synchronized(this){
        count++;
      }
    }

    public void increaseAtomic(){
      lock.lock();
      count++;
      lock.unlock();

    }

  } 

  class ClassTwo extends Thread{
    int count = 0;
   // Infinite loop to increment instance variable and sleep
    public void run(){
      System.out.println("Thread is starting...");
      try{
        while(true){
          System.out.printf("class: %s, count: %s\n", this.getClass(), count);
          count++;
          Thread.sleep(1000);
        }
      }
      catch(InterruptedException ex){
      }
    } 
  }

  JThread(){
    c1 = new ClassOne();
    c2 = new ClassTwo();
  }


  public static void main(String arg[]){
    JThread j1 = new JThread();
    Thread t1 = new Thread(j1.c1, "t1");
    Thread t2 = new Thread(j1.c1, "t2");
    t1.start();
    t2.start();

    // j1.c2.start();

  }
}