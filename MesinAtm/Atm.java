package MesinAtm;

import java.util.List;
import java.util.Scanner;

public class Atm {
    public static void atm(Kartu dataKartu, List<Transaksi> transaksiKartu, List<Kartu> listKartu, List<Transaksi> listTransaksi) {

        // Pilihan menu untuk kartu ATM
        Scanner menuInput = new Scanner(System.in);
        int menu;
        Double saldo = SaldoTerahir.SaldoTerahir(dataKartu, transaksiKartu, listTransaksi);

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
            menu = menuInput.nextInt();
            
            if (menu < 0 || menu > 7) {
                System.out.println("Masukan angka sesuai pilihan yang ada");
            }

            switch (menu){
                case 1:
                    System.out.println("\n");
                    System.out.println("==============================");
                    System.out.println("Informasi Rekening dan Saldo Anda");
                    System.out.println("------------------------------");

                    System.out.println("Nama Pemilik : " + dataKartu.nama_pemilik);
                    System.out.println("Nomor Rekening : " + dataKartu.nomor_kartu);
                    System.out.println("Cabang Bank : " + dataKartu.cabang_bank);
                    System.out.printf("Saldo : %,.0f%n", saldo );

                    menu = BackMenu.BackMenu(menu, menuInput);
                    break;
                case 2:
                    Penarikan.Penarikan(dataKartu, transaksiKartu, listTransaksi);
                    menu = BackMenu.BackMenu(menu, menuInput);
                    break;
                case 3:
                    Penyetoran.Penyetoran(dataKartu, transaksiKartu, listTransaksi);
                    menu = BackMenu.BackMenu(menu, menuInput);
                    break;
                case 4:
                    TransferTopup.TransferTopup(dataKartu, transaksiKartu, listKartu, listTransaksi, "atm");
                    menu = BackMenu.BackMenu(menu, menuInput);
                    break;
                case 5:
                    TransferTopup.TransferTopup(dataKartu, transaksiKartu, listKartu, listTransaksi, "e_money");
                    menu = BackMenu.BackMenu(menu, menuInput);
                    break;
                case 6:
                    Mutasi.mutasi(transaksiKartu);
                    menu = BackMenu.BackMenu(menu, menuInput);
                    break;
                case 7:
                    Pembayaran.pembayaranPembelanjaan(dataKartu, transaksiKartu, listTransaksi);
                    menu = BackMenu.BackMenu(menu, menuInput);
                    break;
            }
        } while (menu < 0 || menu > 7);
    }
}
