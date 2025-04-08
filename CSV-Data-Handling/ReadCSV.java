import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String csvFile = "students.csv"; // Path to your CSV file
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] student = line.split(delimiter);
                if (student.length >= 4) {
                    System.out.println("Student ID: " + student[0]);
                    System.out.println("Name      : " + student[1]);
                    System.out.println("Age       : " + student[2]);
                    System.out.println("Marks     : " + student[3]);
                    System.out.println("---------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

