package mesinatm;

import java.util.List;
import java.util.Scanner;

public class EMoney extends Kartu {

    public EMoney(int nomorKartu, int pinKartu) {
        super(nomorKartu, pinKartu);
    }

    public static void menu(EMoney dataKartu, List<Transaksi> transaksiKartu, List<Transaksi> listTransaksi, Scanner input) {

        // Pilihan Menu untuk E-Money
        int menu;

        do {
            System.out.println("1. Informasi rekening dan saldo");
            System.out.println("2. Mutasi rekening / history pergerakan rekening");
            System.out.println("3. Pembayaran pembelanjaan");
            System.out.print("Masukan angka : ");
            menu = InputValidation.integerValidation(input);
            
            if (menu < 0 || menu > 3) {
                System.out.println("Masukan angka sesuai pilihan yang ada");
            }

            switch (menu){
                case 1:
                    Double saldo = SaldoTerahir.SaldoTerahir(dataKartu, transaksiKartu, listTransaksi);
                    informasiRekening(dataKartu, saldo);

                    menu = BackMenu.BackMenu(menu, input);
                    break;
                case 2:
                    Mutasi.mutasi(transaksiKartu);
                    menu = BackMenu.BackMenu(menu, input);
                    break;
                case 3:
                    Pembayaran.pembayaranPembelanjaan(dataKartu, transaksiKartu, listTransaksi, input);
                    menu = BackMenu.BackMenu(menu, input);
                    break;
            }
        } while (menu < 0 || menu > 3);
    }

    private static void informasiRekening(EMoney dataKartu, Double saldo) {
        System.out.println("\n");
        System.out.println("==============================");
        System.out.println("Informasi Rekening dan Saldo Anda");
        System.out.println("------------------------------");

        System.out.println("Nomor Rekening : " + dataKartu.nomorKartu);
        System.out.printf("Saldo : %,.0f%n", saldo );
    }
}