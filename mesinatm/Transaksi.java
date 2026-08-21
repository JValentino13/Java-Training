package mesinatm;

class Transaksi {
    int nomorKartu;
    String nama_transaksi;
    Double nominal;
    Double saldo_akhir;

    public Transaksi(
        int nomorKartu,
        String nama_transaksi,
        Double nominal,
        Double saldo_akhir) 
    {
        this.nomorKartu = nomorKartu;
        this.nama_transaksi = nama_transaksi;
        this.nominal = nominal;
        this.saldo_akhir = saldo_akhir;
    }
}