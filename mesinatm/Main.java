package mesinatm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Kartu> listKartu = Arrays.asList(
            // Kartu atm
            new KartuAtm(101, 101, "Jonathan", "BCA"),
            new KartuAtm(102, 102, "Adit", "BNI"),
            new KartuAtm(103, 103, "Putra", "BRI"),
            new KartuAtm(104, 104, "Bintang", "BRI"),
            new KartuAtm(105, 105, "Sasa", "BCA"),

            // Kartu E-money
            new EMoney(106, 106),
            new EMoney(107, 107),
            new EMoney(108, 108)
        );

        List<Transaksi> listTransaksi = new LinkedList<>(
            Arrays.asList(
                // Saldo atm
                new Transaksi(101, "Pemasukan", 1200000.00, 1200000.00),
                new Transaksi(102, "Pemasukan", 50000000.00, 50000000.00),
                new Transaksi(103, "Pemasukan", 250000.00, 250000.00),
                new Transaksi(104, "Pemasukan", 75000.00, 75000.00),
                new Transaksi(105, "Pemasukan", 150000.00, 150000.00),
                
                // Saldo E-money
                new Transaksi(106, "Pemasukan", 50000.00, 50000.00),
                new Transaksi(107, "Pemasukan", 180000.00, 180000.00),
                new Transaksi(108, "Pemasukan", 100000.00, 100000.00)
            )
        );

        Kartu dataKartu = null;

        System.out.println("==============================");
        System.out.println("Program Simulasi Mesin ATM");
        System.out.println("==============================");
        
        Scanner input = new Scanner(System.in);
        int nomorKartu;
        
        do {
            System.out.print("Masukkan nomor kartu Anda : ");
            nomorKartu = InputValidation.integerValidation(input);

            for (Kartu data : listKartu) {
                if (data.nomorKartu == nomorKartu) {
                    dataKartu = data;
                    break;
                }
            }

            if (dataKartu.nomorKartu == 0) {
                System.out.println("Nomor kartu tidak ditemukan, silakan coba lagi");
            }
        } while (dataKartu.nomorKartu == 0);

        // Handle pin auth
        int pin;
        do {
            System.out.print("Masukkan Pin untuk melanjutkan : ");
            pin = InputValidation.integerValidation(input);

            if (pin != dataKartu.pinKartu) {
                System.out.println("Pin salah, silahkan coba lagi");
            }
        } while (pin != dataKartu.pinKartu);

        // Handle transaksi list`
        List<Transaksi> transaksiKartu = new LinkedList<>();
        for (Transaksi transaksi : listTransaksi) {
            if (transaksi.nomorKartu == dataKartu.nomorKartu) {
                transaksiKartu.add(transaksi);
            }
        }
        
        // Handle tipe
        if (dataKartu instanceof KartuAtm) {
            KartuAtm data = (KartuAtm) dataKartu;
            KartuAtm.menu(data, transaksiKartu, listKartu, listTransaksi, input);
        } else {
            EMoney data = (EMoney) dataKartu;
            EMoney.menu(data, transaksiKartu, listTransaksi, input);
        }
    }
}