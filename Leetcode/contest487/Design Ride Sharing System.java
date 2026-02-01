class RideSharingSystem {
    Queue<Integer> riderIds;
    Queue<Integer> driverIds;
    List<Integer> prevMatchIds = new ArrayList<>();
    public RideSharingSystem() {
        riderIds = new LinkedList<>();
        driverIds = new LinkedList<>();
    }
    
    public void addRider(int riderId) {
        riderIds.add(riderId);
    }
    
    public void addDriver(int driverId) {
        driverIds.add(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if (riderIds.isEmpty() || driverIds.isEmpty()) {
            return new int[] {-1, -1};
        }
        int riderId = riderIds.poll();
        int driverId = driverIds.poll();
        prevMatchIds.add(riderId);
        return new int[] {driverId,riderId};
    }
    
    public void cancelRider(int riderId) {
        if (!prevMatchIds.contains(riderId)){
            riderIds.remove(riderId);
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
    */