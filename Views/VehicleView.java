
package Views;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;

import Controllers.VehicleControler;
import Models.PrivateCar;
import Models.TransportCar;
import Models.Truck;
import Models.Vehicle;
import Models.VehicleModule;


public class VehicleView implements Serializable {
   static Scanner scan =new Scanner(System.in);


    public Vehicle addVhicle() {

        System.out.print("enter vehicleType: truck || transport || private ");
        String type = scan.next();
        boolean check=true;
        while (check){


            if(!(type.equals("truck") || type.equals("transport") || type.equals("private"))){
                System.out.println("the type of car must be truck or transport or car");
                type=scan.next();
            }
            else {
                check=false;

            }

        }
        System.out.print("enter vhicle model: ");
        String model = scan.next();
        System.out.print("enter vhicle Year: ");
        Integer year = scan.nextInt();
        System.out.print("enter annual Number:  ");
        String annualNo = scan.next();
        System.out.print("enter vhicle color: ");
        String color = scan.next();
        System.out.print("enter owner Name: ");
        String owner = scan.next();
        System.out.print("enter plate Number: ");
        Integer plateNo = scan.nextInt();



        System.out.print("enter vin number: ");
        String Vin = scan.next();

        if (type.equals("truck") ) {

           return new Truck(plateNo, model, year, annualNo, color, owner, plateNo, null, Vin);
          
          

        } else if (type.equals("transport")) {

           return new TransportCar(plateNo, model, year, annualNo, color, owner, plateNo, Vin);
            

          
           
        } else if(type.equals("private")) {
         
           return (new PrivateCar(plateNo, model, year, annualNo, color, owner, plateNo, Vin));  // = rangrovar 
          

        }
        return null;

       

    }


/////////////////////////////////////////////////////

    public void displayTruck(Set<Truck> truck){
      
        truck.stream().forEach(System.out::println);

    }




    public void displayTransport(Set<TransportCar> trans){

        
        trans.stream().forEach(System.out::println);
    }




   public void displayPrivateCar(Set<PrivateCar> privateCar){

       
       privateCar.stream().forEach(System.out::println);
}








}
