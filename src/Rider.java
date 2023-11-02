class Rider implements Runnable {
    int id;
    public Rider(int id) {
        this.id = id;
    }

    public void run() {
        try {
            // Bus Arrival
            SemaphoreCollection.mutex.acquire();
            Constant.waiting++;
            SemaphoreCollection.mutex.release();

            // Bus Boarding
            SemaphoreCollection.bus.acquire();
            System.out.println("Boarded Rider (ID): " + this.id);
            Constant.boardedRiders.add(this.id);
            Constant.waiting--;
            SemaphoreCollection.boarded.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}