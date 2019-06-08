import com.sun.xml.internal.ws.policy.privateutil.LocalizationMessages;
import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Yao Siyuan on 2016/7/13/013.
 */

class Resource
{
    private String name;
    private  int count = 1;
    private boolean flag = false;

    //造锁替换synchronized
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //public synchronized void set(String name)
    public  void set(String name)throws InterruptedException
    {
        lock.lock();
        try{
            //没有判断标记就去执行，改if为while始终判断标记
            while (flag)
                //try {wait();}catch (Exception e){}
                condition.await();
            this.name = name+"--"+count++;

            System.out.println(Thread.currentThread().getName()+"..生产者"+this.name);
            flag = true;
            //判断所有标记造成死锁，notifyAll唤醒所有线程
            //this.notifyAll();
            condition.signal();
        }
       finally {
            lock.unlock();
        }

    }

    public synchronized void out()
    {
        while (!flag)
            try {wait();}catch (Exception e){}
        System.out.println(Thread.currentThread().getName()+"..消费者...."+this.name);
        flag = false;
        this.notifyAll();
    }
}

class Producer implements Runnable
{
    private Resource res;

    Producer(Resource res)
    {
        this.res = res;
    }
    public void run()
    {
        while (true)
        {
            res.set("+商品+");
        }
    }
}

class Consumer implements Runnable
{
    private Resource res;

    Consumer(Resource res)
    {
        this.res = res;
    }
    public void run()
    {
        while (true)
        {
            res.out();
        }
    }
}

public class ProducerConsumerDemo {
    public static  void main(String args [])
    {
        Resource r = new Resource();

        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}









