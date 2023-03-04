import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class WorkWithJSON {

    public void workWithFile() {

        Collection<Person> persons = new ArrayList<>();

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            Scanner scanner = new Scanner(new FileInputStream("D:\\Soft\\idea produckt\\Module 10\\src\\fileGson.txt"));
            JsonWriter writer = gson.newJsonWriter(new FileWriter("D:\\Soft\\idea produckt\\Module 10\\src\\user.json.txt"));

            String title = scanner.nextLine();
            String[] arrayTitle = title.split(" ");

            while (scanner.hasNextLine()) {
                String values = scanner.nextLine();
                String[] arraysValues = values.split(" ");
                Person person = new Person(arraysValues[0], arraysValues[1]);
                persons.add(person);
            }

            String jsonPerson = gson.toJson(persons);
            writer.jsonValue(jsonPerson);

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
