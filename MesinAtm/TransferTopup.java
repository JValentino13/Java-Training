package MesinAtm;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TransferTopup {
    public static void TransferTopup(
            Kartu dataKartu, 
            List<Transaksi> transaksiKartu,
            List<Kartu> listKartu, 
            List<Transaksi> allTransaksi, 
            String tipe
        ) {
        System.out.println("\n");
        System.out.println("==============================");
        if (tipe.equals("atm")) {
            System.out.println("Transfer");
        } else {
            System.out.println("TopUp E-Money");
        }
        System.out.println("------------------------------");

        Scanner nominalInput = new Scanner(System.in);
        Scanner norekInput = new Scanner(System.in);
        Double nominal = 0.0;
        Double saldo = SaldoTerahir.SaldoTerahir(dataKartu, transaksiKartu, allTransaksi);
        Double saldo_akhir = saldo;
        int norekFromInput;
        int norek = 0;
        Double saldoNorek;

        // handle nomor rekening tujuan
        do {
            System.out.print("Masukkan nomor kartu/rekening tujuan : ");
            norekFromInput = norekInput.nextInt();
            
            for (var data : listKartu) {
                if (data.nomor_kartu == norekFromInput && data.jenis_kartu.equals(tipe)) {
                    norek = data.nomor_kartu;
                }
            }
            if (norek == 0) {
                System.out.println("Nomor kartu/rekening tujuan tidak valid");
            }
        } while (norek == 0);

        // handle nominal transfer
        do {
            System.out.print("Masukkan nominal : ");
            nominal = nominalInput.nextDouble();

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
            if (transaksi.nomor_kartu == norek) {
                transaksiRekTujuan.add(transaksi);
            }
        }

        Double saldoRekeningTujuan;
        if (transaksiRekTujuan.size() <= 0) {
            saldoRekeningTujuan = 0.0;
        } else {
            saldoRekeningTujuan = transaksiRekTujuan.get(transaksiRekTujuan.size() - 1).saldo_akhir + nominal;     
        }
        
        if (tipe.equals("e_money") && saldoRekeningTujuan > 1000000) {
            saldoRekeningTujuan = transaksiRekTujuan.get(transaksiRekTujuan.size() - 1).saldo_akhir;
            Double maksimal = 1000000.00 - saldoRekeningTujuan;

            System.out.println("Saldo E-Money melebihi 1 Juta");
            System.out.printf("Maksimal nominal top up saat ini adalah : %,.0f%n", maksimal);

            nominal = 0.0;
            saldo_akhir = saldo;
        } else {
            if (tipe.equals("e_money")) {
                allTransaksi.add( new Transaksi(norek, "TopUp", nominal, saldoRekeningTujuan));
                transaksiKartu.add( new Transaksi(dataKartu.nomor_kartu, "Pengeluaran TopUp E-money", nominal, saldo_akhir));
            } else {
                allTransaksi.add( new Transaksi(norek, "Pemasukan Transfer", nominal, saldoRekeningTujuan));
                transaksiKartu.add( new Transaksi(dataKartu.nomor_kartu, "Pengeluaran Transfer", nominal, saldo_akhir));
            }
        }

        System.out.println("\n");
        System.out.println("==============================");
        if (tipe.equals("atm")) {
            System.out.println("Ringkasan Transfer");
        } else {
            System.out.println("Ringkasan TopUp");
        }
        System.out.println("------------------------------");

        System.out.printf("Nominal Transfer : %,.0f%n", nominal);
    }
}
