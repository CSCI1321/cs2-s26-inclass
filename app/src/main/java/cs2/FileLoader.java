package cs2;

import java.io.File;
import java.util.Scanner;

public class FileLoader {
    public static void main(String[] args) {
        try {
            File f = new File("notExist.txt");
            Scanner scan = new Scanner(f);
            System.out.println(scan.nextLine());
        } catch(Exception e) {
            System.out.println("ERROR!");
        }
    }
    
}
