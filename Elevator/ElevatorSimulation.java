package Elevator;
import java.util.Scanner;
import java.util.Random;

public class ElevatorSimulation {
    public static void main(String[] args) {
        System.out.println("Selamat datang di Menara Sejati");

        // 1. Inputan nama paling sedikit 5 karakter, tamu wajib input ulang nama jika kurang dari 5 karakter
        Scanner namaInput = new Scanner(System.in);
        System.out.print("Tolong masukkan nama Anda [minimal 5 karakter] : ");
        String userNama = namaInput.nextLine();

        if (userNama.length() < 5) {
            do {
                System.out.println("Nama Anda harus lebih dari 4 karakter!");
                System.out.print("Tolong masukkan nama Anda [minimal 5 karakter] : ");
                
                userNama =  namaInput.nextLine();
            } while (userNama.length() < 5);
        }
        
        namaInput.close();
        System.out.println("Hello " + userNama + "! Selamat datang!");
        

        // 2.  Lantai penjemputan yang diinput tamu harus berada di rentang angka 1-10. 
        //     Tamu wajib input ulang lantai jika rentang angka yg diinput tidak valid
        Scanner penjemputanInput = new Scanner(System.in);
        System.out.print("Tolong masukkan lantai penjemputan (1 - 10) : ");
        int lantaiPenjemputan = penjemputanInput.nextInt();

        if (lantaiPenjemputan <= 0 || lantaiPenjemputan > 10) {
            do {
                System.out.println("Lantai penjemputan harus dalam rentang angka 1 - 10!");
                System.out.print("Tolong masukkan lantai penjemputan (1 - 10) : ");
                
                lantaiPenjemputan =  penjemputanInput.nextInt();
            } while (lantaiPenjemputan <= 0 || lantaiPenjemputan > 10);
        }

        penjemputanInput.close();
        // 3. Lantai tujuan yang diinput tamu harus berada di rentang angka 1-10. 
        //    Tamu wajib input ulang lantai jika rentang angka yg diinput tidak valid
        Scanner tujuanInput = new Scanner(System.in);
        System.out.print("Tolong masukkan lantai tujuan (1 - 10) : ");
        int lantaiTujuan = tujuanInput.nextInt();

        if (lantaiTujuan <= 0 || lantaiTujuan > 10) {
            do {
                System.out.println("Lantai tujuan harus dalam rentang angka 1 - 10!");
                System.out.print("Tolong masukkan lantai tujuan (1 - 10) : ");
                
                lantaiTujuan =  tujuanInput.nextInt();
            } while (lantaiTujuan <= 0 || lantaiTujuan > 10);
        }

        tujuanInput.close();
        // 6. Tamu boleh memasukkan lantai penjemputan dan lantai tujuan dengan angka yang sama. 
        //    Program akan mengeluarkan notifikasi bahwa dia tidak perlu naik lift. 
        //    Dan lift tidak perlu naik / turun untuk menjemput
        if (lantaiPenjemputan == lantaiTujuan) {
            System.out.println("Lantai penjembutan anda sama dengan lantai tujuan.");
            System.out.println("Anda tidak perlu naik lift.");
            return;
        }

        // 4. Posisi awal lift adalah “acak” dari lantai 1 - 10
        int posisiLift = new Random().nextInt(10) + 1;

        // 5. Simulasi pergerakan lift dalam bentuk cetakan ke layar output program. 
        //    Dari posisi lift acak, akan turun / naik menjemput ke lantai penjemputan, dan naik / turun ke lantai tujuan.
        System.out.println("Saat ini lift berada di lantai : "+ posisiLift);
        System.out.println("Mohon menunggu, lift akan segera bergerak menjemput Anda");

        for (posisiLift = posisiLift; posisiLift != lantaiPenjemputan;) {   
            if (posisiLift > lantaiPenjemputan) {
                posisiLift--;
                System.out.println("Lift turun ke lantai : "+ posisiLift);
            } else {
                posisiLift++;
                System.out.println("Lift naik ke lantai : "+ posisiLift);
            }
        }

        System.out.println("Lift sudah sampai di lokasi penjemputan, pintu lift terbuka");
        System.out.println("Silahkan masuk, Anda akan diantar ke lantai tujuan");

        for (posisiLift = posisiLift; posisiLift != lantaiTujuan;) {   
            if (posisiLift > lantaiTujuan) {
                posisiLift--;
                System.out.println("Lift turun ke lantai : "+ posisiLift);
            } else {
                posisiLift++;
                System.out.println("Lift naik ke lantai : "+ posisiLift);
            }
        }

        System.out.println("Lift sudah sampai di lokasi tujuan, pintu lift terbuka");
        System.out.println("Terima kasih, anda sudah sampai di lantai tujuan");
    }
}
