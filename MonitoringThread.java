class MonitoringThread extends Thread {
    private CoffeeMaker coffeeMaker;
    private HeatingElement heater;
    private Logger logger;
    
    public MonitoringThread(CoffeeMaker coffeeMaker, HeatingElement heater, Logger logger) {
        this.coffeeMaker = coffeeMaker;
        this.heater = heater;
        this.logger = logger;
    }
    
    public void run() {
        try {
            while (coffeeMaker.isBrewingStatus()) {
                synchronized(coffeeMaker) {
                    if (!coffeeMaker.isBrewingStatus()) break;
                    
                    int temp = heater.getTemperature();
                    logger.log("Temperature monitor: " + temp + "°C");
                    
                    if (temp > 105) {
                        logger.log("WARNING: Temperature too high!");
                        System.out.println("WARNING: Temperature too high!");
                    }
                }
                

                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            logger.log("Monitoring interrupted: " + e.getMessage());
        }
    }
}
