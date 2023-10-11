









public class Driver {
    public static void main(String[] args) {
        Counter counter = new Counter(100);// object got created on heap

        Thread threadCounter1 = new ThreadCounter(counter);
        threadCounter1.setName("Counter-1");
        Thread threadCounter2 = new ThreadCounter(counter);
        threadCounter2.setName("Counter-2");

        threadCounter1.start();// Run method called
        threadCounter2.start();//Run method called
    }
}
