package mesinatm;

import java.util.Scanner;

public class InputValidation {
    
    public static int integerValidation(Scanner input) {
        int inputValidated;

        while (!input.hasNextInt()){
            System.out.println("Hanya boleh memasukan angka");
            System.out.print("Masukan angka : ");

            input.next();
        };

        return inputValidated = input.nextInt();
    }

    public static Double doubleValidation(Scanner input) {
        Double inputValidated;

        while (!input.hasNextDouble()){
            System.out.println("Hanya boleh memasukan angka asli/desimal");
            System.out.print("Masukan angka : ");

            input.next();
        };

        return inputValidated = input.nextDouble();
    }
}
