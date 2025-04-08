import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String output = "merged_students.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                BufferedReader br2 = new BufferedReader(new FileReader(file2));
                FileWriter writer = new FileWriter(output)
        ) {
            br1.readLine(); // skip header
            String line;

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    studentMap.put(data[0].trim(), new String[]{data[1].trim(), data[2].trim()});
                }
            }

            writer.write("ID,Name,Age,Marks,Grade\n");
            br2.readLine(); // skip header

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String id = data[0].trim();
                    String[] personal = studentMap.get(id);

                    if (personal != null) {
                        String mergedLine = String.join(",", id, personal[0], personal[1], data[1].trim(), data[2].trim());
                        writer.write(mergedLine + "\n");
                    }
                }
            }

            System.out.println("Merged data written to " + output);
        } catch (IOException e) {
            System.out.println("Error processing files.");
            e.printStackTrace();
        }
    }
}

