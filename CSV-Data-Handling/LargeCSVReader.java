import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void main(String[] args) {
        String fileName = "large_students.csv";
        int chunkSize = 100;
        int totalCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String header = br.readLine(); // skip header
            String line;
            int chunkCount = 0;

            while (true) {
                int lineCount = 0;

                while (lineCount < chunkSize && (line = br.readLine()) != null) {
                    // Example: process the line (here we just print or skip)
                    // System.out.println(line);  // Optional: display or process line
                    lineCount++;
                    totalCount++;
                }

                if (lineCount == 0) break;

                chunkCount++;
                System.out.println("Processed " + (chunkCount * chunkSize) + " records so far...");
            }

            System.out.println("Total records processed: " + totalCount);
        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
}

