package JSONCSV;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.util.*;

public class JsonCsvConverter {

    public static void jsonToCsv(String jsonFile, String csvFile) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Student> students = mapper.readValue(new File(jsonFile), new TypeReference<List<Student>>() {});
            FileWriter writer = new FileWriter(csvFile);
            writer.write("ID,Name,Age,Marks\n");
            for (Student s : students) {
                writer.write(s.id + "," + s.name + "," + s.age + "," + s.marks + "\n");
            }
            writer.close();
            System.out.println("CSV file created: " + csvFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Student s = new Student(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                studentList.add(s);
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile), studentList);
            System.out.println("JSON file created: " + jsonFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        jsonToCsv("students.json", "students.csv");
        csvToJson("students.csv", "students_output.json");
    }
}


