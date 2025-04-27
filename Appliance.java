class Appliance {
    private boolean powerOn;
    private String model;

    public Appliance(String model) {
        this.powerOn = false;
        this.model = model;
    }

    public void operate() {
        System.out.println("Appliance is operating");
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
