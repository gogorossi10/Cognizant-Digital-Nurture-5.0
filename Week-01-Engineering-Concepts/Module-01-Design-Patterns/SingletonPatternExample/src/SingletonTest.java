public class SingletonTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        logger1.log("First message");
        logger2.log("Second message");
        logger3.log("Third message");

        System.out.println(logger1 == logger2);
        System.out.println(logger2 == logger3);
    }
}