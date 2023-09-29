public class ThreadExampleUsingLambdaExpression {
    public static void main(String[] args) {
        Runnable lambdaTask = () -> {
            System.out.println("say hell0 from"+ Thread.currentThread().getName()+
                    "and state is "+ Thread.currentThread().getState());
        };
        /*
        () -> ("say hello ");
        This is run method implementation in the from of lambda expression
        This construct an object and return it
        the reference for the object is lambda task
         */
        Thread thread = new Thread(lambdaTask);
        thread.start();
    }
}
