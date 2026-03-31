package cs2.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class TextAnalysis {
    

    public static Set<String> getWords(Scanner scan) {
        return null;
    }

    public static void main(String[] args) {
        try {
            File fin = new File("tempest.txt");
            System.out.println(fin.getPath());
            System.out.println(fin.canRead());
            Scanner scan = new Scanner(fin);

            getWords(scan);
            while(scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
