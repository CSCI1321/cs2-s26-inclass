package cs2.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetStuff {
    public static void main(String[] args) {
        Set<String> s = new HashSet<String>();
        System.out.println(s);
        s.add("Hello");
        s.add("Goodbye");
        s.add("There");
        System.out.println(s);
        s.add("Hello");
        System.out.println(s);
        System.out.println(s.size());
        s.remove("hello");
        System.out.println(s);
        System.out.println(s.contains("Goodbye"));
        Set<String> t = new HashSet<>();
        t.add("Goodbye");
        t.add("ZZZZ");

        System.out.println("S = " + s);
        System.out.println("T = " + t);
        Set<String> copy = new HashSet<>(s);
        copy.addAll(t);
        System.out.println("S = " + s);
        System.out.println("T = " + t);
        System.out.println("Copy = " + copy);

        //for(int i=0; i<s.size(); i++) {
        //    System.out.println(s.get(i));
        //}
        Iterator<String> it = copy.iterator();
        HashSet<String> dbl = new HashSet<>();
        while(it.hasNext()) {
            String item = it.next();
            System.out.println(item);
            dbl.add(item + item);
        }

        for(String item : copy) {
            for(String item2: copy) { 
                System.out.println(item + item2);
            }
        }

    }
}
