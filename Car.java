// Inheritance

import java.util.LinkedList;

class Car extends Vehicle{

    private String CarName;

    public Car (String carName,int Wheels){
        super(Wheels);
        this.CarName=carName;
    }


    // getter
    public String getName(){
        return CarName;
    }

    // setter
    public void setName(String carName){
        this.CarName=carName;
    }

    public static void main(String[] args){

        LinkedList<Car> cars =new LinkedList<Car>();

        cars.add(new Car("Benz",4));
        cars.add(new Car("TriCycle",3));
        

        System.out.println("--------------------------------------------------\nCars in the list\n");
        for (Car Car : cars) {
            System.out.println(Car.CarName);
        }
        System.out.println("\n--------------------------------------------------\n");

        Car newCar = new Car("City",4);
        newCar.setName("Benz");

        newCar.RideVehicle(newCar.Wheels);
        System.out.println("Your "+newCar.Wheels+" "+ newCar.CarName +" has started" );
    }
}
