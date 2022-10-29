
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class Main {

    static Scanner scan= new Scanner(System.in);
    static char c;
    // global List of fines class
    static List<Fines> fines=new ArrayList<Fines>() ;
    
// global List of Car Registrtin classes 
    static List<Truck> t = new ArrayList<Truck>();
    static List<TransportCar> trans = new ArrayList<TransportCar>();
    static List<PrivateCar> car = new ArrayList<PrivateCar>();

    public static void menu(){

        do {
            System.out.println("welcome to our system choose what you want :");
            System.out.println("1)Register a Car");
            System.out.println("2)Add Fines");
            System.out.println("3)display Registered Cars");
            System.out.println("4)display Registered Fines");
            System.out.println("5)Exit");



            c = scan.next().charAt(0);
            switch (c) {
                case '1':
                     System.out.println("Register New Car");
                    addVhicle();
                    break;
                case '2':
                    System.out.println("Add New fines");
                    addFines();
                    break;
                case '3':
                    System.out.println("display Registered Cars");
                    System.out.print("Which type of cars you want to display ?");
                    System.out.println("\n1-Truck \n2-Transport Cars\n3-Private Cars");
                    c=scan.next().charAt(0);
                    displayRegisteredVhicles(c);
                    


                    break;
                case '4':
                System.out.println("Display Registerd Car Fineses");
                
                dsiplayRegisteredFines();

                case '5':
                System.out.println("Exit");
                break;

                default:
                    System.out.println("you chose invalid choice!");
                    menu();
                    break;
            }
        } while (c != '5');

    
    }

    public static void main(String[] args) {

    //    Adminmenu();
        menu();
        addFinesToFile();
  
}


// adding vheiclse
public static void addVhicle() {

    System.out.print("enter vehicleType: truck || transport || car ");
    String type = scan.next();
    boolean check=true;
    while (check){

        if(!(type.equals("truck") || type.equals("transport") || type.equals("car"))){
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
  


    System.out.println("enter vin number: ");
    String Vin = scan.next();


//        checking its type

    if (type.equals("truck") ) {

        t.add(new Truck(1, model, year, annualNo, color, owner, plateNo, 200.0d, Vin));

    } else if (type.equals("transport")) {
        trans.add(new TransportCar(1, model, year, annualNo, color, owner, plateNo, Vin));

    } else if(type.equals("car")) {

        car.add(new PrivateCar(1, model, year, annualNo, color, owner, plateNo, Vin));


    }

//            v.add(new Vehicle(model, year, annualNo, color, owner, plateNo, type, Vin));

}


static void addFines(){
    System.out.print("Enter Car Type: ");
    String type=scan.next();
    System.out.print("Enter CarPlate Number: ");
    Integer plateNumber=scan.nextInt();
    System.out.print("Enter Annual Number :");
    String annualNo=scan.next();
    System.out.print("Enter Fines History Date :");
    String finesHistoryDate = scan.next();
    System.out.print("Enter typeOf Traffic Violation :");
    String typeOfTrafficViolation =scan.next();
    System.out.print("Amount of Traffic Violation :");
    Double amountOfTrafficViolationMoney =scan.nextDouble();
    System.out.print("total Number of Traffic Violation :");
    Integer totalViolation=scan.nextInt();
    System.out.print("Total Violation money :");
    Double totalMoney=scan.nextDouble();

    fines.add(new Fines(type,plateNumber,annualNo,finesHistoryDate,typeOfTrafficViolation, amountOfTrafficViolationMoney,totalViolation,totalMoney));

    addFinesToFile();

}

static void addFinesToFile(){

    try{
        ObjectOutputStream outData= new ObjectOutputStream(new FileOutputStream("FinesData.txt"));
        outData.writeObject(fines);
        outData.flush();
        outData.close();
        System.out.println("success");

    }catch(IOException e){
        e.printStackTrace();

    }


}


static void dsiplayRegisteredFines(){

    try{

        ObjectInputStream in=new ObjectInputStream(new FileInputStream("FinesData.txt"));


        ArrayList<Fines> finesFromFile = (ArrayList<Fines>) in.readObject();
        in.close();
        finesFromFile.stream().
               forEach(p-> System.out.println(p));
               System.out.println("sucess");
    }catch (Exception e) {
        e.printStackTrace();
    }


    

}

public static void Adminmenu(){


    System.out.println("Welcome to the car registration System and fines");
    System.out.println("enter 1 if you want to login : ->");
    System.out.println("1-Login ");
    int option=scan.nextInt();

    switch (option){
        case 1: AdminAccount.Login();

        break;
        default: break;


    }

}




}

