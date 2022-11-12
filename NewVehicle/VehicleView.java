
package Vehicle;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;


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

    void displayTruck(Set<Truck> truck){
      
        truck.stream().forEach(System.out::println);

    }




    void displayTransport(Set<TransportCar> trans){

        
        trans.stream().forEach(System.out::println);
    }




   void displayPrivateCar(Set<PrivateCar> privateCar){

       
       privateCar.stream().forEach(System.out::println);
}





static VehicleModule module =new VehicleModule();
static VehicleView View =new VehicleView();

static VehicleControler v= new VehicleControler(module, View);

    public static void main(String[] args) {
        char c;
        do{
            System.out.println("Welcome to the  Car Fines System ");
            System.out.println("------------------------------------");
            System.out.println("Choose What do you want :");
            System.out.println("1-Add Vehicle ");
            System.out.println("2-display car");
            System.out.println("3-Display All display all type of car ");
            System.out.println("4-Search for spesfic Car");
            System.out.println("5-Exit");
            c=scan.next().charAt(0);


            switch (c){
                case'1':
               v.addVhicle();
                    break;
                case '2':

                    System.out.print("Display Enter the type of car ");
                    String type=scan.next();
                    v.displayVehicle(type);
                    
                    break;
                    case'3':
                    v.displayAll();
                         break;
                    case'4':
                    System.out.println("what is the type of car :");
                    String Type=scan.next();
                    System.out.println("Enter the annual number of the vehicle:");
                    String annual=scan.next();

                         v.serchForCar(annual, Type);
                              break;
                     case '5':
                    System.out.println("Exit...");
                     default:
                    System.out.println("Choose on of the above options to start !");
                    break;

            }

        }while (c!='5');

    }

}
