import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateSalary {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                FileWriter writer = new FileWriter(outputFile)
        ) {
            String line = br.readLine();
            if (line != null) {
                writer.write(line + "\n");
            }

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4 && data[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3]);
                    salary = salary * 1.10;
                    data[3] = String.format("%.2f", salary);
                }
                writer.write(String.join(",", data) + "\n");
            }

            System.out.println("Updated records saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing the file.");
            e.printStackTrace();
        }
    }
}

