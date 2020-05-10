//Producer Consumer Problem using Locks
/*
*Output:
PRODUCER added 344503115 into queue 
PRODUCER : Signalling that buffer is no more empty now
CONSUMER consumed 344503115 from queue 
CONSUMER : Signalling that buffer may be empty now
*/
import java.util.*;
import java.util.concurrent.locks.*;
public class ProdConsusinglock
{
    public static void main(String[] args) 
    {
        ProducerConsumerImpl sharedObject = new ProducerConsumerImpl();
        Producer p = new Producer(sharedObject);
        Consumer c = new Consumer(sharedObject);
        p.start();
        c.start();
    }

}
class ProducerConsumerImpl 
{
    private static final int CAPACITY = 10;
    private final Queue queue = new LinkedList<>();
    private final Random theRandom = new Random();
    private final Lock aLock = new ReentrantLock();
    private final Condition bufferNotFull = aLock.newCondition();
    private final Condition bufferNotEmpty = aLock.newCondition();
    public void put() throws InterruptedException 
    {
        aLock.lock();
        try 
        {
            while (queue.size() == CAPACITY) 
            {
                System.out.println(Thread.currentThread().getName()+" : Buffer is full, waiting");
                bufferNotEmpty.await();
            }
            int number = theRandom.nextInt();
            boolean isAdded = queue.offer(number);
            if (isAdded) 
            {
                System.out.printf("%s added %d into queue %n", Thread.currentThread().getName(), number);
                System.out.println(Thread.currentThread().getName()+" : Signalling that buffer is no more empty now");
                bufferNotFull.signalAll();
            }
        } 
        finally 
        {
            aLock.unlock();
        }
    }
    public void get() throws InterruptedException 
    {
        aLock.lock();
        try 
        {
            while(queue.isEmpty()) 
            {
                System.out.println(Thread.currentThread().getName()+" : Buffer is empty, waiting");
                bufferNotFull.await();
            }
            Integer value = (Integer) queue.poll();
            if (value != null) 
            {
                System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(), value);
                System.out.println(Thread.currentThread().getName()+" : Signalling that buffer may be empty now");
                bufferNotEmpty.signalAll();
            }
        } 
        finally 
        {
            aLock.unlock();
        }
    }
}
class Producer extends Thread 
{
    ProducerConsumerImpl pc;

    public Producer(ProducerConsumerImpl sharedObject) {
        super("PRODUCER");
        this.pc = sharedObject;
    }
    @Override
    public void run() 
    {
        try 
        {
            pc.put();
        } catch (InterruptedException e) {
        }
    }
}
class Consumer extends Thread 
{
    ProducerConsumerImpl pc;
    public Consumer(ProducerConsumerImpl sharedObject) 
    {
        super("CONSUMER");
        this.pc = sharedObject;
    }
    @Override
    public void run() 
    {
        try 
        {
            pc.get();
        }
        catch (InterruptedException e) 
        {}
    }
}