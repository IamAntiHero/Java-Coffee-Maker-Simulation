class BrewingThread extends Thread {
    private CoffeeMaker coffeeMaker;
    private HeatingElement heater;
    private WaterTank waterTank;
    private int waterNeeded;
    private int brewTime;
    private Logger logger;
    
    public BrewingThread(CoffeeMaker coffeeMaker, HeatingElement heater, WaterTank waterTank, 
                          int waterNeeded, int brewTime, Logger logger) {
        this.coffeeMaker = coffeeMaker;
        this.heater = heater;
        this.waterTank = waterTank;
        this.waterNeeded = waterNeeded;
        this.brewTime = brewTime;
        this.logger = logger;
    }
    
    public void run() {
        try {
            heater.heat();
            waterTank.useWater(waterNeeded);
            
            Thread.sleep(brewTime);
            
            synchronized(coffeeMaker) {
                coffeeMaker.setBrewingStatus(false);
                logger.log("Finished brewing coffee");
                System.out.println("Coffee is ready!");
            }
            
            heater.coolDown();
            
        } catch (InterruptedException e) {
            logger.log("Brewing interrupted: " + e.getMessage());
            System.out.println("Brewing was interrupted!");
            coffeeMaker.setBrewingStatus(false);
        }
    }
}
