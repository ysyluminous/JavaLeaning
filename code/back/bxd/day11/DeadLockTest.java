/************************************************************************
 *
 * 文件名:	DeadLockTest
 *
 * 文件描述:	第11天_15_多线程_死锁
 *			
 * 创建人:	Yao Siyuan,
 *
 * 总结:		避免死锁，面试写死锁，熟练同步。
 *
 * 版本号:	0.1
 *
 * 修改记录:
 *			0.1:
 *
 ************************************************************************/

class Test implements Runnable
{
    private boolean flag;
    Test(boolean flag)
    {
        this.flag = flag;
    }

    public void run()
    {
        if (flag){
            synchronized (MyLock.locka)
            {
                System.out.println("if locka");
                synchronized (MyLock.lockb)
                {
                    System.out.println("if lockb");
                }
            }
        }
        else{
            synchronized (MyLock.lockb)
            {
                System.out.println("else lockb");
                synchronized (MyLock.locka)
                {
                    System.out.println("esle locka");
                }
            }
        }
    }
}

class MyLock
{
    static Object locka = new Object();
    static Object lockb = new Object();
}
public class DeadLockTest {
    public static void main(String args [])
    {
        Thread t1 = new Thread(new Test(true));
        Thread t2 = new Thread(new Test(false));
        t1.start();
        t2.start();
    }
}
