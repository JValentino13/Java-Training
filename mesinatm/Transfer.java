package mesinatm;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Transfer {
    public static void Transfer(
            Kartu dataKartu, 
            List<Transaksi> transaksiKartu,
            List<Kartu> listKartu, 
            List<Transaksi> allTransaksi,
            Scanner input
        ) {
        System.out.println("\n");
        System.out.println("==============================");
        System.out.println("Transfer");
        System.out.println("------------------------------");

        Double nominal = 0.0;
        Double saldo = SaldoTerahir.SaldoTerahir(dataKartu, transaksiKartu, allTransaksi);
        Double saldo_akhir = saldo;
        int norekFromInput;
        int norek = 0;

        // handle nomor rekening tujuan
        do {
            System.out.print("Masukkan nomor kartu/rekening tujuan : ");
            norekFromInput = InputValidation.integerValidation(input);
            
            for (Kartu data : listKartu) {
                if (data.nomorKartu == norekFromInput && data instanceof KartuAtm) {
                    norek = data.nomorKartu;
                }
            }

            if (norek == 0) {
                System.out.println("Nomor kartu/rekening tujuan tidak valid");
            } else if (norek == dataKartu.nomorKartu) {
                System.out.println("Nomor kartu/rekening tujuan tidak boleh nomor rekening kartu ini");
                norek = 0;
            }

        } while (norek == 0);

        // handle nominal transfer
        do {
            System.out.print("Masukkan nominal : ");
            nominal = InputValidation.doubleValidation(input);

            if (nominal <= 0) {
                System.out.println("Nominal tidak boleh 0");
            } else if (nominal > saldo) {
                System.out.println("Saldo anda tidak mencukupi");
                nominal = 0.0;
            } else {
                saldo_akhir = saldo - nominal;
            }

        } while (nominal <= 0);
        
        // handle transaksi di rekening tujuan
        List<Transaksi> transaksiRekTujuan = new LinkedList<>();    
        for (Transaksi transaksi : allTransaksi) {
            if (transaksi.nomorKartu == norek) {
                transaksiRekTujuan.add(transaksi);
            }
        }

        Double saldoRekeningTujuan;
        if (transaksiRekTujuan.size() <= 0) {
            saldoRekeningTujuan = 0.0;
        } else {
            saldoRekeningTujuan = transaksiRekTujuan.get(transaksiRekTujuan.size() - 1).saldo_akhir + nominal;     
        }
        
        allTransaksi.add( new Transaksi(norek, "Pemasukan Transfer", nominal, saldoRekeningTujuan));
        transaksiKartu.add( new Transaksi(dataKartu.nomorKartu, "Pengeluaran Transfer", nominal, saldo_akhir));

        // Ringkasan
        System.out.println("\n");
        System.out.println("==============================");
            System.out.println("Ringkasan Transfer");
        System.out.println("------------------------------");

        System.out.printf("Nominal Transfer : %,.0f%n", nominal);
    }

    
}
