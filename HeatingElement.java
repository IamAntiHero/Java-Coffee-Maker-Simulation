class HeatingElement { 
    private int temperature;
    
    public HeatingElement() {
        this.temperature = 0;
    }
    
    public void heat() {
        temperature = 100;  
    }
    
    public void coolDown() {
        temperature = 0;
    }
    
    public int getTemperature() {
        return temperature;
    }
}
