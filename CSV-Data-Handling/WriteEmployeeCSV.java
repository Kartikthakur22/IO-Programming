import java.io.FileWriter;
import java.io.IOException;

public class WriteEmployeeCSV {
    public static void main(String[] args) {
        String fileName = "employees.csv";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("101,Kartik,Engineering,75000\n");
            writer.write("102,Anjali,HR,65000\n");
            writer.write("103,Rahul,Sales,62000\n");
            writer.write("104,Simran,Marketing,70000\n");
            writer.write("105,Vikram,Finance,68000\n");

            System.out.println("Employee data written to " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

