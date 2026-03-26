package cs2.util;

import java.util.HashMap;
import java.util.Map;

public class MapStuff {
    public static void main(String[] args) {
        Map<String,Double> m = new HashMap<String,Double>();
        System.out.println(m);
        m.put("Hello",5.0);
        m.put("Goodbye",Math.PI);
        m.put("A",0.0);
        m.put("B",1.0);
        System.out.println(m);
        m.remove("A");
        System.out.println(m);
        m.put("B",42.0);
        System.out.println(m);
        m.remove("C");
        System.out.println(m);
        System.out.println(m.containsKey("B"));
        System.out.println(m.containsValue(3.0));

        System.out.println(m.keySet());
        
    }
}
