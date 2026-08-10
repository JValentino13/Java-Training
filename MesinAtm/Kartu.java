package MesinAtm;

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