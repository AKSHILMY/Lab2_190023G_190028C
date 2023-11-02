class RiderGenerator implements Runnable {
    int id = 0;
    public void run() {
        while (true) {
            try {
                long riderArrivalTime = Main.arrivalTime(Constant.riderInterArrivalTime);
                Thread.sleep(riderArrivalTime);
                System.out.println("Arrived Rider (ID): " + id);

                // Start a thread for the rider arrived
                new Thread(new Rider(id)).start();
                id++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}