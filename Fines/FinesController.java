package CarFines;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FinesController {

    static Scanner scan = new Scanner(System.in);

    private static Set<Model> fines = new HashSet<>();




    public static void addFinesData() throws ParseException {
        System.out.print("Enter Car Type: ");
        String type = scan.next();
        boolean check = true;
        while (check) {
            if (!(type.equals("truck") || type.equals("private") || type.equals("transport"))) {
                System.out.println("the type shuld be truck or private or transport");
                type = scan.next();
            } else {
                check = false;
                break;
            }

        }
        System.out.print("Enter CarPlate Number: ");
        Integer plateNumber = scan.nextInt();
        System.out.print("Enter Annual Number :");
        String annualNo = scan.next();
        System.out.print("Enter typeOf Traffic Violation :");
        String typeOfTrafficViolation = scan.next();
        System.out.print("Amount of Traffic Violation :");
        Double amountOfTrafficViolationMoney = scan.nextDouble();
        System.out.print("total Number of Traffic Violation :");
        Integer totalViolation = scan.nextInt();
        System.out.print("Total Violation money :");
        Double totalMoney = scan.nextDouble();

        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = dateObj.format(formatter);
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);

        readFinesFromFile();
        fines.add(new Model(type, plateNumber, annualNo, date1, typeOfTrafficViolation, amountOfTrafficViolationMoney, totalViolation, totalMoney));
        writeFinesToFile();
    }

    static void writeFinesToFile() {
        try {
            ObjectOutputStream outData = new ObjectOutputStream(new FileOutputStream("FinesTest.txt"));
            outData.writeObject(fines);
            outData.flush();
            outData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readFinesFromFile() {
        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("FinesTest.txt"));
            fines = (HashSet<Model>) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void printFines() {
        readFinesFromFile();
        fines.stream().forEach(p -> System.out.println(p));

    }

    public static void deleteFines(int plateNumber, String type) {
        readFinesFromFile();
        fines.removeIf(p -> (p.getCarPlateNumber() == plateNumber && p.getCarType().equals(type)));
        writeFinesToFile();

    }
    public static  void search(int plateNumber,String type){
        readFinesFromFile();
        fines.stream().filter(p-> p.getCarPlateNumber()==plateNumber && p.getCarType().equals(type)).forEach(p-> System.out.println(p));


    }

}
