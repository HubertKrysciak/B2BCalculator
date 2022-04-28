package B2BCalculator.Service;

import B2BCalculator.Model.InputData;

import java.math.BigDecimal;

public interface VATcalculationService {
    BigDecimal calculate(InputData inputData);
}
