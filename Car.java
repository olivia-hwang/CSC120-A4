import java.util.ArrayList;
import java.util.List;

/**
 * Car class implementing CarRequirements
 * creates a Car object with list of passengers and car capacity
 */
public class Car implements CarRequirements{


    //class attributes
    public List<Passenger> Passengers = new ArrayList<>();
    private int carCapacity;
 
    
    // constructor
    Car(List<Passenger> Passengers, int carCapacity){
        this.Passengers = Passengers;
        this.carCapacity = carCapacity;

    }

    //methods
    /**
     * getter for car capacity
     * @return carCapacity
     */
    public int getCapacity(){
        return this.carCapacity;
    }

    /**
     * getter for seats remaining
     * @return spacesRemaining
     */
    public int seatsRemaining(){
        int passengerCount = this.Passengers.size();
        int spacesRemaining = this.carCapacity - passengerCount;
        return spacesRemaining;
    }

    /**
     * adds a passenger p
     * @return passengerAdded
     */
    public Boolean addPassenger(Passenger p){
        boolean passengerAdded= false;
        if (this.seatsRemaining() >0) {
            this.Passengers.add(p);
            passengerAdded  = true;
        } 
        System.out.println(passengerAdded);
        return passengerAdded;
    }

    /**
     * removes a passenger p
     * @return passengerRemoved
     */
    public Boolean removePassenger(Passenger p){
        boolean passengerRemoved = false;

        //check the entire car for Passenger p
        int length = Passengers.size(); 
        boolean passengerExists = false;
        for (int i = 0; i<length; i++) {
            if (Passengers.get(i)== p) {
                passengerExists = true;
            }
        }

        //remove the passenger
        if (passengerExists == true) {
            int index = Passengers.indexOf(p);
            Passengers.remove(index);
            passengerRemoved = true;         
        }
        return passengerRemoved;
    }

    /**
     * prints a list of passengers
     */
    public void printManifest(){
        int length = Passengers.size();
        if (length >0){
            System.out.println(Passengers);
        } else{
            System.out.println("This car is EMPTY.");
        }
    }

    public static void main(String[] args) {
        //Car myCar = new Car([], 50);
    }









}