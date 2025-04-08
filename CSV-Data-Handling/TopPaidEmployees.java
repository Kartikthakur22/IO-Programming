import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TopPaidEmployees {
    public static void main(String[] args) {
        String fileName = "employees.csv";
        List<String[]> employeeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String header = br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] data = line.split(",");
                if (data.length >= 4) {
                    employeeList.add(data);
                }
            }

            employeeList.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

            System.out.println("Top 5 highest-paid employees:");
            System.out.println("ID  Name      Department  Salary");
            System.out.println("----------------------------------");

            for (int i = 0; i < Math.min(5, employeeList.size()); i++) {
                String[] e = employeeList.get(i);
                System.out.printf("%-4s%-10s%-12s%s%n", e[0], e[1], e[2], e[3]);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}
