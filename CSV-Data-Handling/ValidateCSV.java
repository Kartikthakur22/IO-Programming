import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String fileName = "contacts.csv";
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String header = br.readLine(); // skip header
            String line;
            int rowNum = 1;

            while ((line = br.readLine()) != null) {
                rowNum++;
                String[] data = line.split(",");
                if (data.length < 4) {
                    System.out.println("Row " + rowNum + ": Incomplete data");
                    continue;
                }

                String id = data[0].trim();
                String name = data[1].trim();
                String email = data[2].trim();
                String phone = data[3].trim();

                boolean valid = true;

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Row " + rowNum + ": Invalid email -> " + email);
                    valid = false;
                }

                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Row " + rowNum + ": Invalid phone number -> " + phone);
                    valid = false;
                }

                if (valid) {
                    System.out.println("Row " + rowNum + ": Valid - " + name);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}

