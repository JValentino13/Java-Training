package MesinAtm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Kartu> listKartu = Arrays.asList(
            // Kartu atm
            new Kartu("atm", "Jonathan", "BCA", 101, 101),
            new Kartu("atm", "Adit", "BNI", 102, 102),
            new Kartu("atm", "Putra", "BRI", 103, 103),
            new Kartu("atm", "Bintang", "BRI", 104, 104),
            new Kartu("atm", "Sasa", "BCA", 105, 105),

            // Kartu E-money
            new Kartu("e_money", "", "", 106, 106),
            new Kartu("e_money", "", "", 107, 107),
            new Kartu("e_money", "", "", 108, 108)
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

        Kartu dataKartu = new Kartu(null, null, null, 0, 0);

        System.out.println("==============================");
        System.out.println("Program Simulasi Mesin ATM");
        System.out.println("==============================");
        
        Scanner nomorKartuInput = new Scanner(System.in);
        int nomorKartu;
        
        do {
            System.out.print("Masukkan nomor kartu Anda : ");
            nomorKartu = nomorKartuInput.nextInt();

            for (var data : listKartu) {
                if (data.nomor_kartu == nomorKartu) {
                    dataKartu.jenis_kartu = data.jenis_kartu;
                    dataKartu.nama_pemilik = data.nama_pemilik;
                    dataKartu.cabang_bank = data.cabang_bank;
                    dataKartu.nomor_kartu = data.nomor_kartu;
                    dataKartu.pin_kartu = data.pin_kartu;
                }
            }

            if (dataKartu.nomor_kartu == 0) {
                System.out.println("Nomor kartu tidak ditemukan, silakan coba lagi");
            }
        } while (dataKartu.nomor_kartu == 0);

        // Handle pin auth
        Scanner pinInput = new Scanner(System.in);
        int pin;
        do {
            System.out.print("Masukkan Pin untuk melanjutkan : ");
            pin = pinInput.nextInt();

            if (pin != dataKartu.pin_kartu) {
                System.out.println("Pin salah, silahkan coba lagi");
            }
        } while (pin != dataKartu.pin_kartu);

        // Handle transaksi list
        List<Transaksi> transaksiKartu = new LinkedList<>();
        for (Transaksi transaksi : listTransaksi) {
            if (transaksi.nomor_kartu == dataKartu.nomor_kartu) {
                transaksiKartu.add(transaksi);
            }
        }
        
        // Handle tipe
        if (dataKartu.jenis_kartu.equals("atm")) {
            Atm.atm(dataKartu, transaksiKartu, listKartu, listTransaksi);
        } else {
            E_money.e_money(dataKartu, transaksiKartu, listTransaksi);
        }
    }
}