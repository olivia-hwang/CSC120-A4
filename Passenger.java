public class Passenger implements PassengerRequirements{
    
    private String name;

    /**
     * constructor
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * getter for passenger name
     * @return passenger's name
     */
    public String getName(Passenger p) {
        p.name = name;
        return name;
    }

    /**
     * board a car 
     * adds a passenger to the specified car
     */
    public void boardCar(Car c){
        c.addPassenger(this);

    }

    /**
     * gets off a car 
     * removes a passenger from the specified car
     */
    public void getOffCar(Car c){
        c.removePassenger(this);

    }
}
