package by.it.zagurskaya.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Showcase {

    private static Map<String, Double> storage = new HashMap<String, Double>() {{
        put("молоко", new Double(1.2));
        put("кефир", new Double(2.4));
        put("хлеб", new Double(1.3));
        put("батон", new Double(2.4));
        put("калбаса", new Double(5));
        put("сыр", new Double(6));
        put("вино", new Double(15));
        put("домино", new Double(2.1));
        put("билет в кино", new Double(10));
        put("маянез", new Double(3.2));
    }};

    public static Map<String, Double> getShowcase() {
        return storage;
    }

    public static Map<String, Double> getGoodByOrder() {
        Map<String, Double> randomGood = new HashMap<>();
        int number = (int) (Math.random()*storage.size());
        int i = 0;
        for (Map.Entry<String, Double> entry: storage.entrySet()){
            if (i == number) {
                String key = entry.getKey();
                Double value = entry.getValue();
                randomGood.put(key, value);
                i++;
            } else {
                i++;
            }
        }
        return randomGood;
    }
}
