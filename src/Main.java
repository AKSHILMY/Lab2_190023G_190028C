import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        new Thread(new BusGenerator()).start();
        new Thread(new RiderGenerator()).start();
    }
    public static long arrivalTime(int mean) {
        double rate = 1.0 / mean;
        return Math.round(-Math.log(1 - random.nextDouble()) / rate);
    }
}