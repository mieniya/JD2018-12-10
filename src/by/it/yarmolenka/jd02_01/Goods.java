package by.it.yarmolenka.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Goods {
    static Map<String, Double> goods = new HashMap<>();

    static void load() {
        goods.put("хлеб", 0.7);
        goods.put("молоко", 1.3);
        goods.put("кефир", 1.4);
        goods.put("колбаса", 4.0);
        goods.put("сыр", 3.1);
        goods.put("мандарины", 2.1);
        goods.put("чай", 3.4);
        goods.put("батон", 0.6);
        goods.put("огурцы", 2.2);
        goods.put("пельмени", 3.1);
        goods.put("яйца", 2.2);

    }
}
