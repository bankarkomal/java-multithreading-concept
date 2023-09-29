public class ThreadExampleUsingAnonymousClass {
    public static void main(String[] args) {
        Runnable lambdaTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("say hello" + Thread.currentThread().getName()+
                        "And state is"+ Thread.currentThread().getState());
            }
        };
        /*
        () -> System.out.println("Say hello");
        this is run() method implementation in the form of lambda expression
        this constructs an object and returns it.
        The reference for the object is 'lambdaTask'
         */
        Thread thread = new Thread(lambdaTask);
        thread.start();
    }
}
