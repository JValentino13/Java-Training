package task_2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Kartu {
    String jenis_kartu;
    String nama_pemilik;
    String cabang_bank;
    int nomor_kartu;
    int pin_kartu;

    public Kartu(
        String jenis_kartu, 
        String nama_pemilik, 
        String cabang_bank, 
        int nomor_kartu, 
        int pin_kartu) 
    {
        this.jenis_kartu = jenis_kartu;
        this.nama_pemilik = nama_pemilik;
        this.cabang_bank = cabang_bank;
        this.nomor_kartu = nomor_kartu;
        this.pin_kartu = pin_kartu;
    }

}

class Transaksi {
    int nomor_kartu;
    String nama_transaksi;
    Double nominal;
    Double saldo_akhir;

    public Transaksi(
        int nomor_kartu,
        String nama_transaksi,
        Double nominal,
        Double saldo_akhir) 
    {
        this.nomor_kartu = nomor_kartu;
        this.nama_transaksi = nama_transaksi;
        this.nominal = nominal;
        this.saldo_akhir = saldo_akhir;
    }
}

public class soal_b {

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

        List<Transaksi> listTransaksi = Arrays.asList(
            // Saldo atm
            new Transaksi(101, "Saldo Awal", 1200000.00, 1200000.00),
            new Transaksi(0, "Saldo Awal", 50000000.00, 50000000.00),
            new Transaksi(0, "Saldo Awal", 250000.00, 250000.00),
            new Transaksi(0, "Saldo Awal", 75000.00, 75000.00),
            new Transaksi(0, "Saldo Awal", 150000.00, 150000.00),
            
            // Saldo E-money
            new Transaksi(0, "Saldo Awal", 50000.00, 50000.00),
            new Transaksi(0, "Saldo Awal", 180000.00, 180000.00),
            new Transaksi(0, "Saldo Awal", 100000.00, 100000.00)
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
        
        if (dataKartu.jenis_kartu == "atm") {
            atm(dataKartu);
        } else {
            e_money(dataKartu);
        }
    }

