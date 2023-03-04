import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class WorkingWithFile {
    public void searchValidNumber() {
        String absolutePath = "D:\\Soft\\idea produckt\\Module 10\\src\\file.txt";
        File file = new File(absolutePath);
        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " not exists");
        }
        try(FileInputStream stream = new FileInputStream(file)) {
            String regex = "(\\(\\d{3}\\)\\s\\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4})";

            try(Scanner scanner = new Scanner(stream)) {
                while (scanner.hasNextLine()) {
                    var line = scanner.nextLine();
                    if (line.matches(regex)) {
                        System.out.println(line);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
