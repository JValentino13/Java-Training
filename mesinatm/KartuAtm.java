package mesinatm;

import java.util.List;
import java.util.Scanner;

public class KartuAtm extends Kartu {
    String namaPemilik;
    String cabangBank;

    public KartuAtm(int nomorKartu, int pinKartu, String namaPemilik, String cabangBank) {
        super(nomorKartu, pinKartu);
        this.namaPemilik = namaPemilik;
        this.cabangBank = cabangBank;
    }

    public static void menu(KartuAtm dataKartu, List<Transaksi> transaksiKartu, List<Kartu> listKartu, List<Transaksi> listTransaksi, Scanner input) {

        // Pilihan menu untuk kartu ATM
        int menu;

        do {
            System.out.println("Pilih menu dari list berikut!");
            System.out.println("1. Informasi rekening dan saldo");
            System.out.println("2. Penarikan tunai");
            System.out.println("3. Penyetoran uang tunai");
            System.out.println("4. Transfer antar kartu / rekening");
            System.out.println("5. Top-up e-money");
            System.out.println("6. Mutasi rekening / history pergerakan rekening");
            System.out.println("7. Pembayaran pembelanjaan");
            System.out.println("0. Keluar");
            System.out.print("Masukan angka : ");
            menu = InputValidation.integerValidation(input);
            
            if (menu < 0 || menu > 7) {
                System.out.println("Masukan angka sesuai pilihan yang ada");
            }

            switch (menu){
                case 1:
                    Double saldo = SaldoTerahir.SaldoTerahir(dataKartu, transaksiKartu, listTransaksi);
                    informasiRekening(dataKartu, saldo);

                    menu = BackMenu.BackMenu(menu, input);
                    break;
                case 2:
                    Penarikan.Penarikan(dataKartu, transaksiKartu, listTransaksi, input);
                    menu = BackMenu.BackMenu(menu, input);
                    break;
                case 3:
                    Penyetoran.Penyetoran(dataKartu, transaksiKartu, listTransaksi, input);
                    menu = BackMenu.BackMenu(menu, input);
                    break;
                case 4:
                    Transfer.Transfer(dataKartu, transaksiKartu, listKartu, listTransaksi, input);
                    menu = BackMenu.BackMenu(menu, input);
                    break;
                case 5:
                    TopUp.TopUp(dataKartu, transaksiKartu, listKartu, listTransaksi, input);
                    menu = BackMenu.BackMenu(menu, input);
                    break;
                case 6:
                    Mutasi.mutasi(transaksiKartu);
                    menu = BackMenu.BackMenu(menu, input);
                    break;
                case 7:
                    Pembayaran.pembayaranPembelanjaan(dataKartu, transaksiKartu, listTransaksi, input);
                    menu = BackMenu.BackMenu(menu, input);
                    break;
            }
        } while (menu < 0 || menu > 7);
    }

    private static void informasiRekening(KartuAtm dataKartu, Double saldo) {
        System.out.println("\n");
        System.out.println("==============================");
        System.out.println("Informasi Rekening dan Saldo Anda");
        System.out.println("------------------------------");

        System.out.println("Nama Pemilik : " + dataKartu.namaPemilik);
        System.out.println("Nomor Rekening : " + dataKartu.nomorKartu);
        System.out.println("Cabang Bank : " + dataKartu.cabangBank);
        System.out.printf("Saldo : %,.0f%n", saldo );
    }
}
