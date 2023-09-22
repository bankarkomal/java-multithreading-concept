// NumberPrinter prints number between 1-10
class NumberPrinter{
    synchronized void print()throws InterruptedException{
        for (int i = 1 ; i<=10; i++){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread()+"i"+ i);
        }
    }
}
// NumberPrinter thread will print number
//There can be one or more printer threads printing number in sequence or parallel
class NumberPrinterThread extends Thread{
    NumberPrinter numberPrinter;

    NumberPrinterThread(NumberPrinter numberPrinter){
        this.numberPrinter = numberPrinter;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread()+"called run() method !!!");
        try {
            Thread.sleep(2000);
            this.numberPrinter.print();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }

    }
public class ThreadExampleUsingThreadClass {
    public static void main(String[] args) {
        System.out.println("Main Method Start:" +Thread.currentThread());
        NumberPrinter numberPrinter = new NumberPrinter();


        NumberPrinterThread thread1 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-1");
        NumberPrinterThread thread2 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-2");
        NumberPrinterThread thread3 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-3");
        try {
            thread1.start();// Thread 1 is calling run method.
            thread2.start();// Thread 2 is calling run method
            thread3.start();// Thread 3 is calling run method.
        }catch (RuntimeException e){
            System.out.println("RuntimeException occurred");
            e.printStackTrace();
        }
        System.out.println("Main Method end:" + Thread.currentThread());

    }
}
