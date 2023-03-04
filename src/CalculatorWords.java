import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class CalculatorWords {
    private HashMap<String, Integer> words = new HashMap<>();

    public void calculatorWords() {

        try {
            FileInputStream stream = new FileInputStream("D:\\Soft\\idea produckt\\Module 10\\src\\words.txt");
            Scanner scanner = new Scanner(stream);

            while (scanner.hasNext()) {
                String word = scanner.next();

                if (words.containsKey(word)) {
                    int value = words.get(word) + 1;
                    words.put(word, value);
                    continue;
                }

                words.put(word, 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printWords() {
        ValueComparator bvc = new ValueComparator(words);
        TreeMap<String, Integer> sortedMap = new TreeMap<>(bvc);
        sortedMap.putAll(words);

        Set<String> keys = sortedMap.keySet();
        for (String key : keys) {
            var value = words.get(key);
            System.out.println(key + " " + value);
        }
    }

    class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
