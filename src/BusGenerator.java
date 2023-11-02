class BusGenerator implements Runnable {
    int id = 0;
    public void run() {
        while (true) {
            try {
                long busArrivalTime = Main.arrivalTime(Constant.busInterArrivalTime);
                Thread.sleep(busArrivalTime);
                System.out.println("************ Bus Arrived (ID): " + id +" ************");

                // Start a thread for the bus arrived
                new Thread(new Bus(id)).start();
                id++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
