package TaxCalculator;

import java.util.Scanner;

interface TaxCalculator
{
    Double calculate(Double amount) throws Exception;
}

class TaxCalculatorPpn10 implements TaxCalculator
{
    public String jenisPajakLabel = "PPN 10% / Harga Exclude Tax";

    public Double calculate(Double amount) {
        Double pajak = amount * 0.1;
        
        return pajak;
    }
}

class TaxCalculatorPpn11 implements TaxCalculator
{
    public String jenisPajakLabel = "PPN 11% / Harga Exclude Tax";

    public Double calculate(Double amount) {
        Double pajak = amount * 0.11;
        
        return pajak;
    }
}

class TaxCalculatorPpn10IncludeTax implements TaxCalculator
{
    public String jenisPajakLabel = "PPN 10% / Harga Include Tax";

    public Double calculate(Double amount) {
        Double pajak = amount + (amount*0.1);
        
        return pajak;
    }
}

class TaxCalculatorPpn11IncludeTax implements TaxCalculator
{
    public String jenisPajakLabel = "PPN 11% / Harga Include Tax";

    public Double calculate(Double amount) {
        Double pajak = amount + (amount*0.11);
        
        return pajak;
    }
}

class TaxCalculatorPph21 implements TaxCalculator
{
    public Double pajak;
    public String jenisPajakLabel;
    
    public Double calculate(Double amount) {
        Double pajak = 0.0;
        jenisPajakLabel = "PPH 21 / Pajak dalam desimal";
        if (amount >= 500000000) {
            pajak = 0.3;
        } else if (amount >= 250000000 && amount < 500000000) {
            pajak = 0.25;
        } else if (amount >= 50000000 && amount < 250000000 ) {
            pajak = amount*0.15;
            jenisPajakLabel = "PPH 21 / Harga Exclude Tax";
        } else if (amount >= 40000000 && amount < 50000000) {
            pajak = amount*0.05;
            jenisPajakLabel = "PPH 21 / Harga Exclude Tax";
        } else {
        }

        return pajak;
    }
}

public class Main
{
    public static void main(String[] args) throws Exception {
        
        System.out.println("==============================");
        System.out.println("Program Perhitungan Pajak");
        System.out.println("==============================");
        

        Scanner jenisPajakInput = new Scanner(System.in);
        System.out.println("Pilih jenis pajak dengan mengetik angka jenis pajak dari list berikut!");
        System.out.println("1. PPN 10%");
        System.out.println("2. PPN 11%");
        System.out.println("3. PPH 21%");
        System.out.print("Masukan angka : ");
        int jenisPajak = jenisPajakInput.nextInt();

        if (jenisPajak < 0 || jenisPajak > 3) {
            do {
                System.out.println("Angka harus sesuai pilihan");
                System.out.println("angka : " + jenisPajak);
                System.out.print("Masukan angka : ");

                jenisPajak = jenisPajakInput.nextInt();
            } while (jenisPajak < 0 || jenisPajak > 3);
        }

        Scanner opsiPerhitunganInput = new Scanner(System.in);
        int opsiPerhitungan = 2;
        if (jenisPajak == 1 || jenisPajak == 2) {
            System.out.println("Pilih opsi perhitungan dari list berikut!");
            System.out.println("1. Harga Include Tax");
            System.out.println("2. harga Exclude Tax");
            System.out.print("Masukan angka : ");
            opsiPerhitungan = opsiPerhitunganInput.nextInt();

            if (opsiPerhitungan < 0 || opsiPerhitungan > 2) {
                do {
                    System.out.println("Angka harus sesuai pilihan");
                    System.out.print("Masukan angka : ");
    
                    opsiPerhitungan = opsiPerhitunganInput.nextInt();
                } while (opsiPerhitungan < 0 || opsiPerhitungan > 2);
            }
        }

        Scanner amountInput = new Scanner(System.in);
        System.out.print("Masukan nilai yang diinginkan dihitung pajaknya : ");
        Double amount = amountInput.nextDouble();

        if (amount <= 0) {
            do {
                System.out.println("Nilai harus lebih dari 0");
                System.out.print("Masukan nilai yang diinginkan dihitung pajaknya : ");
    
                amount = amountInput.nextDouble();
            } while (amount <= 0);
        }

        Double pajak = 0.0;
        String jenisPajakLabel = " ";
        switch (jenisPajak) {
            case 1:
                if (opsiPerhitungan == 1) {
                    TaxCalculatorPpn10IncludeTax ppn10In = new TaxCalculatorPpn10IncludeTax();
                    pajak = ppn10In.calculate(amount);
                    jenisPajakLabel = ppn10In.jenisPajakLabel;
                } else {
                    TaxCalculatorPpn10 ppn10Ex = new TaxCalculatorPpn10();
                    pajak = ppn10Ex.calculate(amount);
                    jenisPajakLabel = ppn10Ex.jenisPajakLabel;
                }
                break;
            case 2:
                if (opsiPerhitungan == 1) {
                    TaxCalculatorPpn11IncludeTax ppn11In = new TaxCalculatorPpn11IncludeTax();
                    pajak = ppn11In.calculate(amount);
                    jenisPajakLabel = ppn11In.jenisPajakLabel;
                } else {
                    TaxCalculatorPpn11 ppn11Ex = new TaxCalculatorPpn11();
                    pajak = ppn11Ex.calculate(amount);
                    jenisPajakLabel = ppn11Ex.jenisPajakLabel;
                }
                break;
            case 3:
                TaxCalculatorPph21 pph21 = new TaxCalculatorPph21();
                pajak = pph21.calculate(amount);
                jenisPajakLabel = pph21.jenisPajakLabel;
                break;
        }

        System.out.println("==============================");
        System.out.println("Hasil Perhitungan Pajak");
        System.out.println("------------------------------");
        System.out.println("Jenis Pajak : " + jenisPajakLabel);
        System.out.printf("Nilai amount : %,.2f%n", amount);
        if (jenisPajakLabel.contains("desimal")) {
            System.out.printf("Pajak : %,.2f%n", pajak, "");
        } else {
            System.out.printf("Pajak : %,.0f%n", pajak);
        }
    }
}