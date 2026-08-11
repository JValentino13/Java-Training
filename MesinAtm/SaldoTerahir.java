package MesinAtm;

import java.util.LinkedList;
import java.util.List;

public class SaldoTerahir {
    public static Double SaldoTerahir(Kartu dataKartu, List<Transaksi> transaksiKartu, List<Transaksi> listTransaksi) {

        // Handle saldo
        Double saldo;
        if (transaksiKartu.size() <= 0) {
            saldo = 0.0;
        } else {
            saldo = transaksiKartu.get(transaksiKartu.size() - 1).saldo_akhir;
        }

        return saldo;
    }
}
