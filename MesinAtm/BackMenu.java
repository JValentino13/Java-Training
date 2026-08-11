package MesinAtm;

import java.util.Scanner;

public class BackMenu {
    public static int BackMenu(int menu, Scanner menuInput) {
        System.out.println("==============================");
        System.out.println("999. Menu");
        System.out.println("0. Keluar");
        System.out.print("Masukkan angka : ");
        menu = menuInput.nextInt();
        
        return menu;
    }
}
