package mesinatm;

import java.util.Scanner;

public class BackMenu {
    public static int BackMenu(int menu, Scanner input) {

        do {
            System.out.println("==============================");
            System.out.println("999. Menu");
            System.out.println("0. Keluar");
            System.out.print("Masukkan angka : ");
            menu = InputValidation.integerValidation(input);

            if (!(menu == 0 || menu == 999)) {
                System.out.println("Masukan angka sesuai pilihan yang ada");
            }
        } while(!(menu == 0 || menu == 999));
        
        return menu;
    }
}
