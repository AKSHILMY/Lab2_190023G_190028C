class Bus implements Runnable {
    int id;

    public Bus(int id) {
        this.id = id;
    }

    public void run() {
        try {
            SemaphoreCollection.mutex.acquire();
            int n = Math.min(Constant.waiting, Constant.CAPACITY);
            for (int i = 0; i < n; i++) {
                SemaphoreCollection.bus.release();
                SemaphoreCollection.boarded.acquire();
            }
            if (n != 0) {
                Constant.waiting = Math.max(Constant.waiting - Constant.CAPACITY, 0);
                System.out.println("************ Number of Riders boarded: " + n + " in Bus (ID): " + this.id + ", First Boarded Rider (ID): " + Constant.boardedRiders.get(0) + ", Last Boarded Rider (ID): " + Constant.boardedRiders.get(n - 1) + " ************");
                Constant.boardedRiders.subList(0, n).clear();
                SemaphoreCollection.mutex.release();
                System.out.println("************ Departed Bus (ID): " + this.id + " ************");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

