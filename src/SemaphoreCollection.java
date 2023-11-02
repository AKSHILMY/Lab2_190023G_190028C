import java.util.concurrent.Semaphore;

public class SemaphoreCollection {
    static Semaphore mutex = new Semaphore(1);
    static Semaphore bus = new Semaphore(0);
    static Semaphore boarded = new Semaphore(0);
}
