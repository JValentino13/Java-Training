package taxcalculator;

class TaxCalculatorPpn11 implements TaxCalculator
{

    public Double calculate(Double amount) {
        Double pajak = amount * 0.11;
        
        return pajak;
    }
}
