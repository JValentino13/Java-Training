package taxcalculator;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception {
        
        System.out.println("==============================");
        System.out.println("Program Perhitungan Pajak");
        System.out.println("==============================");
        

        Scanner input = new Scanner(System.in);
        System.out.println("Pilih jenis pajak dengan mengetik angka jenis pajak dari list berikut!");
        System.out.println("1. PPN 10%");
        System.out.println("2. PPN 11%");
        System.out.println("3. PPH 21%");
        System.out.print("Masukan angka : ");
        int jenisPajak = numberValidation(input);

        while (jenisPajak < 1 || jenisPajak > 3){
            System.out.println("Angka harus sesuai pilihan");
            System.out.println("angka : " + jenisPajak);
            System.out.print("Masukan angka : ");

            jenisPajak = numberValidation(input);
        } ;

        int opsiPerhitungan = 2;
        if (jenisPajak == 1 || jenisPajak == 2) {
            System.out.println("Pilih opsi perhitungan dari list berikut!");
            System.out.println("1. Harga Include Tax");
            System.out.println("2. harga Exclude Tax");
            System.out.print("Masukan angka : ");
            opsiPerhitungan = numberValidation(input);

            while (opsiPerhitungan < 1 || opsiPerhitungan > 2){
                System.out.println("Angka harus sesuai pilihan");
                System.out.print("Masukan angka : ");

                opsiPerhitungan = numberValidation(input);
            };
        }

        System.out.print("Masukan nilai yang diinginkan dihitung pajaknya : ");
        int amountInt = numberValidation(input);

        while (amountInt <= 0){
            System.out.println("Nilai harus lebih dari 0");
            System.out.print("Masukan nilai yang diinginkan dihitung pajaknya : ");

            amountInt = numberValidation(input);
        };

        Double amount = Double.valueOf(amountInt);
        Double pajak = 0.0;
        String jenisPajakLabel = " ";
        switch (jenisPajak) {
            case 1:
                if (opsiPerhitungan == 1) {
                    TaxCalculatorPpn10IncludeTax ppn10In = new TaxCalculatorPpn10IncludeTax();
                    pajak = ppn10In.calculate(amount);
                    jenisPajakLabel = "PPN 10% / Harga Include Tax";
                } else {
                    TaxCalculatorPpn10 ppn10Ex = new TaxCalculatorPpn10();
                    pajak = ppn10Ex.calculate(amount);
                    jenisPajakLabel = "PPN 10% / Harga Exclude Tax";
                }
                break;
            case 2:
                if (opsiPerhitungan == 1) {
                    TaxCalculatorPpn11IncludeTax ppn11In = new TaxCalculatorPpn11IncludeTax();
                    pajak = ppn11In.calculate(amount);
                    jenisPajakLabel = "PPN 11% / Harga Include Tax";
                } else {
                    TaxCalculatorPpn11 ppn11Ex = new TaxCalculatorPpn11();
                    pajak = ppn11Ex.calculate(amount);
                    jenisPajakLabel = "PPN 11% / Harga Exclude Tax";
                }
                break;
            case 3:
                TaxCalculatorPph21 pph21 = new TaxCalculatorPph21();
                pajak = pph21.calculate(amount);
                jenisPajakLabel = "PPH 21 /";
                if (amount >= 500000000) {
                    jenisPajakLabel += " 30%";
                } else if (amount >= 250000000 && amount < 500000000) {
                    jenisPajakLabel += " 25%";
                } else if (amount >= 50000000 && amount < 250000000 ) {
                    jenisPajakLabel += " 15%";
                } else if (amount >= 40000000 && amount < 50000000) {
                    jenisPajakLabel += " 5%";
                }
                break;
        }

        System.out.println("==============================");
        System.out.println("Hasil Perhitungan Pajak");
        System.out.println("------------------------------");
        System.out.println("Jenis Pajak : " + jenisPajakLabel);
        System.out.printf("Nilai amount : %,.2f%n", amount);
        System.out.printf("Pajak : %,.0f%n", pajak);

        input.close();
    }

    public static int numberValidation(Scanner input) {
        int menu;

        while (!input.hasNextInt()){
            System.out.println("Hanya boleh memasukan angka");
            System.out.print("Masukan angka : ");

            input.next();
        };

        return menu = input.nextInt();
    }
}