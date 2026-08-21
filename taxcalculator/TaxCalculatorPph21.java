package taxcalculator;

class TaxCalculatorPph21 implements TaxCalculator
{
    public Double pajak;
    
    public Double calculate(Double amount) {
        Double pajak = 0.0;
        if (amount >= 500000000) {
            pajak = amount*0.3;
        } else if (amount >= 250000000 && amount < 500000000) {
            pajak = amount*0.25;
        } else if (amount >= 50000000 && amount < 250000000 ) {
            pajak = amount*0.15;
        } else if (amount >= 40000000 && amount < 50000000) {
            pajak = amount*0.05;
        }

        return pajak;
    }
}
