package taxcalculator;

class TaxCalculatorPpn11IncludeTax implements TaxCalculator
{

    public Double calculate(Double amount) {
        Double pajak = amount - (amount*11/111);
        
        return pajak;
    }
}
