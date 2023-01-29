import java.io.*;
import java.util.*;

public class EmployeeDetails {
  public static void main(String[] args) {
    List<String[]> managers = new ArrayList<>();
    List<String[]> singleNameEmployees = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
      String header = br.readLine();
      String line;
      while ((line = br.readLine()) != null) {
        String[] employee = line.split(",");
        String name = employee[0];
        String role = employee[1];
        String division = employee[2];

        if (role.equals("Manager") && division.equals("R&D")) {
          managers.add(employee);
        }

        if (name.split(" ").length == 1) {
          singleNameEmployees.add(employee);
        }
      }
    } catch (IOException e) {
      System.out.println("Error reading employees.csv file: " + e.getMessage());
    }

    try (PrintWriter managerWriter = new PrintWriter(new FileWriter("managers.csv"))) {
      managerWriter.println(header);
      for (String[] manager : managers) {
        managerWriter.println(String.join(",", manager));
      }
    } catch (IOException e) {
      System.out.println("Error writing managers.csv file: " + e.getMessage());
    }

    try (PrintWriter singleNameEmployeeWriter = new PrintWriter(new FileWriter("single_name_employees.csv"))) {
      singleNameEmployeeWriter.println(header);
      for (String[] singleNameEmployee : singleNameEmployees) {
        singleNameEmployeeWriter.println(String.join(",", singleNameEmployee));
      }
    } catch (IOException e) {
      System.out.println("Error writing single_name_employees.csv file: " + e.getMessage());
    }
  }
}
