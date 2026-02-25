public class Engine implements EngineRequirements{

    
    /**
     * This is the attributes of the Engine class
     * Fueltype is the enum value of the fueltype for the train
     * currentFuel is a decimal value of the current fuel level
     * maxFuel is a decimal value of the total fuel level
     */
    // declare fuel type and fuel attributes
    private FuelType f;
    private double currentFuel;
    private double maxFuel;
    
    Engine(FuelType f, double currentFuel, double maxFuel){
        this.f=f;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
    }
    /**
     * getter for FuelType
     * @return fueltype f
     */
    public FuelType getFuelType() {
        return f;
    }

    /**
     * getter for maxFuel
     * @return maxFuel
     */
    public double getMaxFuel() {
        return maxFuel;

    }
    /**
     * getter for currentFuel
     * @return currentFuel
     */
    public double getCurrentFuel() {
        return currentFuel;

    }

    /**
     * refuels currentFuel level to the maxFuel level
     */
    public void refuel() {
        this.currentFuel = maxFuel;
    }

    /**
     * makes the train "go"
     * depletes .2 amount of fuel per run
     * @return currentFuel level
     */
    public Boolean go() {
        double fuelUse = 0.20;

        //if fuelUse <= than currentFuel
        if (fuelUse <= this.currentFuel) {
            this.currentFuel = this.currentFuel - fuelUse;    
        } else{
            //replace fuel level with 0 for depletion
            this.currentFuel = 0;
        }
        
        System.out.println("The current fuel level is " + this.currentFuel + " out of " + this.maxFuel + " capacity.");
        return this.currentFuel != 0.00;
            
    }   
    




public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 50.0, 100.0);
        System.out.println(myEngine.getCurrentFuel());
        //while (myEngine.go()) {
        //    System.out.println("Choo choo!");
        //}
        //System.out.println("Out of fuel.");
    }





}