package taxcalculator;

class TaxCalculatorPpn10IncludeTax implements TaxCalculator
{

    public Double calculate(Double amount) {
        Double pajak = amount - (amount*10/100);
        
        return pajak;
    }
}
