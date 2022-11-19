package Controllers;



import Models.RenewAnnualModel;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RenewController {
    static Scanner scan = new Scanner(System.in);

    private static Set<RenewAnnualModel> renewAnnual = new HashSet<>();



    public static void addRenewAnnualData() {

        System.out.print("Enter CarPlate Number: ");
        Integer plateNumber = scan.nextInt();

        System.out.println("owner Full Name");
        String owenerFullName = scan.next();

        System.out.println("Owener Addrees ");
        String owenerAddress = scan.next();
        System.out.println("Car Model");
        String carModel = scan.next();
        System.out.print("Enter Car Type: ");
        String vechicleType = scan.next();
        boolean check = true;
        while (check) {
            if (!(vechicleType.equals("truck") || vechicleType.equals("private") || vechicleType.equals("transport"))) {
                System.out.println("the type shuld be truck or private or transport");
                vechicleType = scan.next();

            } else {
                check = false;
                break;
            }

        }
        System.out.println("Enter VIN");
        String VIN = scan.next();

        System.out.println("Car Color");
        String carColor = scan.next();

        System.out.println("Annuall start Date ");
        String annualStartDate = scan.next();

        System.out.println("Annuall End Date ");
        String annualEndDate = scan.next();

        System.out.println("Vheicle SafetyE ndDate");
        String vheicleSafetyEndDate = scan.next();

        System.out.println("Environment Fines EndDate");
        String environmentFinesEndDate = scan.next();

        System.out.println("Chain Number ");
        int vheicleChainNumber = scan.nextInt();
        readRenewAnnualFromFile();
        renewAnnual.add(new RenewAnnualModel(plateNumber, owenerFullName, owenerAddress, carModel, vechicleType, carColor, annualStartDate, annualEndDate, vheicleChainNumber, vheicleSafetyEndDate, environmentFinesEndDate, VIN));
        writeRenewAnnualToFile();


    }
static void writeRenewAnnualToFile() {
        try {
            ObjectOutputStream outData = new ObjectOutputStream(new FileOutputStream("renewAnnual.txt"));
            outData.writeObject(renewAnnual);
            outData.flush();
            outData.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
static void readRenewAnnualFromFile() {
        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("renewAnnual.txt"));
            renewAnnual = (HashSet<RenewAnnualModel>) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    
    public static  void  print(){
        readRenewAnnualFromFile();
        renewAnnual.stream().forEach(System.out::println);
    }
    
    public static  void delete(int plateNumber){
        readRenewAnnualFromFile();
        renewAnnual.removeIf(p->p.getVehiclePlateNumber() == plateNumber );
        writeRenewAnnualToFile();
    }

public static void search(int plateNumber,String type){
        readRenewAnnualFromFile();
        renewAnnual.stream().filter(p-> p.getVehiclePlateNumber()==plateNumber && p.getCarType().equals(type) ).forEach(p-> System.out.println(p));

    }

}