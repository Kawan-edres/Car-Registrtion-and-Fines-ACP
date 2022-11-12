
    import java.util.*;

import Addmin.AdminAccount;
import NewVehicle.PrivateCar;
import NewVehicle.TransportCar;
import NewVehicle.Truck;

import java.io.*;


    public class Main {

        static Scanner scan= new Scanner(System.in);
        static char c;
        // global List of fines class
        static Set<Fines> fines=new HashSet<>() ;

    // global List of Car Registrtin classes
        static Set<Truck> t = new HashSet<Truck>();
        static Set<TransportCar> trans = new HashSet<TransportCar>();
        static Set<PrivateCar> car = new HashSet<PrivateCar>();

        public static void menu(){

            do {
                System.out.println("welcome to our system choose what you want :");
                System.out.println("1)Register a Car");
                System.out.println("2)Add Fines");
                System.out.println("3)display Registered Truck");
                System.out.println("4)display Registered Transport Cars");
                System.out.println("5)display Registered Private Cars");
                System.out.println("6)display Registered Fines");
                System.out.println("7)Exit");



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
                        System.out.println("Display Trucks");
                        displayTruck();
                        break;
                    case '4':
                        System.out.println("Display Transport Cars");
                        displayTransport();

                        break;
                    case '5':
                        System.out.println("Display Private Cars");
                        displayPrivateCar();
                        break;
                    case '6':
                    System.out.println("Display Registerd Car Fineses");
                    dsiplayRegisteredFines();
                    break;

                    case '7':
                    System.out.println("Exit");
                    break;

                    default:
                        System.out.println("you chose invalid choice!");
                        menu();
                        break;
                }
            } while (c != '7');


        }

        public static void main(String[] args) {

    //        Adminmenu();
            menu();




    }


    // adding vheiclse
    public static void addVhicle() {

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


    //        checking its type

        if (type.equals("truck") ) {

            t.add(new Truck(1, model, year, annualNo, color, owner, plateNo, 200.0d, Vin));
            addnewTruckToFile();

        } else if (type.equals("transport")) {
            trans.add(new TransportCar(1, model, year, annualNo, color, owner, plateNo, Vin));
            addnewTransportCarToFile();
        } else if(type.equals("private")) {

            car.add(new PrivateCar(1, model, year, annualNo, color, owner, plateNo, Vin));
            addNewPrivateCarToFile();


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

    static void addnewTruckToFile(){
        try{
            ObjectOutputStream outData= new ObjectOutputStream(new FileOutputStream("truck.txt"));
            outData.writeObject(t);
            outData.flush();
            outData.close();
            System.out.println("success");

        }catch(IOException e){
            e.printStackTrace();

        }


    }
        static void addNewPrivateCarToFile(){
            try{
                ObjectOutputStream outData= new ObjectOutputStream(new FileOutputStream("privatecar.txt"));
                outData.writeObject(car);
                outData.flush();
                outData.close();
                System.out.println("success");

            }catch(IOException e){
                e.printStackTrace();

            }


        }

    static  void addnewTransportCarToFile(){
        try{
            ObjectOutputStream outData= new ObjectOutputStream(new FileOutputStream("transport.txt"));
            outData.writeObject(trans);
            outData.flush();
            outData.close();
            System.out.println("success");

        }catch(IOException e){
            e.printStackTrace();

        }

    }
    static void displayTruck(){



        try{

            ObjectInputStream in=new ObjectInputStream(new FileInputStream("truck.txt"));




            Optional<HashSet<Truck>> checkNull = Optional.ofNullable((HashSet<Truck>)  in.readObject());

    //        System.out.println(checkNull);
            if(checkNull.isEmpty()){
                System.out.println("file is empty ");
            }
            else{
                checkNull.stream().
                        forEach( System.out::println);
            }


            in.close();


        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();

        }


    }

        static void displayTransport(){

            try{

                ObjectInputStream in=new ObjectInputStream(new FileInputStream("transport.txt"));


                Optional<HashSet<TransportCar>> checkNull = Optional.ofNullable((HashSet<TransportCar>)  in.readObject());


                in.close();
                checkNull.stream().
                        forEach( System.out::println);
                System.out.println("sucess");
            }catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


        static void displayPrivateCar(){

            try{

                ObjectInputStream in=new ObjectInputStream(new FileInputStream("privatecar.txt"));



                Optional<HashSet<PrivateCar>> checkNull = Optional.ofNullable((HashSet<PrivateCar>) in.readObject());

                in.close();
                checkNull.stream().
                        forEach( System.out::println);
                System.out.println("sucess");
            }catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        static void dsiplayRegisteredFines(){

            try{

                ObjectInputStream in=new ObjectInputStream(new FileInputStream("FinesData.txt"));

                Optional<HashSet<Fines>> checkNull = Optional.ofNullable((HashSet<Fines>) in.readObject());
                in.close();
                checkNull.
                        stream().
                       forEach(p-> System.out.println(p));;
                       System.out.println("sucess");
            }catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
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

