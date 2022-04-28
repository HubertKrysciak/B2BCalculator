package B2BCalculator.Service;

import B2BCalculator.Model.InputData;
import B2BCalculator.Model.VAT;

import java.math.BigDecimal;

public class VatcalculationServiceImplementation implements VATcalculationService {
    @Override
    public BigDecimal calculate(InputData inputData) {
        return inputData.getNetValue().multiply(inputData.getVat().getVATvalue());
    }
}
