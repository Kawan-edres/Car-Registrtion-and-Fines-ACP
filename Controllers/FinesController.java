package Controllers;

import Models.FinesModel;
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

  private static Set<FinesModel> fines = new HashSet<>();

  public static void addFinesData(PrintWriter out, BufferedReader in)
    throws ParseException, IOException {
    out.println("Enter Car Type: ");
    out.println("k");
    String type = in.readLine();
    boolean check = true;
    while (check) {
      if (
        !(
          type.equals("truck") ||
          type.equals("private") ||
          type.equals("transport")
        )
      ) {
        out.println("the type shuld be truck or private or transport");
        out.println("k");
        type = in.readLine();
      } else {
        check = false;
        break;
      }
    }
    out.println("Enter CarPlate Number: ");
    out.println("k");
    Integer plateNumber = Integer.parseInt(in.readLine());
    out.println("Enter Annual Number :");
    out.println("k");
    String annualNo = in.readLine();
    out.println("Enter typeOf Traffic Violation :");
    out.println("k");
    String typeOfTrafficViolation = in.readLine();
    out.println("Amount of Traffic Violation :");
    out.println("k");
    Double amountOfTrafficViolationMoney = Double.valueOf(in.readLine());
    out.println("total Number of Traffic Violation :");
    out.println("k");
    Integer totalViolation = Integer.parseInt(in.readLine());
    out.println("Total Violation money :");
    out.println("k");
    Double totalMoney = Double.valueOf(in.readLine());

    LocalDate dateObj = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String date = dateObj.format(formatter);
    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);

    readFinesFromFile();
    fines.add(
      new FinesModel(
        type,
        plateNumber,
        annualNo,
        date1,
        typeOfTrafficViolation,
        amountOfTrafficViolationMoney,
        totalViolation,
        totalMoney
      )
    );
    writeFinesToFile();
  }

  static void writeFinesToFile() {
    try {
      ObjectOutputStream outData = new ObjectOutputStream(
        new FileOutputStream("FinesTest.txt")
      );
      outData.writeObject(fines);
      outData.flush();
      outData.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void readFinesFromFile() {
    try {
      ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("FinesTest.txt")
      );
      fines = (HashSet<FinesModel>) in.readObject();
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static void printFines(PrintWriter out) {
    readFinesFromFile();
    fines.stream().forEach(p -> out.println(p));
  }

  public static void deleteFines(int plateNumber, String type) {
    readFinesFromFile();
    fines.removeIf(p ->
      (p.getCarPlateNumber() == plateNumber && p.getCarType().equals(type))
    );
    writeFinesToFile();
  }

  public static void search(PrintWriter out, int plateNumber, String type) {
    readFinesFromFile();
    fines
      .stream()
      .filter(p ->
        p.getCarPlateNumber() == plateNumber && p.getCarType().equals(type)
      )
      .forEach(p -> out.println(p));
  }
}
