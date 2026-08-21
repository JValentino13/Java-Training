package mesinatm;

import java.util.List;

public class Mutasi {
    public static void mutasi(List<Transaksi> transaksiKartu) {
        System.out.println("\n");
        System.out.println("==============================");
        System.out.println("Mutasi Rekening / History Pergerakan Rekening");
        System.out.println("------------------------------");

        System.out.println("Nomor Kartu     | Nama Transaksi    | Nominal   | Saldo Akhir");
        if (transaksiKartu.size() <= 0) {
            System.out.println("Belum ada data Transaksi, harap melakukan transaksi terlebih dahulu");
        } else {
            for (Transaksi history : transaksiKartu) {
                System.out.println(
                    history.nomorKartu + "         | " + 
                    history.nama_transaksi + "      | " + 
                    history.nominal + "  | " + 
                    history.saldo_akhir
                );
            }
        }
    }
}
