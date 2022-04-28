package B2BCalculator.Model;

import java.math.BigDecimal;

public enum VAT {
    _0(0),
    _5(0.05),
    _8(0.08),
    _23(0.23);

    private double VATvalue;

    VAT(double VATvalue) {
        this.VATvalue = VATvalue;
    }

    public BigDecimal getVATvalue() {
        return BigDecimal.valueOf(VATvalue);
    }
}
