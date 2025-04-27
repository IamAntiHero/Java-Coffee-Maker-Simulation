class WaterTank { 
    private int waterLevel;
    private int capacity;
    
    public WaterTank(int capacity) {
        this.capacity = capacity;
        this.waterLevel = 0;
    }
    
    public void fill(int amount) {
        waterLevel = Math.min(capacity, waterLevel + amount);
    }
    
    public boolean useWater(int amount) {
        if (waterLevel >= amount) {
            waterLevel -= amount;
            return true;
        }
        return false;
    }
    
    public int getWaterLevel() {
        return waterLevel;
    }
    
    public int getCapacity() {
        return capacity;
    }
}
