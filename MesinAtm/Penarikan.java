package MesinAtm;

import java.util.List;
import java.util.Scanner;

public class Penarikan {
    public static void Penarikan(Kartu dataKartu, List<Transaksi> transaksiKartu, List<Transaksi> listTransaksi) {
        System.out.println("\n");
        System.out.println("==============================");
        System.out.println("Penarikan Tunai");
        System.out.println("------------------------------");

        Scanner nominalInput = new Scanner(System.in);
        Double nominal = 0.0;
        Double saldo = SaldoTerahir.SaldoTerahir(dataKartu, transaksiKartu, listTransaksi);
        Double saldo_akhir = saldo;

        do {
            System.out.print("Masukkan nominal Penarikan : ");
            nominal = nominalInput.nextDouble();

            if (nominal <= 0) {
                System.out.println("Nominal Penarikan tidak boleh 0");
            }

            if (nominal > saldo) {
                System.out.println("Saldo anda tidak mencukupi");
                nominal = 0.0;
            } else {
                saldo_akhir = saldo - nominal;
            }
        } while (nominal <= 0);

        transaksiKartu.add( new Transaksi(dataKartu.nomor_kartu, "Penarikan Tunai", nominal, saldo_akhir));

        System.out.println("\n");
        System.out.println("==============================");
        System.out.println("Ringkasan Penarikan");
        System.out.println("------------------------------");

        System.out.printf("Nominal Penarikan : %,.0f%n", nominal);
    }
}
