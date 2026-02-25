import java.util.ArrayList;
import java.util.List;

public class Train implements TrainRequirements{

    //attributes
    private FuelType fuelType;
    private double currentFuelLevel;
    private double fuelCapacity;
    private int nCars;
    private int passengerCapacity;
    private Engine eng;
    private List<Car> cars = new ArrayList<>();
    private ArrayList <Passenger> Passengers = new ArrayList<>();


    /**
     * constructor
     */
    Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity){
       this.fuelType = fuelType;
       this.currentFuelLevel = currentFuelLevel;
       this.fuelCapacity= fuelCapacity;
       this.nCars = nCars;
       this.passengerCapacity = passengerCapacity;

        //engine vroom vroom
        // add one engine
        this.eng = new Engine(fuelType, currentFuelLevel, fuelCapacity);

        for (int i = 0; i < nCars; i++) {
            //add nCars number of cars
            ArrayList <Passenger> Passengers = new ArrayList<>();
            cars.add(new Car(Passengers, this.passengerCapacity));
        }
        
    }

    /**
     * getter for engine 
     * adds engine to the train
     */
    public Engine getEngine(){
        return eng;
    }

    /**
     * getter for car 
     * gets the specified car
     */
    public Car getCar(int i){
        return cars.get(i);
    }

    /**
     * getter for max capacity
     */
    public int getMaxCapacity(){
        int trainCapacity = passengerCapacity*nCars;
        return trainCapacity;
    }

    /**
     * seatsRemaining
     * calculates the number of seats remaining in the entire train
     */
    public int seatsRemaining(){
        int trainCapacity = passengerCapacity*nCars;
        int remainingTrainCap = trainCapacity - this.Passengers.size();
        return remainingTrainCap;
    }

    /**
     * prints a list of names of all passengers on board
     * I couldn't get this to work :(
     */
    public void printManifest(){
        
        for (int i = 0; i < nCars; i++) {
            cars.get(i).Passengers.stream()
                .map(Passenger::getName)
                .forEach(System.out::println);;
        }
    }

    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("Olivia");
        Passenger passenger2 = new Passenger("Bob");

        Train myTrain = new Train(FuelType.STEAM, 40.0, 100.0, 5, 30);
        myTrain.printManifest();//yay! works
        //System.out.println(myTrain.cars.get(0).toString()); //works
        myTrain.cars.get(0).addPassenger(passenger1);
        //passenger1.boardCar(myTrain.cars.get(1));
        myTrain.getCar(0);
        myTrain.printManifest();
    }
}
