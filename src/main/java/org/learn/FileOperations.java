package org.learn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOperations {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/org/learn/abc.txt"));

        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }



    }
}
