package MesinAtm;

import java.util.List;
import java.util.Scanner;

public class Pembayaran {
    public static void pembayaranPembelanjaan(Kartu dataKartu, List<Transaksi> transaksiKartu, List<Transaksi> listTransaksi) {
        System.out.println("\n");
        System.out.println("==============================");
        System.out.println("Pembayaran Pembelanjaan");
        System.out.println("------------------------------");

        Scanner nominalInput = new Scanner(System.in);
        Double nominal = 0.0;
        Double saldo = SaldoTerahir.SaldoTerahir(dataKartu, transaksiKartu, listTransaksi);
        Double saldo_akhir = saldo;

        do {
            System.out.print("Masukkan nominal Pembayaran : ");
            nominal = nominalInput.nextDouble();

            if (nominal <= 0) {
                System.out.println("Nominal pembayaran minimal 1 rupiah");
            }

            if (nominal > saldo) {
                System.out.println("Saldo anda tidak mencukupi");
                nominal = 0.0;
            } else {
                saldo_akhir = saldo - nominal;
            }
        } while (nominal <= 0);

        if (dataKartu.jenis_kartu.equals("atm")) {
            Scanner pinInput = new Scanner(System.in);
            int pin;
            do {
                System.out.print("Masukkan Pin untuk melanjutkan : ");
                pin = pinInput.nextInt();
    
                if (pin != dataKartu.pin_kartu) {
                    System.out.println("Pin salah, silahkan coba lagi");
                }
            } while (pin != dataKartu.pin_kartu);
        }

        transaksiKartu.add( new Transaksi(dataKartu.nomor_kartu, "Pembayaran Pembelanjaan", nominal, saldo_akhir));

        System.out.println("\n");
        System.out.println("==============================");
        System.out.println("Ringkasan Pembayaran");
        System.out.println("------------------------------");

        System.out.printf("Nominal Pembayaran : %,.0f%n", nominal);
    }
}
