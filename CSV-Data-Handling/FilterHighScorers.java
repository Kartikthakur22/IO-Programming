import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterHighScorers {
    public static void main(String[] args) {
        String fileName = "students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] data = line.split(",");
                if (data.length >= 4) {
                    int marks = Integer.parseInt(data[3]);
                    if (marks > 80) {
                        System.out.println("ID   : " + data[0]);
                        System.out.println("Name : " + data[1]);
                        System.out.println("Age  : " + data[2]);
                        System.out.println("Marks: " + data[3]);
                        System.out.println("-------------------------");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}

