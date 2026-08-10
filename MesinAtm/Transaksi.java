package MesinAtm;

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