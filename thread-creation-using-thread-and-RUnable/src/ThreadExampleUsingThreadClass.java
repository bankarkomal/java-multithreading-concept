// NumberPrinter prints number between 1-10
class NumberPrinter{
    synchronized void print(){
        for (int i = 1 ; i<=10; i++){
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
        numberPrinter.print();
    }

    }
public class ThreadExampleUsingThreadClass {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();

      NumberPrinterThread thread1 = new NumberPrinterThread(numberPrinter);
      thread1.setName("Thread 1");
      NumberPrinter n= new NumberPrinter();
        thread1.setName("Thread 2");
        NumberPrinterThread thread2 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread3");

        thread1.start();// Thread 1 is calling run method.
        thread2.start();// Thread 2 is calling run method



    }
}
