import java.util.ArrayList;

public class Constant {
    static int waiting = 0;  // No. of riders waiting
    static final int CAPACITY = 50; // Maximum No. of riders to be boarded in a bus

    static final int busInterArrivalTime = 20*60; // seconds
    static final int riderInterArrivalTime = 30; // seconds

    static ArrayList<Integer> boardedRiders = new ArrayList<>(); // riders boarded to the current bus
}
