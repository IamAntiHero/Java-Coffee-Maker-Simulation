class CoffeeMaker extends Appliance {
    private HeatingElement heater;
    private WaterTank waterTank;
    private String coffeeStrength;
    private boolean brewing;
    private Logger logger;
    
    public CoffeeMaker(String model, int waterCapacity) {
        super(model);
        this.heater = new HeatingElement();
        this.waterTank = new WaterTank(waterCapacity);
        this.coffeeStrength = "medium";
        this.brewing = false;
        this.logger = new Logger("coffee_maker_log.txt");
    }
    
    public void turnOn() {
        setPowerOn(true);
        logger.log("Coffee maker turned ON");
        System.out.println("Coffee maker is now ON");
    }
    
    public void turnOff() {
        setPowerOn(false);
        logger.log("Coffee maker turned OFF");
        System.out.println("Coffee maker is now OFF");
    }
    
    public void fillWater(int amount) {
        waterTank.fill(amount);
        logger.log("Water tank filled with " + amount + " ml");
        System.out.println("Water tank filled. Current level: " + waterTank.getWaterLevel() + " ml");
    }
    
    public void setCoffeeStrength(String strength) {
        this.coffeeStrength = strength;
        logger.log("Coffee strength set to: " + strength);
        System.out.println("Coffee strength set to: " + strength);
    }
    
    public boolean isBrewingStatus() {
        return brewing;
    }
    
    public void setBrewingStatus(boolean status) {
        this.brewing = status;
    }
    
    @Override
    public void operate() {
        if (!isPowerOn()) {
            System.out.println("Please turn on the coffee maker first");
            return;
        }
        brewCoffee();
    }
    
    public synchronized void brewCoffee() {
        if (!isPowerOn()) {
            System.out.println("Please turn on the coffee maker first");
            return;
        }
        
        if (brewing) {
            System.out.println("Already brewing coffee!");
            return;
        }
        
        int waterNeeded = getWaterAmountForStrength();
        
        if (waterTank.getWaterLevel() < waterNeeded) {
            System.out.println("Not enough water! Please add water.");
            logger.log("Brewing failed: Not enough water");
            return;
        }
        
        brewing = true;
        logger.log("Started brewing " + coffeeStrength + " coffee");
        System.out.println("Starting to brew " + coffeeStrength + " coffee...");
        
        // Start brewing thread
        BrewingThread brewingThread = new BrewingThread(
            this, heater, waterTank, waterNeeded, getBrewTimeForStrength(), logger
        );
        
        // Start temperature monitoring thread
        MonitoringThread monitoringThread = new MonitoringThread(
            this, heater, logger
        );
        
        brewingThread.start();
        monitoringThread.start();
    }
    
    private int getWaterAmountForStrength() {
        if (coffeeStrength.toLowerCase().equals("mild")) {
            return 200;
        } else if (coffeeStrength.toLowerCase().equals("strong")) {
            return 150;
        } else {
            return 180; // medium
        }
    }
    
    private int getBrewTimeForStrength() {
        if (coffeeStrength.toLowerCase().equals("mild")) {
            return 3000; 
        } else if (coffeeStrength.toLowerCase().equals("strong")) {
            return 5000; 
        } else {
            return 4000; // number here means the time taken to brew coffee in milliseconds
        }
    }
    
    public void showStatus() {
        System.out.println("--- Coffee Maker Status ---");
        System.out.println("Model: " + getModel());
        System.out.println("Power: " + (isPowerOn() ? "ON" : "OFF"));
        System.out.println("Water Level: " + waterTank.getWaterLevel() + "/" + waterTank.getCapacity() + " ml");
        System.out.println("Coffee Strength: " + coffeeStrength);
        System.out.println("Currently Brewing: " + (brewing ? "Yes" : "No"));
        System.out.println("Current Temperature: " + heater.getTemperature() + "°C");
        System.out.println("-------------------------");
    }
}
