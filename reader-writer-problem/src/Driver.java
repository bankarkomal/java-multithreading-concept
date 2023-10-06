/**
 * A CPU can be dual or quad-core and each can run one thread.
 * Each core has its own cache and this cache is used by the thread that is running
 * in this core.
 * core1 --> Thread1 [core1 cache1]  <-- [Heap(Main Memory)]
 * core2 --> Thread2 [core2 cache2]  <-- [Heap(Main Memory)]
 * Each thread reads message object from heap and stores them into their cache.
 */
class Message{
    String msg;
    boolean isEmptyMsg;

    public Message( String msg, boolean isEmptyMsg){
        this.msg = msg;
        this.isEmptyMsg = isEmptyMsg;

    }
    String readMsg (){
        while (isEmptyMsg){

        }
        this.isEmptyMsg = true;
        return this.msg;
    }
    void WriteMessage(String msg){
        // if message is not empty
        while (! isEmptyMsg){
        }
        System.out.println("message written is :" + msg);
        this.msg = msg;
        this.isEmptyMsg = false;

    }


}
class  Reader implements Runnable{
    Message message;
    public Reader (Message message){

        this.message =message;
    }
    @Override
    public void run() {
        String msg;
        for (msg = this.message.readMsg();
             !"Finished Writing!!!".equals(msg);
             msg = this.message.readMsg()){
            System.out.println("Message read by Reader: "+ msg);
        }
        System.out.println("Message read by Reader: "+ msg);
    }
}

class Writer implements Runnable {
    Message message;
    public Writer(Message message) {
        this.message = message;
    }
    @Override
    public void run() {
        for (String msg : new String[]{"Hello", "how", "are", "you"}){
            this.message.WriteMessage(msg);
        }
        this.message.WriteMessage("Finished Writing!!!");
    }
}



public class Driver {
    public static void main(String[] args) {
        Message message = new Message("", true);

        Thread readerThread = new Thread(new Reader(message));
        Thread writerThread = new Thread(new Writer(message));

        readerThread.start();
        writerThread.start();
    }
}