    public static void atm(Kartu dataKartu) {
        LinkedList<Transaksi> listTransaksi = new LinkedList<Transaksi>();

        // Pilihan menu untuk kartu ATM
        Scanner menuInput = new Scanner(System.in);
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

                    System.out.println("==============================");
                    System.out.println("999. Menu");
                    System.out.println("0. Keluar");
                    System.out.print("Masukkan angka : ");
                    menu = menuInput.nextInt();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("\n");
                    System.out.println("==============================");
                    System.out.println("Mutasi Rekening / History Pergerakan Rekening");
                    System.out.println("------------------------------");

                    System.out.println("Nomor Kartu     | Nama Transaksi    | Nominal   | Saldo Akhir");
                    if (listTransaksi.size() <= 0) {
                        System.out.println("Belum ada data Transaksi, harap melakukan transaksi terlebih dahulu");
                    } else {
                        for (var history : listTransaksi) {
                            System.out.println(
                                history.nomor_kartu + "         | " + 
                                history.nama_transaksi + "  | " + 
                                history.nominal + "  | " + 
                                history.saldo_akhir
                            );
                        }
                    }

                    System.out.println("==============================");
                    System.out.println("999. Menu");
                    System.out.println("0. Keluar");
                    System.out.print("Masukkan angka : ");
                    menu = menuInput.nextInt();
                    break;
                case 7:
                    System.out.println("\n");
                    System.out.println("==============================");
                    System.out.println("Pembayaran Pembelanjaan");
                    System.out.println("------------------------------");

                    Scanner nominalInput = new Scanner(System.in);
                    Double nominal = 0.0;
                    do {
                        System.out.print("Masukkan nominal Pembayaran : ");
                        nominal = nominalInput.nextDouble();

                        if (nominal <= 0) {
                            System.out.println("Nominal pembayaran minimal 1 rupiah");
                        }
                    } while (nominal <= 0);

                    Scanner pinInput = new Scanner(System.in);
                    int pin;
                    do {
                        System.out.print("Masukkan Pin untuk melanjutkan : ");
                        pin = pinInput.nextInt();

                        if (pin != dataKartu.pin_kartu) {
                            System.out.println("Pin salah, silahkan coba lagi");
                        }
                    } while (pin != dataKartu.pin_kartu);

                    listTransaksi.add( new Transaksi(dataKartu.nomor_kartu, "Pembayaran Pembelanjaan", nominal, nominal));

                    System.out.println("\n");
                    System.out.println("==============================");
                    System.out.println("Ringkasan Pembayaran");
                    System.out.println("------------------------------");

                    System.out.printf("Nominal Pembayaran : %,.0f%n", nominal);

                    System.out.println("==============================");
                    System.out.println("999. Menu");
                    System.out.println("0. Keluar");
                    System.out.print("Masukkan angka : ");
                    menu = menuInput.nextInt();
                    break;
            }
        } while (menu < 0 || menu > 7);
    }

    public static void e_money(Kartu dataKartu) {
        LinkedList<Transaksi> listTransaksi = new LinkedList<Transaksi>();

        // Pilihan Menu untuk E-Money
        Scanner menuInput = new Scanner(System.in);
        int menu;

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
                    Double saldo;
                    if (listTransaksi.size() <= 0) {
                        saldo = 0.0;
                    } else {
                        saldo = listTransaksi.getLast().saldo_akhir;
                    }
                    System.out.println("\n");
                    System.out.println("==============================");
                    System.out.println("Informasi Rekening dan Saldo Anda");
                    System.out.println("------------------------------");

                    System.out.println("Nomor Rekening : " + dataKartu.nomor_kartu);
                    System.out.printf("Saldo : %,.0f%n", saldo );

                    System.out.println("==============================");
                    System.out.println("999. Menu");
                    System.out.println("0. Keluar");
                    System.out.print("Masukkan angka : ");
                    menu = menuInput.nextInt();
                    break;
                case 2:
                    System.out.println("\n");
                    System.out.println("==============================");
                    System.out.println("Mutasi Rekening / History Pergerakan Rekening");
                    System.out.println("------------------------------");

                    System.out.println("Nomor Kartu     | Nama Transaksi    | Nominal   | Saldo Akhir");
                    if (listTransaksi.size() <= 0) {
                        System.out.println("Belum ada data Transaksi, harap melakukan transaksi terlebih dahulu");
                    } else {
                        for (var history : listTransaksi) {
                            System.out.println(
                                history.nomor_kartu + "         | " + 
                                history.nama_transaksi + "  | " + 
                                history.nominal + "  | " + 
                                history.saldo_akhir
                            );
                        }
                    }

                    System.out.println("==============================");
                    System.out.println("999. Menu");
                    System.out.println("0. Keluar");
                    System.out.print("Masukkan angka : ");
                    menu = menuInput.nextInt();
                    break;
                case 3:
                    System.out.println("\n");
                    System.out.println("==============================");
                    System.out.println("Pembayaran Pembelanjaan");
                    System.out.println("------------------------------");

                    Scanner nominalInput = new Scanner(System.in);
                    Double nominal = 0.0;
                    do {
                        System.out.print("Masukkan nominal Pembayaran : ");
                        nominal = nominalInput.nextDouble();

                        if (nominal <= 0) {
                            System.out.println("Nominal pembayaran minimal 1 rupiah");
                        }
                    } while (nominal <= 0);

                    listTransaksi.add( new Transaksi(dataKartu.nomor_kartu, "Pembayaran Pembelanjaan", nominal, nominal));

                    System.out.println("\n");
                    System.out.println("==============================");
                    System.out.println("Ringkasan Pembayaran");
                    System.out.println("------------------------------");

                    System.out.printf("Nominal Pembayaran : %,.0f%n", nominal);

                    System.out.println("==============================");
                    System.out.println("999. Menu");
                    System.out.println("0. Keluar");
                    System.out.print("Masukkan angka : ");
                    menu = menuInput.nextInt();
                    break;
            }
        } while (menu < 0 || menu > 3);
    }
}