package mesinatm;

import java.util.List;
import java.util.Scanner;

public class Penyetoran {
    public static void Penyetoran(Kartu dataKartu, List<Transaksi> transaksiKartu, List<Transaksi> listTransaksi, Scanner input) {
        System.out.println("\n");
        System.out.println("==============================");
        System.out.println("Penyetoran Uang Tunai");
        System.out.println("------------------------------");

        Double nominal = 0.0;
        Double saldo = SaldoTerahir.SaldoTerahir(dataKartu, transaksiKartu, listTransaksi);
        Double saldo_akhir = saldo;

        do {
            System.out.print("Masukkan nominal Penyetoran : ");
            nominal = InputValidation.doubleValidation(input);

            if (nominal <= 0) {
                System.out.println("Nominal Penyetoran tidak boleh 0");
            }

            saldo_akhir = saldo + nominal;
        } while (nominal <= 0);

        transaksiKartu.add( new Transaksi(dataKartu.nomorKartu, "Penyetoran Uang Tunai", nominal, saldo_akhir));

        System.out.println("\n");
        System.out.println("==============================");
        System.out.println("Ringkasan Penyetoran");
        System.out.println("------------------------------");

        System.out.printf("Nominal Penyetoran : %,.0f%n", nominal);
    }
}
