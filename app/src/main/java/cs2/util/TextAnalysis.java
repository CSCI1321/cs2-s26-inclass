package cs2.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TextAnalysis {
    

    public static Set<String> getWords(Scanner scan) {
        HashSet<String> words = new HashSet<>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("\\s+");
            for(String word : parts) {
                words.add(word.toUpperCase().replaceAll("[^A-Za-z\']",""));
            }
        }
        return words;
    }
    public static Map<String,Integer> countWords(Scanner scan) {
        HashMap<String,Integer> counts = new HashMap<>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("\\s+");
            for(String word : parts) {
                String fixedWord = word.toUpperCase().replaceAll("[^A-Za-z\']","");
                if(!counts.containsKey(fixedWord)) {
                    counts.put(fixedWord, 1);
                } else {
                    counts.put(fixedWord, counts.get(fixedWord) + 1);
                }

            }
        }
        counts.remove("");
        return counts;
    }

    public static void main(String[] args) {
        try {
            File fin = new File("tempest.txt");
            System.out.println(fin.getPath());
            System.out.println(fin.canRead());
            Scanner scan = new Scanner(fin);
            Set<String> wordSet = getWords(scan);
            System.out.println(wordSet);
            System.out.println(wordSet.size());

            scan = new Scanner(fin);
            Map<String,Integer> counts = countWords(scan);
            System.out.println(counts);
            System.out.println(counts.size());

            String bigKey = "";
            for(String key : counts.keySet()) {
                if(counts.get(key) > counts.get(bigKey)) {
                    bigKey = key;
                }
            }
            System.out.println(bigKey + ": " + counts.get(bigKey));

        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
