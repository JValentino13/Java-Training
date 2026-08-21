package taxcalculator;

class TaxCalculatorPpn10 implements TaxCalculator
{

    public Double calculate(Double amount) {
        Double pajak = amount * 0.1;
        
        return pajak;
    }
}
