public class Main {
    public static void main (String[] args) throws InterruptedException {
        //one way of creating a thread
        MyThread thread1 = new MyThread();

        //another way of creating a thread - this way we can still use inheritance - we can extend MyRunnable to some other
        //parent than Thread (you can only have one parent
        MyRunnable runnable1 = new MyRunnable();
        Thread thread2 = new Thread(runnable1);

        thread2.setDaemon(true); //Deamon threads - JVM will not wait with termination for these

        thread1.start();
        thread1.join(3000); //calling thread (ex.main) waits until the specified thread dies or for x milliseconds
        thread2.start(); // this is Deamon thread, JVM will terminate as soon as main and user threads are finished
        System.out.println(1/0); // force arythmetic exception in main thread, thread1 and 2 still runs, but JVM will
        //terminate as soon as thread1 finishes since thread2 is declared as Deamon thread

    }
}
