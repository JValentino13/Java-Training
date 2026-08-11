package MesinAtm;

import java.util.List;
import java.util.Scanner;

public class E_money {
    public static void e_money(Kartu dataKartu, List<Transaksi> transaksiKartu, List<Transaksi> listTransaksi) {

        // Pilihan Menu untuk E-Money
        Scanner menuInput = new Scanner(System.in);
        int menu;
        Double saldo = SaldoTerahir.SaldoTerahir(dataKartu, transaksiKartu, listTransaksi);

        do {
            System.out.println("1. Informasi rekening dan saldo");
            System.out.println("2. Mutasi rekening / history pergerakan rekening");
            System.out.println("3. Pembayaran pembelanjaan");
            System.out.print("Masukan angka : ");
            menu = menuInput.nextInt();
            
            if (menu < 0 || menu > 3) {
                System.out.println("Masukan angka sesuai pilihan yang ada");
            }

            switch (menu){
                case 1:
                    System.out.println("\n");
                    System.out.println("==============================");
                    System.out.println("Informasi Rekening dan Saldo Anda");
                    System.out.println("------------------------------");

                    System.out.println("Nomor Rekening : " + dataKartu.nomor_kartu);
                    System.out.printf("Saldo : %,.0f%n", saldo );

                    menu = BackMenu.BackMenu(menu, menuInput);
                    break;
                case 2:
                    Mutasi.mutasi(transaksiKartu);
                    menu = BackMenu.BackMenu(menu, menuInput);
                    break;
                case 3:
                    Pembayaran.pembayaranPembelanjaan(dataKartu, transaksiKartu, listTransaksi);
                    menu = BackMenu.BackMenu(menu, menuInput);
                    break;
            }
        } while (menu < 0 || menu > 3);
    }
}
