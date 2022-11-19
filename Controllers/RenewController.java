package Controllers;


import Models.RenewAnnualModel;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RenewController {
    static Scanner scan = new Scanner(System.in);

    private static Set<RenewAnnualModel> renewAnnual = new HashSet<>();


    public static void addRenewAnnualData(PrintWriter out, BufferedReader in) throws IOException {

        out.println("Enter CarPlate Number: ");
        out.println("k");
        int plateNumber = Integer.parseInt(in.readLine());

        out.println("owner Full Name: ");
        out.println("k");
        String owenerFullName = in.readLine();

        out.println("Owener Addrees ");
        out.println("k");
        String owenerAddress = in.readLine();

        out.println("Car Model");
        out.println("k");
        String carModel = in.readLine();

        out.println("Enter Car Type: ");
        out.println("k");
        String vechicleType = in.readLine();

        boolean check = true;
        while (check) {
            if (!(vechicleType.equals("truck") || vechicleType.equals("private") || vechicleType.equals("transport"))) {

                out.println("the type shuld be truck or private or transport");
                out.println("k");
                vechicleType = in.readLine();

            } else {
                check = false;
                break;
            }

        }
        out.println("Enter VIN");
        out.println("k");
        String VIN = in.readLine();

        out.println("Car Color");
        out.println("k");
        String carColor = in.readLine();

        out.println("Annuall start Date ");
        out.println("k");
        String annualStartDate = in.readLine();

        out.println("Annuall End Date ");
        out.println("k");
        String annualEndDate = in.readLine();

        out.println("Vheicle SafetyE ndDate");
        out.println("k");
        String vheicleSafetyEndDate = in.readLine();

        out.println("Environment Fines EndDate");
        out.println("k");
        String environmentFinesEndDate = in.readLine();

        out.println("Chain Number ");
        out.println("k");
        int vheicleChainNumber = Integer.parseInt(in.readLine());

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


    public static void print(PrintWriter out) {
        readRenewAnnualFromFile();
        renewAnnual.stream().forEach(p-> out.println(p));
    }

    public static void delete(int plateNumber, String typeTodelete) {
        readRenewAnnualFromFile();
        renewAnnual.removeIf(p -> p.getVehiclePlateNumber() == plateNumber && p.getCarType().equals(typeTodelete));
        writeRenewAnnualToFile();
    }

    public static void search(PrintWriter out ,int plateNumber, String type) {
        readRenewAnnualFromFile();
        renewAnnual.stream().filter(p -> p.getVehiclePlateNumber() == plateNumber && p.getCarType().equals(type)).forEach(p -> out.println(p));

    }

}
