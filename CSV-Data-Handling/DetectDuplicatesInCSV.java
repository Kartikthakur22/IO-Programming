import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicatesInCSV {
    public static void main(String[] args) {
        String fileName = "students.csv";
        Set<String> seenIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String header = br.readLine(); // skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 0) continue;

                String id = data[0].trim();
                if (seenIds.contains(id)) {
                    duplicates.add(line);
                } else {
                    seenIds.add(id);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records based on ID:");
                for (String dup : duplicates) {
                    System.out.println(dup);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}

