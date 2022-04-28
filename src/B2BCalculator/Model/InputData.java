package B2BCalculator.Model;

import java.math.BigDecimal;

public class InputData {
    private BigDecimal netValue = BigDecimal.valueOf(8500);
    private FormOfTaxation formOfTaxation = FormOfTaxation.ZASADY_OGOLNE;
    private VAT vat = VAT._23;
    private ZUS zus = ZUS.PELNY_ZUS;
    private boolean dobrowolna_chorobowa = false;
    private Costs costs;

    public InputData withnetValue(BigDecimal netValue){
        this.netValue = netValue;
        return this;
    }

    public InputData withFormOfTaxation(FormOfTaxation formOfTaxation){
        this.formOfTaxation = formOfTaxation;
        return this;
    }

    public InputData withVAT(VAT vat){
        this.vat = vat;
        return this;
    }

    public InputData withZUS(ZUS zus){
        this.zus = zus;
        return this;
    }

    public FormOfTaxation getFormOfTaxation() {
        return formOfTaxation;
    }

    public VAT getVat() {
        return vat;
    }

    public ZUS getZus() {
        return zus;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public boolean isDobrowolna_chorobowa() {
        return dobrowolna_chorobowa;
    }

    public Costs getCosts() {
        return costs;
    }
}
