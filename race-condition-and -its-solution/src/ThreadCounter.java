public class ThreadCounter extends Thread{
    Counter counter;

    @Override
    public void run() {

    }

    ThreadCounter(Counter counter){
        this.counter = counter;


            try {
                this.counter.count();
            }catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
                }

            }
        }

